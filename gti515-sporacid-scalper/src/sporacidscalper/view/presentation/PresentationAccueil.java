package sporacidscalper.view.presentation;

import java.text.DateFormat;
import java.util.List;

import sporacidscalper.model.beans.NouvelleBean;
import sporacidscalper.model.beans.SpectacleBean;

public class PresentationAccueil implements IPresentationAccueil
{
	/**
	 * Instance of a date formatter to format dates in the shopping cart.
	 */
	private DateFormat dateFormatter;
	
	/**
	 * Presentation logic for a news list object.
	 * @param listeNouvelles A list of news to present
	 * @return A html formatted string for the list of news presentation
	 */
	public String presenterNouvelles(List<NouvelleBean> listeNouvelles)
	{
		return "";
	}
	
	/**
	 * Presentation logic for a upcoming shows list object.
	 * @param listeProchainsSpectacles A list of upcoming shows to present
	 * @return A html formatted string for the list of upcoming shows presentation
	 */
	public String presenterProchainSpectacles(List<SpectacleBean> listeProchainsSpectacles)
	{
		return "";
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
}
