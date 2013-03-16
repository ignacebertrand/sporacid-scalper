package sporacidscalper.view.presentation;

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

		boolean hasName = transaction.getNom() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"name\" class=\"generic-label\">Nom :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"nom\" class=\"generic-textbox\" value=\"" + (hasName ? transaction.getNom() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"streetnb\" class=\"generic-label\">No de rue :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"streetnb\" class=\"generic-textbox\" />");
		htmlBuffer.append("</div>");
		
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"streetnb\" class=\"generic-label\">No appart :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"streetnb\" class=\"generic-textbox\" />");
		htmlBuffer.append("</div>");
		
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"street\" class=\"generic-label\">Rue :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"street\" class=\"generic-textbox\" />");
		htmlBuffer.append("</div>");
		
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"city\" class=\"generic-label\">Ville :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"city\" class=\"generic-textbox\" />");
		htmlBuffer.append("</div>");
		
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"province\" class=\"generic-label\">Province :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"province\" class=\"generic-textbox\" />");
		htmlBuffer.append("</div>");
		
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"postalcode\" class=\"generic-label\">Code Postal :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"postalcode\" class=\"generic-textbox\" />");
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
