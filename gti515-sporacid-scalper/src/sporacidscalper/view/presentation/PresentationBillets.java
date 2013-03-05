package sporacidscalper.view.presentation;

import java.text.DateFormat;
import java.util.List;

import sporacidscalper.model.beans.ArtisteBean;
import sporacidscalper.model.beans.RepresentationBean;
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
		
		for(int i=0;i < artistes.size();i++){

			artistesBuffer.append(ARTISTS_SEPARATOR);
			artistesBuffer.append(artistes.get(i).getNom());
		}
		
		if(artistesBuffer.length() > ARTISTS_SEPARATOR.length())
			htmlBuffer.append(artistesBuffer.substring(ARTISTS_SEPARATOR.length()));
		
		htmlBuffer.append("</h2>");
		
		return htmlBuffer.toString();
	}
	
	public String getRepresentationsListIem(List<RepresentationBean> representations)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		for(int i=0;i < representations.size();i++){
			
			if(representations.get(i).getDateDebutRepresentation() != null &&
			   representations.get(i).getDateFinRepresentation() != null)
			{
				htmlBuffer.append("<option value=");
				htmlBuffer.append(i);
				htmlBuffer.append(">Le ");
				htmlBuffer.append(dateFormatter.format(representations.get(i).getDateDebutRepresentation()));
				htmlBuffer.append(" ");
				htmlBuffer.append(timeFormatter.format(representations.get(i).getDateDebutRepresentation()));
				htmlBuffer.append(" à ");
				htmlBuffer.append(timeFormatter.format(representations.get(i).getDateFinRepresentation()));
				htmlBuffer.append("</option>");
			}
		}
		
		return htmlBuffer.toString();
	}
	
	public String getTypesListItem(List<TypeSpectacleBean> types)
	{
		StringBuffer htmlBuffer = new StringBuffer();
		
		for(int i=0;i < types.size();i++){
			
			htmlBuffer.append("<option value=");
			htmlBuffer.append(i);
			htmlBuffer.append(">");
			htmlBuffer.append(types.get(i).getNom());
			htmlBuffer.append("</option>");
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
