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

import sporacidscalper.controller.modelcontroller.IGestionnaireClient;

@Controller 
public class PanierAchatController implements ApplicationContextAware
{
	private IGestionnaireClient gestionnaireClient;
	
	@RequestMapping("/panier-achat")
	public String getPanierAchat(ModelMap model, @ModelAttribute Object form, BindingResult result, HttpServletRequest request)
	{
		String context = request.getContextPath();
		model.addAttribute("context", context);
		
		return "panier_achat";
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException 
	{
		// TODO Auto-generated method stub
		gestionnaireClient = context.getBean("gestionnaireClient", IGestionnaireClient.class);
	}
}
