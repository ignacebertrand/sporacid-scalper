package sporacidscalper.view.presentation;

import sporacidscalper.model.beans.AdresseBean;
import sporacidscalper.model.beans.TransactionBean;
import sporacidscalper.view.presentation.util.HtmlUtilities;

public class PresentationPaiement implements IPresentationPaiement
{
	/**
	 * Presentation logic for a payment form.
	 * @return A html formatted string for the payment form presentation
	 */
	public String presenterFormulairePaiement(TransactionBean transaction)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		htmlBuffer.append("<h2>Paiement sécurisé</h2>");
		
		htmlBuffer.append(presenterFormulaireInfoLivraison(transaction));
		htmlBuffer.append(presenterFormulaireInfoPaiement(transaction));
		
		htmlBuffer.append("<div class=\"payment-controller\">");
		htmlBuffer.append("<div class=\"generic-button payment-confirmation-button\">Confirmer le paiement</div>");
		htmlBuffer.append("</div>");
		
		return HtmlUtilities.formatHtml(htmlBuffer.toString());
	}
	
	/**
	 * Presentation logic for a delivery address information form.
	 * @return A html formatted string for the delivery address information form presentation
	 */
	private String presenterFormulaireInfoLivraison(TransactionBean transaction)
	{
		if(transaction == null)
			transaction = new TransactionBean();
		
		StringBuffer htmlBuffer = new StringBuffer();
		
		htmlBuffer.append("<h3>Informations livraison</h3>");

//		boolean hasName = transaction.getNom() != null;
//		htmlBuffer.append("<div class=\"payment-description-item\">");
//		htmlBuffer.append("<label for=\"name\" class=\"generic-label\">Nom :</label>");
//		htmlBuffer.append("<input type=\"text\" name=\"nom\" class=\"generic-textbox\" value=\"" + (hasName ? transaction.getNom() : "") + "\" />");
//		htmlBuffer.append("</div>");

		AdresseBean addrLivraison = transaction.getAdresseLivraison();
		
		if(addrLivraison == null)
			addrLivraison = new AdresseBean();
		
		boolean hasStreetNb = addrLivraison.getNoCivique() != null && addrLivraison.getNoCivique() > 0;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"streetnb\" class=\"generic-label\">No de rue :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"adresseLivraison.noCivique\" class=\"generic-textbox\" value=\"" + (hasStreetNb ? addrLivraison.getNoCivique() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasAppartmentNb = addrLivraison.getNoAppartement() != null && addrLivraison.getNoAppartement() > 0;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"streetnb\" class=\"generic-label\">No appart :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"adresseLivraison.noAppartement\" class=\"generic-textbox\" value=\"" + (hasAppartmentNb ? addrLivraison.getNoCivique() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasStreetName = addrLivraison.getNomRue() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"street\" class=\"generic-label\">Rue :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"adresseLivraison.nomRue\" class=\"generic-textbox\" value=\"" + (hasStreetName ? addrLivraison.getNomRue() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasCity = addrLivraison.getVille() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"city\" class=\"generic-label\">Ville :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"adresseLivraison.ville\" class=\"generic-textbox\" value=\"" + (hasCity ? addrLivraison.getVille() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasProvince = addrLivraison.getProvince() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"province\" class=\"generic-label\">Province :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"adresseLivraison.province\" class=\"generic-textbox\" value=\"" + (hasProvince ? addrLivraison.getProvince() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasZipCode = addrLivraison.getCodePostal() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"postalcode\" class=\"generic-label\">Code Postal :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"adresseLivraison.codePostal\" class=\"generic-textbox\" value=\"" + (hasZipCode ? addrLivraison.getCodePostal() : "") + "\" />");
		htmlBuffer.append("</div>");

		return htmlBuffer.toString();
	}
	
	/**
	 * Presentation logic for a payment information form.
	 * @return A html formatted string for the payment information form presentation
	 */
	private String presenterFormulaireInfoPaiement(TransactionBean transaction)
	{
		if(transaction == null)
			transaction = new TransactionBean();
		
		StringBuffer htmlBuffer = new StringBuffer();
		
		htmlBuffer.append("<h3>Informations paiement</h3>");
		
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"name\" class=\"generic-label\">Nom :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"name\" class=\"generic-textbox\" />");
		htmlBuffer.append("</div>");
		
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"cardnb\" class=\"generic-label\">No carte :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"cardnb\" class=\"generic-textbox\" />");
		htmlBuffer.append("</div>");
		
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"expirationdate\" class=\"generic-label\">Date expiration :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"expirationdate\" class=\"generic-textbox\" />");
		htmlBuffer.append("</div>");
		
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"cvvcode\" class=\"generic-label\">Code CVV :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"cvvcode\" class=\"generic-textbox\" />");
		htmlBuffer.append("</div>");
		
		return htmlBuffer.toString();
	}
}
