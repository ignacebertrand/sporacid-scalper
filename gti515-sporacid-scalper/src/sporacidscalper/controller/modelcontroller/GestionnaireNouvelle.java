package sporacidscalper.controller.modelcontroller;

import java.util.List;
import java.util.ArrayList;

import sporacidscalper.model.Nouvelle;
import sporacidscalper.model.beans.NouvelleBean;

public class GestionnaireNouvelle implements IGestionnaireNouvelle
{
	/**
	 * List of all news on which we'll do operations
	 */
	private List<Nouvelle> listeNouvelles;
	
	/**
	 * Singleton instance for the class
	 */
	private static GestionnaireNouvelle instance;

	/**
	 * Private constructor for the singleton
	 */
	private GestionnaireNouvelle()
	{
		this.listeNouvelles = new ArrayList<Nouvelle>();
	}
	
	/**
	 * Public method to obtain the singleton instance.
	 * @return The singleton instance
	 */
	public static GestionnaireNouvelle getInstance()
	{
		if(GestionnaireNouvelle.instance == null)
			GestionnaireNouvelle.instance = new GestionnaireNouvelle();
		
		return GestionnaireNouvelle.instance;
	}
	
	/**
	 * 
	 * @param nouvelleToAdd
	 */
	public void ajouterNouvelle(NouvelleBean nouvelleToAdd)
	{
		
	}
	
	/**
	 * 
	 * @param nouvelleToAdd
	 */
	public void modifierNouvelle(NouvelleBean nouvelleToEdit)
	{
		
	}
	
	/**
	 * 
	 * @param nouvelleToAdd
	 */
	public void supprimerNouvelle(NouvelleBean nouvelleToDelete)
	{
		
	}
	
	/**
	 * 
	 * @return
	 */
	public NouvelleBean[] obtenirNouvelles()
	{
		NouvelleBean[] nouvelles = new NouvelleBean[listeNouvelles.size()];
		
		int i = 0;
		// Iterators are faster than indexed loops for ArrayList
		for(Nouvelle nouvelle : listeNouvelles)
		{
			nouvelles[i] = (NouvelleBean) nouvelle.getBean();
			i++;
		}
		
		return nouvelles;
	}
}
