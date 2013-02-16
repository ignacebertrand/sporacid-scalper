package sporacidscalper.controller.viewcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller; 
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import sporacidscalper.controller.modelcontroller.GestionnaireNouvelle;

import sporacidscalper.model.beans.NouvelleBean;

@Controller 
public class AccueilController 
{
	@RequestMapping("/accueil")
	public ModelAndView getAccueil(ModelMap model, @ModelAttribute Object form, BindingResult result, HttpServletRequest request)
	{
		String context = request.getContextPath();
		model.addAttribute("context", context);
		
		NouvelleBean[] listeNouvelles = GestionnaireNouvelle.getInstance().obtenirNouvelles();
		
		return new ModelAndView("accueil", "listeNouvelles", listeNouvelles);
	}
}
