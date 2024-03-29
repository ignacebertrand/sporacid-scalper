package sporacidscalper.controller.modelcontroller;

import java.util.List;

import sporacidscalper.model.beans.NouvelleBean;

public interface IGestionnaireNouvelle 
{
	/**
	 * Public method to add a news to the system.
	 * @param nouvelleToAdd A news bean object that contains informations for the news to add
	 */
	public Integer ajouterNouvelle(NouvelleBean nouvelleToAdd);
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
	 * Public method to obtain a Nouvelle from the system.
	 * @param nouvelleId The Nouvelle unique id
	 * @return The Nouvelle bean associated with the Nouvelle
	 */
	public NouvelleBean obtenirNouvelle(int nouvelleId);
	
	/**
	 * Public method to obtain all news from the system.
	 * @return The list of all news
	 */
	public List<NouvelleBean> obtenirNouvelles();
}
