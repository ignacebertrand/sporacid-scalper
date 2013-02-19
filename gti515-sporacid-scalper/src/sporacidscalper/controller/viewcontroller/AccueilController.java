package sporacidscalper.controller.viewcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sporacidscalper.controller.modelcontroller.IGestionnaireNouvelle;
import sporacidscalper.controller.modelcontroller.IGestionnaireSpectacle;

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
