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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.tracing.dtrace.Attributes;

import sporacidscalper.controller.modelcontroller.IGestionnaireSpectacle;
import sporacidscalper.model.beans.ItemPanierAchatBean;
import sporacidscalper.model.beans.PanierAchatBean;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;
import sporacidscalper.view.beans.FormulaireAjoutItemPanierAchat;

@Controller 
public class PanierAchatController implements ApplicationContextAware
{
	private static final String cCleSessionPanierAchat = "PanierAchat";
	
	/**
	 * Reference to the IGestionnaireSpectacle implementation
	 * of the application context bean configuration.
	 */
	private IGestionnaireSpectacle gestionnaireSpectacle;
	
	@RequestMapping(method = RequestMethod.GET, value = "/panier-achat")
	public ModelAndView getPanierAchat(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("panier_achat");
		
		mav.addObject("context", request.getContextPath());
		mav.addObject("panierAchat", obtenirPanierAchat(request.getSession()));
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/ajouter-item-panier-achat")
	public String ajouterItemPanierAchat(@ModelAttribute FormulaireAjoutItemPanierAchat form, 
			BindingResult result, HttpServletRequest request,
			@RequestHeader(value = "referer", required = true) final String referer)
	{
		SpectacleBean spectacle = gestionnaireSpectacle.obtenirSpectacle(form.getSpectacleId());
		RepresentationBean representation = spectacle.obtenirRepresentation(form.getRepresentationId());
		TypeBilletRepresentationBean representationType = representation.obtenirTypeBilletRepresentation(form.getTypeBilletId());

		PanierAchatBean panier = obtenirPanierAchat(request.getSession());
		ItemPanierAchatBean itemToAdd = new ItemPanierAchatBean(panier.getItems().size() + 1);
		
		itemToAdd.setQuantite(form.getQuantite());
		itemToAdd.setBilletRepresentation(representationType);
		
		panier.ajouterItem(itemToAdd);

		return "redirect:" + referer;
	}
	
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

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException 
	{
		// TODO Auto-generated method stub
		//gestionnaireClient = context.getBean("gestionnaireClient", IGestionnaireClient.class);
		gestionnaireSpectacle = context.getBean("gestionnaireSpectacle", IGestionnaireSpectacle.class);
	}
}
