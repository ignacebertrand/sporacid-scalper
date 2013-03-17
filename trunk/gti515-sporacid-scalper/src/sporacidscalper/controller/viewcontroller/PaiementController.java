package sporacidscalper.controller.viewcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sporacidscalper.controller.modelcontroller.IGestionnaireTransaction;
import sporacidscalper.controller.viewcontroller.util.ApplicationMessages;
import sporacidscalper.controller.viewcontroller.util.SessionUtil;
import sporacidscalper.model.beans.AdresseBean;
import sporacidscalper.model.beans.CommandeBean;
import sporacidscalper.model.beans.PanierAchatBean;
import sporacidscalper.model.beans.TransactionBean;
import sporacidscalper.view.beans.FormulairePaiementSecurise;
import sporacidscalper.view.presentation.IPresentationPaiement;
//import sporacidscalper.controller.modelcontroller.IGestionnaireClient;

@Controller 
public class PaiementController implements ApplicationContextAware
{
	/**
	 * Reference to the IGestionnaireClient implementation
	 * of the application context bean configuration.
	 */
	//private IGestionnaireClient gestionnaireClient;
	
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
	 * @param form
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/paiement-securise")
	public ModelAndView getPaiementSecurise(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("paiement");
		
		mav.addObject("formulaire", new FormulairePaiementSecurise());
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
	public ModelAndView traiterPaiementSecurise(@ModelAttribute @Valid FormulairePaiementSecurise form, 
			BindingResult result, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("confirmation_achat");
		
		// Invalid form, send it back to the user
		if(result.hasErrors()) 
		{
			// Add all error messages to the application messages
			for(ObjectError error : result.getAllErrors())
				ApplicationMessages.ajouterMessage(error.getDefaultMessage(), request);
			
			// Redirection
			mav = new ModelAndView("paiement");

			mav.addObject("formulaire", form);
		}
		// Valid form, do the transaction
		else
		{
			TransactionBean transaction = obtenirTransaction(form);

			// Transform the shopping cart into a command
			PanierAchatBean panierAchat = SessionUtil.obtenirPanierAchat(session);
			CommandeBean commande = panierAchat.creerCommande();
			
			// The shopping cart is now processed, destroy it.
			SessionUtil.supprimerPanierAchat(session);
			
			// Set the transaction's command
			transaction.setCommande(commande);
			
			gestionnaireTransaction.ajouterTransaction(transaction);
			
			mav.addObject("transaction", transaction);
		}
		
		mav.addObject("presentationPaiement", presentationPaiement);
	
		return mav;
	}
	
	/**
	 * Private method to transform a validated form from the client to a transaction.
	 * @param form A form submitted by the client
	 * @return a transaction object
	 */
	private TransactionBean obtenirTransaction(FormulairePaiementSecurise form)
	{
		TransactionBean transaction = new TransactionBean();
		AdresseBean addrLivraison = new AdresseBean();

		transaction.setNom(form.getNom());
		
		// TODO : Validate the payment with REST service
		
		transaction.setNoConfirmationPaiement((int)(Math.random() * 4000000) + 1000000);
		
		if(form.getNoCivique() != null)
			addrLivraison.setNoCivique(form.getNoCivique());
		
		if(form.getNoAppartement() != null)
			addrLivraison.setNoAppartement(form.getNoAppartement());
		
		addrLivraison.setNomRue(form.getNomRue());
		addrLivraison.setVille(form.getVille());
		addrLivraison.setProvince(form.getProvince());
		addrLivraison.setCodePostal(form.getCodePostal());
		
		transaction.setAdresseLivraison(addrLivraison);
		
		return transaction;
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
		//gestionnaireClient = context.getBean("gestionnaireClient", IGestionnaireClient.class);
		gestionnaireTransaction = context.getBean("gestionnaireTransaction", IGestionnaireTransaction.class);
		presentationPaiement = context.getBean("presentationPaiement", IPresentationPaiement.class);
	}
}
