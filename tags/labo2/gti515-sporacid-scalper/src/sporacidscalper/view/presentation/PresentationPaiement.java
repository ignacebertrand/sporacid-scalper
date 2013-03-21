package sporacidscalper.view.presentation;

import java.text.NumberFormat;

import sporacidscalper.model.beans.TransactionBean;
import sporacidscalper.view.beans.FormulairePaiementSecurise;
import sporacidscalper.view.presentation.util.HtmlUtilities;

public class PresentationPaiement implements IPresentationPaiement
{
	/**
	 * Instance of a number formatter for format currencies in the sopping cart.
	 */
	private NumberFormat currencyFormatter;

	/**
	 * Presentation logic for a payment form.
	 * @return A html formatted string for the payment form presentation
	 */
	@Override
	public String presenterFormulairePaiement(FormulairePaiementSecurise formulaire)
	{
		if(formulaire == null)
			formulaire = new FormulairePaiementSecurise();
		
		StringBuffer htmlBuffer = new StringBuffer();
		
		htmlBuffer.append("<h2>Paiement sécurisé</h2>");
		
		htmlBuffer.append(presenterFormulaireInfoLivraison(formulaire));
		htmlBuffer.append(presenterFormulaireInfoPaiement(formulaire));
		
		htmlBuffer.append("<div class=\"payment-controller\">");
		htmlBuffer.append("<div class=\"generic-button payment-confirmation-button\">Confirmer le paiement</div>");
		htmlBuffer.append("</div>");
		
		return HtmlUtilities.formatHtml(htmlBuffer.toString());
	}
	
	/**
	 * Presentation logic for a delivery address information form.
	 * @return A html formatted string for the delivery address information form presentation
	 */
	private String presenterFormulaireInfoLivraison(FormulairePaiementSecurise formulaire)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		htmlBuffer.append("<h3>Informations livraison</h3>");
		
		boolean hasStreetNb = formulaire.getNoCivique() != null && formulaire.getNoCivique() > 0;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"noCivique\" class=\"generic-label\">No de rue :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"noCivique\" class=\"generic-textbox\" value=\"" + (hasStreetNb ? formulaire.getNoCivique() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasAppartmentNb = formulaire.getNoAppartement() != null && formulaire.getNoAppartement() > 0;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"noAppartement\" class=\"generic-label\">No appart :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"noAppartement\" class=\"generic-textbox\" value=\"" + (hasAppartmentNb ? formulaire.getNoCivique() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasStreetName = formulaire.getNomRue() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"nomRue\" class=\"generic-label\">Rue :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"nomRue\" class=\"generic-textbox\" value=\"" + (hasStreetName ? formulaire.getNomRue() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasCity = formulaire.getVille() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"ville\" class=\"generic-label\">Ville :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"ville\" class=\"generic-textbox\" value=\"" + (hasCity ? formulaire.getVille() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasProvince = formulaire.getProvince() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"province\" class=\"generic-label\">Province :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"province\" class=\"generic-textbox\" value=\"" + (hasProvince ? formulaire.getProvince() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasZipCode = formulaire.getCodePostal() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"codePostal\" class=\"generic-label\">Code Postal :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"codePostal\" class=\"generic-textbox\" value=\"" + (hasZipCode ? formulaire.getCodePostal() : "") + "\" />");
		htmlBuffer.append("</div>");

		return htmlBuffer.toString();
	}
	
	/**
	 * Presentation logic for a payment information form.
	 * @return A html formatted string for the payment information form presentation
	 */
	private String presenterFormulaireInfoPaiement(FormulairePaiementSecurise formulaire)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		htmlBuffer.append("<h3>Informations paiement</h3>");
		
		boolean hasName = formulaire.getNom() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"nom\" class=\"generic-label\">Nom :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"nom\" class=\"generic-textbox\" value=\"" + (hasName ? formulaire.getNom() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasCardNb = formulaire.getNoCarte() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"noCarte\" class=\"generic-label\">No carte :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"noCarte\" class=\"generic-textbox\" value=\"" + (hasCardNb ? formulaire.getNoCarte() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasExpDate = formulaire.getDateExpiration() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"dateExpiration\" class=\"generic-label\">Date expiration :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"dateExpiration\" class=\"generic-textbox\" value=\"" + (hasExpDate ? formulaire.getDateExpiration() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		boolean hasCvvCode = formulaire.getCodeCvv() != null;
		htmlBuffer.append("<div class=\"payment-description-item\">");
		htmlBuffer.append("<label for=\"codeCvv\" class=\"generic-label\">Code CVV :</label>");
		htmlBuffer.append("<input type=\"text\" name=\"codeCvv\" class=\"generic-textbox\" value=\"" + (hasCvvCode ? formulaire.getCodeCvv() : "") + "\" />");
		htmlBuffer.append("</div>");
		
		return htmlBuffer.toString();
	}

	@Override
	public String presenterConfirmationPaiement(TransactionBean transaction) 
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		htmlBuffer.append("<h2>Confirmation de l'achat</h2>");
		htmlBuffer.append("<p>Votre achat de " + currencyFormatter.format(transaction.getCommande().getTotal()) + " a été confirmé.</p>");
		htmlBuffer.append("<p>Le no de confirmation est : " + transaction.getNoConfirmationPaiement() + "</p>");
		
		return HtmlUtilities.formatHtml(htmlBuffer.toString());
	}
	
	public NumberFormat getCurrencyFormatter() {
		return currencyFormatter;
	}

	public void setCurrencyFormatter(NumberFormat currencyFormatter) {
		this.currencyFormatter = currencyFormatter;
	}
}
