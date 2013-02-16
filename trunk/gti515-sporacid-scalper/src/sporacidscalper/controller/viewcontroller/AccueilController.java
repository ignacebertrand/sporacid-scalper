package sporacidscalper.controller.viewcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller; 
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import sporacidscalper.controller.modelcontroller.IGestionnaireNouvelle;

@Controller 
public class AccueilController implements ApplicationContextAware
{
	/**
	 * 
	 */
	private IGestionnaireNouvelle gestionnaireNouvelle;
	
	@RequestMapping("/accueil")
	public ModelAndView getAccueil(ModelMap model, @ModelAttribute Object form, BindingResult result, HttpServletRequest request)
	{
		String context = request.getContextPath();
		model.addAttribute("context", context);
		
		return new ModelAndView("accueil", "listeNouvelles", gestionnaireNouvelle.obtenirNouvelles());
	}

	/**
	 * Override for ApplicationContextAware interface
	 * Set the news manager for this controller to the one specified in the application context.
	 * @param context The application context object
	 */	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException 
	{
		gestionnaireNouvelle = context.getBean("gestionnaireNouvelle", IGestionnaireNouvelle.class);
	}
}
