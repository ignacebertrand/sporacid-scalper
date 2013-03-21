package sporacidscalper.view.presentation;

import java.text.DateFormat;
import java.util.List;

import sporacidscalper.model.beans.NouvelleBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.view.presentation.util.HtmlUtilities;

public class PresentationAccueil implements IPresentationAccueil
{
	/**
	 * Constant for the upcoming shows spinner item count max.
	 */
	private static final int cSpinnerMaxItemsCount = 5;
	
	/**
	 * Instance of a datetime formatter to format dates in the shopping cart.
	 */
	private DateFormat datetimeFormatter;
	
	/**
	 * Presentation logic for a news list object.
	 * @param listeNouvelles A list of news to present
	 * @return A html formatted string for the list of news presentation
	 */
	public String presenterNouvelles(List<NouvelleBean> listeNouvelles)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		if(listeNouvelles != null)
		{
			htmlBuffer.append("<h2>Nouvelles</h2>");
			htmlBuffer.append("<div class=\"news-list-container\">");
			htmlBuffer.append("<ul class=\"news-list\">");
			
			for(NouvelleBean nouvelle : listeNouvelles)
				htmlBuffer.append(presenterNouvelle(nouvelle));
			
			htmlBuffer.append("</ul>");
			htmlBuffer.append("</div>");
		}
		
		return HtmlUtilities.formatHtml(htmlBuffer.toString());
	}
	
	/**
	 * Presentation logic for a news object.
	 * @param nouvelle A news to present
	 * @return A html formatted string for the news presentation
	 */
	private String presenterNouvelle(NouvelleBean nouvelle)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		if(nouvelle != null)
		{
			htmlBuffer.append("<li class=\"news-list-item\">");
			htmlBuffer.append("<h3>" + nouvelle.getTitre() + "</h3>");
			htmlBuffer.append("<p>" + nouvelle.getDescription() + "</p>");
			htmlBuffer.append("<p class=\"news-signature\">" + nouvelle.getAuteur() + "</p>");
			htmlBuffer.append("<p class=\"news-date\">" + datetimeFormatter.format(nouvelle.getDate()) + "</p>");
			htmlBuffer.append("</li>");
		}
		
		return htmlBuffer.toString();
	}
	
	/**
	 * Presentation logic for a upcoming shows list object.
	 * @param listeProchainsSpectacles A list of upcoming shows to present
	 * @return A html formatted string for the list of upcoming shows presentation
	 */
	public String presenterProchainSpectacles(List<SpectacleBean> listeProchainsSpectacles)
	{
		StringBuffer htmlBuffer = new StringBuffer();

		if(listeProchainsSpectacles != null)
		{
			htmlBuffer.append("<h2>Prochains spectacles</h2>");
			htmlBuffer.append("<div class=\"upcoming-shows-spinner-container\">");
			htmlBuffer.append("<ul class=\"upcoming-shows-spinner-tabs\">");
			
			htmlBuffer.append("<li class=\"upcoming-shows-spinner-back\">&lt;</li>");
			
			for(int i = 0; i < cSpinnerMaxItemsCount; i++)
			{
				boolean isDisabled = i >= listeProchainsSpectacles.size();
				htmlBuffer.append("<li class=\"upcoming-shows-spinner-button" + (isDisabled ? " is-disabled" : "") + "\">" + (i + 1) + "</li>");
			}
			
			htmlBuffer.append("<li class=\"upcoming-shows-spinner-next\">&gt;</li>");
			
			htmlBuffer.append("</ul>");
			
			htmlBuffer.append("<div class=\"upcoming-shows-spinner-content\">");
			
			for(int i = 0; i < cSpinnerMaxItemsCount && i < listeProchainsSpectacles.size(); i++)
			{
				SpectacleBean spectacle = listeProchainsSpectacles.get(i);
				
				htmlBuffer.append("<div class=\"upcoming-shows-spinner-item\">");
				
				htmlBuffer.append("<div class=\"upcoming-shows-spinner-item-image\" style=\"background-image: url(" + spectacle.getPosterUrl() + ");\"></div>");
				htmlBuffer.append("<div class=\"upcoming-shows-spinner-item-description\">" + spectacle.getDescription() + "</div>");
				htmlBuffer.append("</div>");
			}
			
			htmlBuffer.append("</div>");
			htmlBuffer.append("</div>");
		}
	
		return HtmlUtilities.formatHtml(htmlBuffer.toString());
	}
	
	/**
	 * Get the datetime formatter instance
	 * @return The DateFormat instance
	 */
	public DateFormat getDatetimeFormatter() 
	{
		return datetimeFormatter;
	}

	/**
	 * Set the datetime formatter instance
	 * @return The DateFormat instance to set
	 */
	public void setDatetimeFormatter(DateFormat dateFormatter) 
	{
		this.datetimeFormatter = dateFormatter;
	}
}
