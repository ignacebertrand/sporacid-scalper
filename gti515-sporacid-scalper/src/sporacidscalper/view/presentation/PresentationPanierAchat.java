package sporacidscalper.view.presentation;

import java.text.DateFormat;
import java.text.NumberFormat;

import sporacidscalper.model.beans.ArtisteBean;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.TypeBilletBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;
import sporacidscalper.view.beans.ItemPanierAchatBean;
import sporacidscalper.view.beans.PanierAchatBean;
import sporacidscalper.view.presentation.util.HtmlUtilities;

public class PresentationPanierAchat implements IPresentationPanierAchat
{
	/**
	 * Instance of a date formatter to format dates in the shopping cart.
	 */
	private DateFormat dateFormatter;
	
	/**
	 * Instance of a number formatter for format currencies in the sopping cart.
	 */
	private NumberFormat currencyFormatter;

	/**
	 * Presentation logic for a shopping cart object.
	 * @param panierAchat A shopping cart object to present.
	 * @return A html formatted string for the shopping cart presentation.
	 */
	public String presenterPanierAchat(PanierAchatBean panierAchat)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		if(panierAchat != null && panierAchat.getItems().size() > 0)
		{
			htmlBuffer.append("<ul class=\"shopping-cart-item-list\">");
			
			for(ItemPanierAchatBean itemPanierAchat : panierAchat.getItems())
				htmlBuffer.append(presenterItemPanierAchat(itemPanierAchat));
			
			htmlBuffer.append("</ul>");
		}
		else
		{
			htmlBuffer.append("<div class=\"empty-shopping-cart-notification\">");
			htmlBuffer.append("<table><tr><td>");
			htmlBuffer.append("Votre panier d'achat est vide.");
			htmlBuffer.append("</table></tr></td>");
			htmlBuffer.append("</div>");
		}

		htmlBuffer.append("<div class=\"shopping-cart-item-list-controller\">");
		htmlBuffer.append("<label class=\"generic-label\">Total :</label>");
		htmlBuffer.append("<span class=\"shopping-cart-item-list-total\">" + currencyFormatter.format(panierAchat.getTotal()) + "</span>");
		htmlBuffer.append("<div class=\"generic-button shopping-cart-item-list-checkout-button\">");
		htmlBuffer.append("Procéder au paiement");
		htmlBuffer.append("</div>");
		htmlBuffer.append("</div>");
		
		return HtmlUtilities.formatHtml(htmlBuffer.toString());
	}
	
	/**
	 * 
	 * @param itemPanierAchat
	 * @return
	 */
	private String presenterItemPanierAchat(ItemPanierAchatBean itemPanierAchat)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		if(itemPanierAchat != null)
		{
			// Get the upper references if they exist.
			// (We expect the controller to set those references for the view)
			TypeBilletRepresentationBean typeBilletRepresentation = itemPanierAchat.getBilletRepresentation();
			RepresentationBean representation = null;
			SpectacleBean spectacle = null;
			
			if(typeBilletRepresentation != null)
			{
				representation = typeBilletRepresentation.getRepresentationReference();
				
				if(representation != null)
					spectacle = representation.getSpectacleReference();
			}
			
			// Instantiate default object because we don't want the presentation
			// to fail (Null reference).
			if(typeBilletRepresentation == null)
				typeBilletRepresentation = itemPanierAchat.getBilletRepresentation();
			
			if(representation == null)
				representation = new RepresentationBean();
			
			if(spectacle == null)
				spectacle = new SpectacleBean();
			
			StringBuffer artistesDesc = new StringBuffer();
			
			for(ArtisteBean artiste : spectacle.getArtistes())
				artistesDesc.append(artiste.getNom() + ", ");
			
			artistesDesc.replace(artistesDesc.length() - ", ".length(), artistesDesc.length() - 1, "");
			
			String itemTitle = spectacle.getDescription() + "  -  " + 
					typeBilletRepresentation.getType().getNom() + "  -  Prix unitaire : " +
					currencyFormatter.format(typeBilletRepresentation.getPrix());
			
			TypeBilletBean[] typesBillet = new TypeBilletBean[representation.getTypesBillet().size()];
			
			int i = 0;
			for(TypeBilletRepresentationBean availableTypeBillet : representation.getTypesBillet())
				typesBillet[i] = availableTypeBillet.getType();
			
			htmlBuffer.append("<li class=\"shopping-cart-item\">");
			htmlBuffer.append("<input class=\"shopping-cart-item-id\" type=\"hidden\" value=\"" + itemPanierAchat.getId() + "\" />");
			htmlBuffer.append("<input class=\"shopping-cart-item-spectacle-id\" type=\"hidden\" value=\"" + spectacle.getId() + "\" />");
			htmlBuffer.append("<div class=\"shopping-cart-item-image\" style=\"background-image: url(../" + spectacle.getPosterUrl() + ");\"></div>");
			htmlBuffer.append("<div class=\"shopping-cart-item-content\">");
			
			htmlBuffer.append("<div class=\"shopping-cart-item-desc\">");
			htmlBuffer.append("<h1 class=\"shopping-cart-item-title\">" + itemTitle + "</h1>");
			htmlBuffer.append("<h2 class=\"shopping-cart-item-artists\">" + artistesDesc + "</h2>");
			htmlBuffer.append("</div>");
			
			htmlBuffer.append("<div class=\"shopping-cart-item-controller\">");
			htmlBuffer.append("<label class=\"generic-label\">Représentation :</label>");
			htmlBuffer.append("<select class=\"generic-select shopping-cart-item-representation-select\">");
			
			for(RepresentationBean availableRepr : spectacle.getRepresentations())
			{
				boolean isSelected = availableRepr.equals(representation);
				htmlBuffer.append("<option value=\"" + availableRepr.getId() + "\"" + (isSelected ? "selected=\"selected\"" : "" ) + ">");
				htmlBuffer.append("Représentation du " + dateFormatter.format(availableRepr.getDateDebutRepresentation()));
				htmlBuffer.append("</option>");
			}
			
			htmlBuffer.append("</select>");
			
			htmlBuffer.append("<label class=\"generic-label\">Billet :</label>");
			htmlBuffer.append("<select class=\"generic-select shopping-cart-item-tickettype-select\">");

			for(TypeBilletBean availableTypeBillet : typesBillet) 
			{
				boolean isSelected = availableTypeBillet.equals(typeBilletRepresentation.getType());
				htmlBuffer.append("<option value=\"" + availableTypeBillet.getId() + "\"" + (isSelected ? "selected=\"selected\"" : "" ) + ">");
				htmlBuffer.append(availableTypeBillet.getNom());
				htmlBuffer.append("</option>");
			}
			
			htmlBuffer.append("</select>");
			
			htmlBuffer.append("<label class=\"generic-label\">Quantité :</label>");
			htmlBuffer.append("<select class=\"generic-select shopping-cart-item-quantity-select\">");
			
			for(int iQuantity = 1; iQuantity <= 6; iQuantity++) 
			{
				boolean isSelected = iQuantity == itemPanierAchat.getQuantite();
				htmlBuffer.append("<option value=\"" + iQuantity + "\"" + (isSelected ? "selected=\"selected\"" : "" ) + ">");
				htmlBuffer.append(iQuantity);
				htmlBuffer.append("</option>");
			}
			
			htmlBuffer.append("</select>");
			
			htmlBuffer.append("<label class=\"generic-label\">Total :</label>");
			htmlBuffer.append("<span class=\"shopping-cart-item-total\">" + currencyFormatter.format(itemPanierAchat.getTotal()) + "</span>");
			htmlBuffer.append("<div class=\"generic-button shopping-cart-delete-item-button\">&nbsp;</div>");
			htmlBuffer.append("</div>");
			htmlBuffer.append("</div>");
			
			htmlBuffer.append("</li>");
		}
		
		return htmlBuffer.toString();
	}

	public DateFormat getDateFormatter() {
		return dateFormatter;
	}

	public void setDateFormatter(DateFormat dateFormatter) {
		this.dateFormatter = dateFormatter;
	}

	public NumberFormat getCurrencyFormatter() {
		return currencyFormatter;
	}

	public void setCurrencyFormatter(NumberFormat currencyFormatter) {
		this.currencyFormatter = currencyFormatter;
	}
}
