package sporacidscalper.view.presentation;

import java.text.DateFormat;
import java.util.List;

import sporacidscalper.model.beans.ArtisteBean;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.TypeBilletBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;
import sporacidscalper.model.beans.TagsBean;
import sporacidscalper.model.beans.TypeSpectacleBean;

public class PresentationBillets implements IPresentationBillets
{
	/**
	 * Instance of a date formatter to format dates
	 */
	private DateFormat dateFormatter;

	/**
	 * Instance of a time formatter to format dates
	 */
	private DateFormat timeFormatter;
	
	private String ARTISTS_SEPARATOR = ", ";
	
	public String getAppendedArtists(List<ArtisteBean> artistes)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		StringBuffer artistesBuffer = new StringBuffer();
	
		htmlBuffer.append("<h2 class=\"event-list-item-content-artists\">");
		
		for(ArtisteBean artiste:artistes){

			artistesBuffer.append(ARTISTS_SEPARATOR);
			artistesBuffer.append(artiste.getNom());
		}
		
		if(artistesBuffer.length() > ARTISTS_SEPARATOR.length())
			htmlBuffer.append(artistesBuffer.substring(ARTISTS_SEPARATOR.length()));
		
		htmlBuffer.append("</h2>");
		
		return htmlBuffer.toString();
	}
	
	public String getRepresentationsListItem(List<RepresentationBean> representations)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		for(RepresentationBean representation : representations)
		{			
			if(representation.getDateDebutRepresentation() != null &&
			   representation.getDateFinRepresentation() != null)
			{
				htmlBuffer.append("<option value=\"");
				htmlBuffer.append(representation.getId());
				htmlBuffer.append("\">Le ");
				htmlBuffer.append(dateFormatter.format(representation.getDateDebutRepresentation()));
				htmlBuffer.append(" ");
				htmlBuffer.append(timeFormatter.format(representation.getDateDebutRepresentation()));
				htmlBuffer.append(" à ");
				htmlBuffer.append(timeFormatter.format(representation.getDateFinRepresentation()));
				htmlBuffer.append("</option>");
			}
		}
		
		return htmlBuffer.toString();
	}
	
	public String getTypesListItem(List<TypeSpectacleBean> types)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		for(int i = 0;i < types.size(); i++)
		{
			TypeSpectacleBean type = types.get(i);
			
			htmlBuffer.append("<option value=\"");
			htmlBuffer.append(type.getId());
			htmlBuffer.append("\">");
			htmlBuffer.append(type.getNom());
			htmlBuffer.append("</option>");
		}
		
		return htmlBuffer.toString();		
	}
	
	public String getTypesBilletsRpresentationListItem(List<TypeBilletRepresentationBean> typesBilletRepresentation)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		for(TypeBilletRepresentationBean typeBilletRepresentation : typesBilletRepresentation)
		{
			TypeBilletBean typeBillet = typeBilletRepresentation.getType();
			
			if(typeBillet != null)
			{
				htmlBuffer.append("<option value=\"");
				htmlBuffer.append(typeBillet.getId());
				htmlBuffer.append("\">");
				htmlBuffer.append(typeBillet.getNom());
				htmlBuffer.append("</option>");
			}
		}
		
		return htmlBuffer.toString();		
	}
	
	public String getTagsAnchors(List<ArtisteBean> artistes)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		for(ArtisteBean artiste : artistes)
		{
			for(TagsBean tag : artiste.getTags())
			{			
				htmlBuffer.append("<a class=\"event-list-item-tag\" href=");
				htmlBuffer.append(tag.getUrl());
				htmlBuffer.append(">");
				htmlBuffer.append(tag.getNom());
				htmlBuffer.append("</a>");
			}
		}
		
		return htmlBuffer.toString();		
	}
	
	/**
	 * Get the date formatter instance
	 * @return The DateFormat instance
	 */
	public DateFormat getDateFormatter() 
	{
		return dateFormatter;
	}

	/**
	 * Set the date formatter instance
	 * @return The DateFormat instance to set
	 */
	public void setDateFormatter(DateFormat dateFormatter) 
	{
		this.dateFormatter = dateFormatter;
	}
	
	/**
	 * Get the time formatter instance
	 * @return The DateFormat instance
	 */
	public DateFormat getTimeFormatter() 
	{
		return timeFormatter;
	}

	/**
	 * Set the time formatter instance
	 * @return The DateFormat instance to set
	 */
	public void setTimeFormatter(DateFormat timeFormatter) 
	{
		this.timeFormatter = timeFormatter;
	}
}
