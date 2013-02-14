package sporacidscalper.controller.viewcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller; 
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.ui.ModelMap;

@Controller 
public class BilletsController 
{
	@RequestMapping("/billets-musique")
	public String getBilletsMusique(ModelMap model, @ModelAttribute Object form, BindingResult result, HttpServletRequest request)
	{
		String context = request.getContextPath();
		model.addAttribute("context", context);
		
		return "billets_musique";
	}
	
	@RequestMapping("/billets-humour")
	public String getBilletsHumour(ModelMap model, @ModelAttribute Object form, BindingResult result, HttpServletRequest request)
	{
		String context = request.getContextPath();
		model.addAttribute("context", context);
		
		return "billets_humour";
	}
}
