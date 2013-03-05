package sporacidscalper.controller.viewcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sporacidscalper.controller.modelcontroller.IGestionnaireSpectacle;
import sporacidscalper.view.presentation.IPresentationBillets;

@Controller 
public class BilletsController implements ApplicationContextAware
{
	/**
	 * Reference to the IGestionnaireSpectacle implementation
	 * of the application context bean configuration.
	 */
	private IGestionnaireSpectacle gestionnaireSpectacle;

	/**
	 * Reference to the IPresentationAccueil implementation
	 * of the application context bean configuration.
	 */
	private IPresentationBillets presentationBillets;
	
	@RequestMapping(method = RequestMethod.GET, value = "/billets-musique")
	public ModelAndView getBilletsMusique(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("billets_musique");
		
		mav.addObject("context", request.getContextPath());
		mav.addObject("listeSpectacles", gestionnaireSpectacle.obtenirSpectacles());
		mav.addObject("listeTypes", gestionnaireSpectacle.obtenirCatalogueTypeSpectacle());
		mav.addObject("presentationBillets", presentationBillets);
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/billets-humour")
	public ModelAndView getBilletsHumour(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("billets_humour");
		
		mav.addObject("context", request.getContextPath());
		mav.addObject("listeSpectacles", gestionnaireSpectacle.obtenirSpectacles());
		
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
		gestionnaireSpectacle = context.getBean("gestionnaireSpectacle", IGestionnaireSpectacle.class);
		presentationBillets = context.getBean("presentationBillets", IPresentationBillets.class);
	}
}
