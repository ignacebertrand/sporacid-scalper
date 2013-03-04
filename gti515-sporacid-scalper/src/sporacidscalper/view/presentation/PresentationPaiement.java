package sporacidscalper.view.presentation;

import sporacidscalper.model.beans.ClientBean;
import sporacidscalper.view.presentation.util.HtmlUtilities;

public class PresentationPaiement implements IPresentationPaiement
{
	/**
	 * 
	 * @return
	 */
	public String presenterFormulairePaiement(ClientBean client)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		htmlBuffer.append("<h2>Paiement sécurisé</h2>");
		
		htmlBuffer.append("<input type=\"hidden\" name=\"client.id\" />");
		
		htmlBuffer.append(presenterFormulaireInfoLivraison());
		htmlBuffer.append(presenterFormulaireInfoPaiement());
		
		htmlBuffer.append("<div class=\"payment-controller\">");
		htmlBuffer.append("<div class=\"generic-button payment-confirmation-button\">Confirmer le paiement</div>");
		htmlBuffer.append("</div>");
		
		return HtmlUtilities.formatHtml(htmlBuffer.toString());
	}
	
	/**
	 * 
	 * @return
	 */
	private String presenterFormulaireInfoLivraison()
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		htmlBuffer.append("<h3>Informations livraison</h3>");
		
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"name\" class=\"generic-label\">Nom :</label>");
		htmlBuffer.append("input type=\"text\" name=\"name\" class=\"generic-textbox\" />");
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
	 * 
	 * @return
	 */
	private String presenterFormulaireInfoPaiement()
	{
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
