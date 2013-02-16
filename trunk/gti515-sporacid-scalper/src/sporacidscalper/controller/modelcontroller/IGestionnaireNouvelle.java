package sporacidscalper.controller.modelcontroller;

import sporacidscalper.model.beans.NouvelleBean;

public interface IGestionnaireNouvelle 
{
	/**
	 * Public method to add a news to the system.
	 * @param nouvelleToAdd A news bean object that contains informations for the news to add
	 */
	public void ajouterNouvelle(NouvelleBean nouvelleToAdd);
	/**
	 * Public method to edit a news in the system.
	 * @param nouvelleToEdit A news bean that contains modifications to a news
	 */
	public void modifierNouvelle(NouvelleBean nouvelleToEdit);
	/**
	 * Public method to delete a news from the system.
	 * @param nouvelleToDelete A news bean object that we wish to delete
	 */
	public void supprimerNouvelle(NouvelleBean nouvelleToDelete);
	/**
	 * Public method to obtain all news from the system.
	 * @return The list of all news
	 */
	public NouvelleBean[] obtenirNouvelles();
}
