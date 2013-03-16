package sporacidscalper.controller.viewcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sporacidscalper.controller.modelcontroller.IGestionnaireClient;
import sporacidscalper.controller.modelcontroller.IGestionnaireTransaction;
import sporacidscalper.controller.viewcontroller.util.ApplicationMessages;
import sporacidscalper.model.beans.ClientBean;
import sporacidscalper.model.beans.TransactionBean;
import sporacidscalper.view.presentation.IPresentationPaiement;
//import sporacidscalper.controller.modelcontroller.IGestionnaireClient;

@Controller 
public class PaiementController implements ApplicationContextAware
{
	/**
	 * Reference to the IGestionnaireClient implementation
	 * of the application context bean configuration.
	 */
	private IGestionnaireClient gestionnaireClient;
	
	/**
	 * Reference to the IGestionnaireTransaction implementation
	 * of the application context bean configuration.
	 */
	private IGestionnaireTransaction gestionnaireTransaction;
	
	/**
	 * Reference to the IGestionnaireTransaction implementation
	 * of the application context bean configuration.
	 */
	private IPresentationPaiement presentationPaiement;
	
	/**
	 * 
	 */
	private Validator validator;

	/**
	 * 
	 * @param form
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/paiement-securise")
	public ModelAndView getPaiementSecurise(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("paiement");
		
		mav.addObject("client", new ClientBean());
		mav.addObject("presentationPaiement", presentationPaiement);
		
		// TODO aller chercher le client courant, mais il n'y a pas encore d'authentification, 
		//alors on supposera que c'Est un nouveau client
	
		return mav;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/traiter-paiement-securise")
	public ModelAndView traiterPaiementSecurise(@ModelAttribute @Valid TransactionBean form, 
			BindingResult result, HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("confirmation_achat");
		
		// Invalid form, send it back to the user
		if(result.hasErrors()) 
		{
			// Add all error messages to the application messages
			for(ObjectError error : result.getAllErrors())
				ApplicationMessages.ajouterMessage(error.getDefaultMessage(), request);
			
			// Redirection
			mav = new ModelAndView("paiement");
		}
		// Valid form, do the transaction
		else
		{
			//TODO Traiter la transaction
		}
		
		mav.addObject("transaction", new TransactionBean());
		mav.addObject("presentationPaiement", presentationPaiement);
	
		return mav;
	}

	/**
	 * Override for ApplicationContextAware interface
	 * Set the shows manager for this controller to the one specified in the application context.
	 * Set the presentation formatter for this controller to the one specified in the application context.
	 * @param context The application context object
	 */	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException 
	{
		gestionnaireClient = context.getBean("gestionnaireClient", IGestionnaireClient.class);
		gestionnaireTransaction = context.getBean("gestionnaireTransaction", IGestionnaireTransaction.class);
		presentationPaiement = context.getBean("presentationPaiement", IPresentationPaiement.class);
		validator = context.getBean("validator", Validator.class);
	}
}
