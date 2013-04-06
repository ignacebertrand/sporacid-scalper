package sporacidscalper.controller.viewcontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
import sporacidscalper.model.beans.TransactionBean;
import sporacidscalper.view.beans.FormulairePaiementSecurise;
import sporacidscalper.view.beans.PanierAchatBean;
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
	 */
	private static final String cBaseUrl = "http://gti525.herokuapp.com/transactions";

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
		
		FormulairePaiementSecurise stub = new FormulairePaiementSecurise();
		
		stub.setNom("afag");
		stub.setNomRue("adgadahhadh");
		stub.setNoCivique(342);
		stub.setNoAppartement(12);
		stub.setProvince("qc");
		stub.setVille("laval");
		stub.setNoCarte("8675309000000000");
		stub.setDateExpiration("12/15");
		stub.setCodeCvv("123");
		stub.setCodePostal("h1h1h1");
		
		mav.addObject("formulaire", stub);
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
			
			// Fetch the shopping cart from the session
			PanierAchatBean panierAchat = SessionUtil.obtenirPanierAchat(session);
			
			// If the shopping cart exists, proceed.
			if(panierAchat != null && panierAchat.getItems().size() > 0)
			{
				// Transform the shopping cart into a command
				CommandeBean commande = panierAchat.creerCommande();
				
				// The shopping cart is now processed, destroy it.
				SessionUtil.supprimerPanierAchat(session);
				
				// Set the default status to the command
				commande.setStatut(gestionnaireTransaction.obtenirStatutCommandeParDefaut());
				
				// Set the transaction's command
				transaction.setCommande(commande);
				transaction.setTotalTransaction(commande.getTotal());
				
				if(preautoriserPaiement(transaction, form, request))
				{
					Integer transactionId = gestionnaireTransaction.ajouterTransaction(transaction);
					autoriserPaiement(transactionId, request);
				}
				
				mav.addObject("transaction", transaction);
			}
			// The shopping cart doesn't exist, cannot proceed.
			else
			{
				ApplicationMessages.ajouterMessage("Le panier d'achat est vide, impossible de procéder au paiement.", request);
				
				// Redirection
				mav = new ModelAndView("redirect: /accueil");
			}
		}
		
		mav.addObject("presentationPaiement", presentationPaiement);
	
		return mav;
	}
	
	private boolean autoriserPaiement(int transactionId, HttpServletRequest request)
	{
		JSONParser parser = new JSONParser();
        URL url = null;
        String link = cBaseUrl + "/" + transactionId + ".json?" +
				"api_key=faab9b7fb41cfc9c8995" + 	
				"&store_id=666";
				
		try {
				url = new URL(link);
		        URLConnection conn = url.openConnection();
		        ((HttpURLConnection) conn).setRequestMethod("GET");
		        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		       
		        String jsonString="";
		        String line; 
		        
		        while ((line = in.readLine()) != null)
		            jsonString += line;

		        JSONObject  jsonObject = (JSONObject) parser.parse( jsonString );	
		        jsonObject =  (JSONObject) jsonObject.get("order");
		        
		        String status = (String) jsonObject.get("status");
		        
		        if (status.equals("Completed")) {
		        	ApplicationMessages.ajouterMessage(jsonObject.get("messages").toString(), request);
	            }
		        
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	private boolean preautoriserPaiement(TransactionBean transaction, FormulairePaiementSecurise form, HttpServletRequest request)
	{
		JSONParser parser = new JSONParser();

        URL url = null;
        // Hard code ftw
        String[] splitExpDate = form.getDateExpiration().split("/");
        String month = splitExpDate[0];
        String year = splitExpDate[1];
        
        String link = cBaseUrl + ".json?" +
				"api_key=faab9b7fb41cfc9c8995" + 	
				"&order_id=121313" +
				"&store_id=666"	+
				"&amount="		+ transaction.getTotalTransaction() +
				"&first_name="	+ form.getNom() + 
				"&last_name="	+ form.getNom() +
				"&card_number="	+ form.getNoCarte()	+
				"&security_code=" + form.getCodeCvv() +
				"&year=" + "20" + year +
				"&month=" + month;
		try {
			url = new URL(link);
	        URLConnection conn = url.openConnection();
	        ((HttpURLConnection) conn).setRequestMethod("POST");
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	       
	        String jsonString="";
	        String line; 
	        
	        while ((line = in.readLine()) != null)
	            jsonString += line;
	        
	        JSONObject  jsonObject = (JSONObject) parser.parse( jsonString );	
	        jsonObject =  (JSONObject) jsonObject.get("order");
	        
	        String status = (String) jsonObject.get("status");
	        if (status.equals("Accepted")) {
            	ApplicationMessages.ajouterMessage(jsonObject.get("messages").toString(), request);
            	transaction.setNoConfirmationPaiement(Integer.valueOf(jsonObject.get("transaction_id").toString()));
//		        reponse.setCode((Integer.valueOf(jsonObject.get("code").toString())));
//		        reponse.setTransactionId(Integer.valueOf(jsonObject.get("transaction_id").toString()));
//		        reponse.setStatus( jsonObject.get("status").toString());
            }
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return true;
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
