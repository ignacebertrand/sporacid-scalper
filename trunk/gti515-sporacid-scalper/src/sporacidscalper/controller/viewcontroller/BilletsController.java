package sporacidscalper.controller.viewcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sporacidscalper.controller.modelcontroller.IGestionnaireSpectacle;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.RepresentationBean;
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
		mav.addObject("listeSpectacles", gestionnaireSpectacle.obtenirCatalogueSpectacles());
		mav.addObject("listeTypes", gestionnaireSpectacle.obtenirCatalogueTypeSpectacle());
		mav.addObject("presentationBillets", presentationBillets);
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/billets-humour")
	public ModelAndView getBilletsHumour(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("billets_humour");
		
		mav.addObject("context", request.getContextPath());
		mav.addObject("listeSpectacles", gestionnaireSpectacle.obtenirCatalogueSpectacles());
		mav.addObject("listeTypes", gestionnaireSpectacle.obtenirCatalogueTypeSpectacle());
		mav.addObject("presentationBillets", presentationBillets);
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/obtenir-types-billet-representation")
	public void getTicketType(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String options = "<option value=\"-1\">----</option>";
		
		if(request.getParameter("spectacleId") != null && request.getParameter("representationId") != null &&
		   request.getParameter("spectacleId") != "-1" && request.getParameter("representationId") != "-1")
		{
			int spectacleId 	 = Integer.parseInt(request.getParameter("spectacleId"));
			int representationId = Integer.parseInt(request.getParameter("representationId"));
			
			System.out.println("controller:  spectid: " + spectacleId + " represid: " + representationId);
			
			SpectacleBean spectacle = gestionnaireSpectacle.obtenirSpectacle(spectacleId);
			
			RepresentationBean representation = spectacle.obtenirRepresentation(representationId);
			
			if(representation != null)
				options = presentationBillets.getTypesBilletsRpresentationListItem(representation.getTypesBillet());
		}
		
		System.out.println("controller:  response: " + options);
		
		out.print(options);
		
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
