package sporacidscalper.view.presentation;

import java.util.List;

import sporacidscalper.model.beans.NouvelleBean;
import sporacidscalper.model.beans.SpectacleBean;

public interface IPresentationAccueil 
{
	/**
	 * Presentation logic for a news list object.
	 * @param listeNouvelles A list of news to present
	 * @return A html formatted string for the list of news presentation
	 */
	public String presenterNouvelles(List<NouvelleBean> listeNouvelles);
	/**
	 * Presentation logic for a upcoming shows list object.
	 * @param listeProchainsSpectacles A list of upcoming shows to present
	 * @return A html formatted string for the list of upcoming shows presentation
	 */
	public String presenterProchainSpectacles(List<SpectacleBean> listeProchainsSpectacles);
}
