package sporacidscalper.controller.viewcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sporacidscalper.controller.modelcontroller.IGestionnaireSpectacle;
import sporacidscalper.controller.viewcontroller.util.SessionUtil;
import sporacidscalper.controller.viewcontroller.util.ApplicationMessages;
import sporacidscalper.model.beans.ItemPanierAchatBean;
import sporacidscalper.model.beans.PanierAchatBean;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;
import sporacidscalper.view.beans.FormulaireItemPanierAchat;
import sporacidscalper.view.presentation.IPresentationPanierAchat;

@Controller 
public class PanierAchatController implements ApplicationContextAware
{
	/**
	 * Reference to the IGestionnaireSpectacle implementation
	 * of the application context bean configuration.
	 */
	private IGestionnaireSpectacle gestionnaireSpectacle;
	
	/**
	 * Reference to the IPresentationPanierAchat implementation
	 * of the application context bean configuration.
	 */
	private IPresentationPanierAchat presentationPanierAchat;
	
	/**
	 * Public controller method to obtain the shopping cart page.
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/panier-achat")
	public ModelAndView getPanierAchat(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("panier_achat");
		
		//mav.addObject("context", request.getContextPath());
		mav.addObject("panierAchat", SessionUtil.obtenirPanierAchat(request.getSession()));
		mav.addObject("presentationPanierAchat", presentationPanierAchat);
		
		return mav;
	}
	
	/**
	 * Public controller method to add an item to the shopping cart.
	 * @param form
	 * @param result
	 * @param request
	 * @param referer
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/ajouter-item-panier-achat")
	public String ajouterItemPanierAchat(@ModelAttribute FormulaireItemPanierAchat form, 
			BindingResult result, HttpServletRequest request,
			@RequestHeader(value = "referer", required = true) final String referer)
	{
		HttpSession session = request.getSession();
		
		// Get the upper references to correctly instantiate the new item with all its references.
		SpectacleBean spectacle = gestionnaireSpectacle.obtenirSpectacle(form.getSpectacleId());
		RepresentationBean representation = spectacle.obtenirRepresentation(form.getRepresentationId());
		TypeBilletRepresentationBean representationType = representation.obtenirTypeBilletRepresentation(form.getTypeBilletId());
		
		// Set the upper references
		representationType.setRepresentationReference(representation);
		representation.setSpectacleReference(spectacle);
		
		// Get the shopping cart from the session
		PanierAchatBean panier = SessionUtil.obtenirPanierAchat(session);
		
		// Create a shopping cart item 
		ItemPanierAchatBean itemToAdd = new ItemPanierAchatBean(panier.getItems().size() + 1);
		itemToAdd.setQuantite(form.getQuantite());
		itemToAdd.setBilletRepresentation(representationType);
		
		// Add the item to the shopping cart if it doesnt already have 6 tickets of this show
		int qtyToAdd = form.getQuantite();

		if((panier.getNumberOfBillets() + qtyToAdd) <= 6){
			panier.ajouterItem(itemToAdd);
		} else {
			ApplicationMessages.ajouterMessage("Il y à déjà le nombre maximum de billets possible par transaction", request);
		}
		
		// Update shopping cart associated values
		SessionUtil.updateValeursPanierAchat(session);

		// Redirect to the previous page
		return "redirect:" + referer;
	}
	
	/**
	 * Public controller method to edit an item to the shopping cart.
	 * @param form
	 * @param result
	 * @param request
	 * @param referer
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/modifier-item-panier-achat")
	public String modifierItemPanierAchat(@ModelAttribute FormulaireItemPanierAchat form, 
			BindingResult result, HttpServletRequest request,
			@RequestHeader(value = "referer", required = true) final String referer)
	{
		HttpSession session = request.getSession();
		
		// Get the upper references to correctly instantiate the new item with all its references.
		SpectacleBean spectacle = gestionnaireSpectacle.obtenirSpectacle(form.getSpectacleId());
		RepresentationBean representation = spectacle.obtenirRepresentation(form.getRepresentationId());
		TypeBilletRepresentationBean representationType = representation.obtenirTypeBilletRepresentation(form.getTypeBilletId());
		
		// Set the upper references
		representationType.setRepresentationReference(representation);
		representation.setSpectacleReference(spectacle);
		
		// Get the shopping cart from the session
		PanierAchatBean panier = SessionUtil.obtenirPanierAchat(request.getSession());
		
		// Get the item reference to edit and edit it
		ItemPanierAchatBean itemToEdit = panier.obtenirItem(form.getItemId());
		int nbBillets = panier.getNumberOfBillets();
		
		if(((nbBillets - itemToEdit.getQuantite()) + form.getQuantite()) <= 6 ){
			itemToEdit.setQuantite(form.getQuantite());
			itemToEdit.setBilletRepresentation(representationType);
		} else {
			ApplicationMessages.ajouterMessage("Il y à déjà le nombre maximum de billets possible par transaction", request);
		}
		
		// Update shopping cart associated values
		SessionUtil.updateValeursPanierAchat(session);

		// Redirect to the previous page
		return "redirect:" + referer;
	}
	
	/**
	 * Public controller method to delete an item to the shopping cart.
	 * @param form
	 * @param result
	 * @param request
	 * @param referer
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/supprimer-item-panier-achat")
	public String supprimerItemPanierAchat(@ModelAttribute FormulaireItemPanierAchat form, 
			BindingResult result, HttpServletRequest request,
			@RequestHeader(value = "referer", required = true) final String referer)
	{
		HttpSession session = request.getSession();
		
		// Get the item id to delete
		int itemIdToDelete = form.getItemId();
		
		// Get the shopping cart from the session
		PanierAchatBean panier = SessionUtil.obtenirPanierAchat(session);
		
		// Delete the item
		panier.supprimerItem(itemIdToDelete);
		
		// Update shopping cart associated values
		SessionUtil.updateValeursPanierAchat(session);
		
		// Redirect to the previous page
		return "redirect:" + referer;
	}
	
	/**
	 * Public controller method to delete the shopping cart from the session
	 * @param request
	 * @param referer
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/supprimer-panier-achat")
	public String supprimerPanierAchat(HttpServletRequest request,
			@RequestHeader(value = "referer", required = true) final String referer)
	{
		SessionUtil.supprimerPanierAchat(request.getSession());
		
		// Redirect to the previous page
		return "redirect:" + referer;
	}
	
	/**
	 * Override for ApplicationContextAware interface
	 * Set the shows manager for this controller to the one specified in the application context.
	 * Set the presentation formatter for this controller to the one specified in the application context.
	 * @param context The application context object
	 */	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException 
	{
		gestionnaireSpectacle = context.getBean("gestionnaireSpectacle", IGestionnaireSpectacle.class);
		presentationPanierAchat = context.getBean("presentationPanierAchat", IPresentationPanierAchat.class);
	}
}
