package sporacidscalper.controller.viewcontroller;

import java.text.NumberFormat;
import java.text.DateFormat;

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
import sporacidscalper.model.beans.ItemPanierAchatBean;
import sporacidscalper.model.beans.PanierAchatBean;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;
import sporacidscalper.view.beans.FormulaireItemPanierAchat;

@Controller 
public class PanierAchatController implements ApplicationContextAware
{
	private static final String cCleSessionPanierAchat = "PanierAchat";
	
	/**
	 * Reference to the IGestionnaireSpectacle implementation
	 * of the application context bean configuration.
	 */
	private IGestionnaireSpectacle gestionnaireSpectacle;
	
	/**
	 * Reference to the DateFormat implementation 
	 * of the application context bean configuration.
	 */
	private DateFormat dateFormatter;
	
	/**
	 * Reference to the NumberFormat for currencies implementation 
	 * of the application context bean configuration.
	 */
	private NumberFormat currencyFormatter;
	
	/**
	 * Public controller method to obtain the shopping cart page.
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/panier-achat")
	public ModelAndView getPanierAchat(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("panier_achat");
		
		mav.addObject("context", request.getContextPath());
		mav.addObject("panierAchat", obtenirPanierAchat(request.getSession()));
		mav.addObject("dateFormatter", dateFormatter);
		mav.addObject("currencyFormatter", currencyFormatter);
		
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
		// Get the upper references to correctly instantiate the new item with all its references.
		SpectacleBean spectacle = gestionnaireSpectacle.obtenirSpectacle(form.getSpectacleId());
		RepresentationBean representation = spectacle.obtenirRepresentation(form.getRepresentationId());
		TypeBilletRepresentationBean representationType = representation.obtenirTypeBilletRepresentation(form.getTypeBilletId());
		
		// Set the upper references
		representationType.setRepresentationReference(representation);
		representation.setSpectacleReference(spectacle);
		
		// Get the shopping cart from the session
		PanierAchatBean panier = obtenirPanierAchat(request.getSession());
		
		// Create a shopping cart item 
		ItemPanierAchatBean itemToAdd = new ItemPanierAchatBean(panier.getItems().size() + 1);
		itemToAdd.setQuantite(form.getQuantite());
		itemToAdd.setBilletRepresentation(representationType);
		
		// Add the item to the shopping cart
		panier.ajouterItem(itemToAdd);

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
		// Get the upper references to correctly instantiate the new item with all its references.
		SpectacleBean spectacle = gestionnaireSpectacle.obtenirSpectacle(form.getSpectacleId());
		RepresentationBean representation = spectacle.obtenirRepresentation(form.getRepresentationId());
		TypeBilletRepresentationBean representationType = representation.obtenirTypeBilletRepresentation(form.getTypeBilletId());
		
		// Set the upper references
		representationType.setRepresentationReference(representation);
		representation.setSpectacleReference(spectacle);
		
		// Get the shopping cart from the session
		PanierAchatBean panier = obtenirPanierAchat(request.getSession());
		
		// Get the item reference to edit and edit it
		ItemPanierAchatBean itemToEdit = panier.obtenirItem(form.getItemId());
		itemToEdit.setQuantite(form.getQuantite());
		itemToEdit.setBilletRepresentation(representationType);

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
		// Get the item id to delete
		int itemIdToDelete = form.getItemId();
		
		// Get the shopping cart from the session
		PanierAchatBean panier = obtenirPanierAchat(request.getSession());
		
		// Delete the item
		panier.supprimerItem(itemIdToDelete);
		
		// Redirect to the previous page
		return "redirect:" + referer;
	}
	
	/**
	 * Private method to obtain the shopping cart from a session.
	 * @param session An Http Session object for the client's session
	 * @return The bean for the shopping cart
	 */
	private PanierAchatBean obtenirPanierAchat(HttpSession session)
	{
		PanierAchatBean panier = (PanierAchatBean) session.getAttribute(cCleSessionPanierAchat);
		
		if(panier == null)
		{
			panier = new PanierAchatBean();
			session.setAttribute(cCleSessionPanierAchat, panier);
		}
		
		return panier;
	}
	
	/**
	 * Override for ApplicationContextAware interface
	 * Set the shows manager for this controller to the one specified in the application context.
	 * Set the date formatter for this controller to the one specified in the application context.
	 * Set the currency formatter for this controller to the one specified in the application context.
	 * @param context The application context object
	 */	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException 
	{
		gestionnaireSpectacle = context.getBean("gestionnaireSpectacle", IGestionnaireSpectacle.class);
		dateFormatter = context.getBean("dateFormatter", DateFormat.class);
		currencyFormatter = context.getBean("currencyFormatter", NumberFormat.class);
	}
}