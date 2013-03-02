package sporacidscalper.controller.viewcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sporacidscalper.controller.modelcontroller.IGestionnaireSpectacle;
import sporacidscalper.model.beans.SpectacleBean;
//import sporacidscalper.view.beans.FormulaireAjoutSpectacle;
import sporacidscalper.view.beans.FormulaireAjoutSpectacle;

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
		mav.addObject("listeArtistes", gestionnaireSpectacle.obtenirArtistes());
		mav.addObject("listeSalles", gestionnaireSpectacle.obtenirSalles());
		mav.addObject("listeSpectacles", gestionnaireSpectacle.obtenirSpectacles());
		mav.addObject("listeTypesSpectacle", gestionnaireSpectacle.obtenirTypesSpectacle());
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/ajouter-spectacle")
	public String ajouterSpectacle(@ModelAttribute FormulaireAjoutSpectacle form, 
			BindingResult result, HttpServletRequest request,
			@RequestHeader(value = "referer", required = true) final String referer)
	{
	
		SpectacleBean spectacle = new SpectacleBean();
		
		spectacle.setNom(form.getNom());
		spectacle.setDescription(form.getDescription());
		spectacle.setPosterUrl(form.getPosterUrl());
		spectacle.setArtistes(form.getArtistes());
		spectacle.setType(form.getType());
		
		gestionnaireSpectacle.ajouterSpectacle(spectacle);
		
		int length = gestionnaireSpectacle.obtenirSpectacles().size();
		for(int i = 0; i < length; i++){
			System.out.println(gestionnaireSpectacle.obtenirSpectacles().get(i).getNom());
		}
		return "redirect:" + referer;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		gestionnaireSpectacle = context.getBean("gestionnaireSpectacle", IGestionnaireSpectacle.class);
	}
}
