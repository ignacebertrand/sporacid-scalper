package sporacidscalper.controller.viewcontroller;

import javax.servlet.http.HttpServletRequest;

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

import sporacidscalper.controller.modelcontroller.IGestionnaireNouvelle;
import sporacidscalper.controller.modelcontroller.IGestionnaireSpectacle;
import sporacidscalper.model.beans.ItemPanierAchatBean;
import sporacidscalper.model.beans.PanierAchatBean;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;
import sporacidscalper.view.beans.FormulaireAjoutItemPanierAchat;

@Controller 
public class AccueilController implements ApplicationContextAware
{
	/**
	 * Reference to the IGestionnaireNouvelle implementation
	 * of the application context bean configuration.
	 */
	private IGestionnaireNouvelle gestionnaireNouvelle;
	
	/**
	 * Reference to the IGestionnaireSpectacle implementation
	 * of the application context bean configuration.
	 */
	private IGestionnaireSpectacle gestionnaireSpectacle;
	
	/**
	 * Public controller method to obtain  the homepage.
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/accueil")
	public ModelAndView getAccueil(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("accueil");
		
		mav.addObject("context", request.getContextPath());
		mav.addObject("listeNouvelles", gestionnaireNouvelle.obtenirNouvelles());
		mav.addObject("listeProchainsSpectacles", gestionnaireSpectacle.obtenirSpectacles());
		
		return mav;
	}

	/**
	 * Override for ApplicationContextAware interface
	 * Set the news manager for this controller to the one specified in the application context.
	 * Set the shows manager for this controller to the one specified in the application context.
	 * @param context The application context object
	 */	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException 
	{
		gestionnaireNouvelle = context.getBean("gestionnaireNouvelle", IGestionnaireNouvelle.class);
		gestionnaireSpectacle = context.getBean("gestionnaireSpectacle", IGestionnaireSpectacle.class);
	}
}
