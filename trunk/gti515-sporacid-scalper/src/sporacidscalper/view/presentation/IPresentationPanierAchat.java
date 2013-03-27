package sporacidscalper.view.presentation;

import sporacidscalper.view.beans.PanierAchatBean;

public interface IPresentationPanierAchat 
{
	/**
	 * Presentation logic for a shopping cart object.
	 * @param panierAchat A shopping cart object to present.
	 * @return A html formatted string for the shopping cart presentation.
	 */
	public String presenterPanierAchat(PanierAchatBean panierAchat);
}
