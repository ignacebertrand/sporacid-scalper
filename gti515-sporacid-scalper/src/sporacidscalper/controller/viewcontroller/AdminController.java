package sporacidscalper.controller.viewcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sporacidscalper.controller.modelcontroller.IGestionnaireNouvelle;
import sporacidscalper.controller.modelcontroller.IGestionnaireSpectacle;

@Controller 
public class AdminController implements ApplicationContextAware
{
	
	/**
	 * Reference to the IGestionnaireNouvelle implementation
	 * of the application context bean configuration.
	 */
	private IGestionnaireSpectacle gestionnaireSpectacle;
	
	@RequestMapping("/admin")
	public ModelAndView getAdmin(ModelMap model, @ModelAttribute Object form, BindingResult result, HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("admin");
		mav.addObject("context", request.getContextPath());
		//model.addAttribute("context" , request.getContextPath());
		return mav;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		gestionnaireSpectacle = context.getBean("gestionnaireSpectacle", IGestionnaireSpectacle.class);
	}
}
