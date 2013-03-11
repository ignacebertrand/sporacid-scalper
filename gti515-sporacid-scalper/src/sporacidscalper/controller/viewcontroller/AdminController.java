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
		//mav.addObject("context", request.getContextPath());
		mav.addObject("listeArtistes", gestionnaireSpectacle.obtenirCatalogueArtistes());
		mav.addObject("listeSalles", gestionnaireSpectacle.obtenirSalles());
		mav.addObject("listeSpectacles", gestionnaireSpectacle.obtenirCatalogueSpectacles());
		mav.addObject("listeTypesSpectacle", gestionnaireSpectacle.obtenirCatalogueTypeSpectacle());
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/admin/ajouter-spectacle")
	public String ajouterSpectacle(@ModelAttribute FormulaireAjoutSpectacle form, 
			BindingResult result, HttpServletRequest request,
			@RequestHeader(value = "referer", required = true) final String referer)
	{
	
		SpectacleBean spectacle = new SpectacleBean();
		
		//remove prints
		System.out.println("form.getNom : " + form.getNom());
		System.out.println("form.getDescription : " + form.getDescription());
		System.out.println("form.getPosterUrl : " + form.getPosterUrl());
		
		for(int i = 0; i < form.getArtistes().length; i++){
			System.out.println("form.getArtistes : " + form.getArtistes()[i]);
		}
		System.out.println("form.getType : " + form.getType());
		
		spectacle.setNom(form.getNom());
		spectacle.setDescription(form.getDescription());
		spectacle.setPosterUrl(form.getPosterUrl());
		spectacle.setArtistes(gestionnaireSpectacle.obtenirArtistes(form.getArtistes()));
		spectacle.setType(gestionnaireSpectacle.obtenirTypeSpectacle(form.getType()));
		
		gestionnaireSpectacle.ajouterSpectacle(spectacle);
		
		int length = gestionnaireSpectacle.obtenirCatalogueSpectacles().size();
		for(int i = 0; i < length; i++){
			System.out.println(gestionnaireSpectacle.obtenirCatalogueSpectacles().get(i).getId());
			System.out.println(gestionnaireSpectacle.obtenirCatalogueSpectacles().get(i).getNom());
			System.out.println(gestionnaireSpectacle.obtenirCatalogueSpectacles().get(i).getDescription());
			System.out.println(gestionnaireSpectacle.obtenirCatalogueSpectacles().get(i).getPosterUrl());
			for(int j = 0; j < gestionnaireSpectacle.obtenirCatalogueSpectacles().get(i).getArtistes().size(); j++){
				System.out.println(gestionnaireSpectacle.obtenirCatalogueSpectacles().get(i).getArtistes().get(j).getNom());
			}
			System.out.println(gestionnaireSpectacle.obtenirCatalogueSpectacles().get(i).getRepresentations());
		}
		return "redirect:" + referer;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		gestionnaireSpectacle = context.getBean("gestionnaireSpectacle", IGestionnaireSpectacle.class);
	}
}
