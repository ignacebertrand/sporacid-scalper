package sporacidscalper.controller.modelcontroller;

import java.util.List;

import sporacidscalper.model.Nouvelle;
import sporacidscalper.model.beans.NouvelleBean;
import sporacidscalper.model.persistence.StubFactory;

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
		//this.listeNouvelles = new ArrayList<Nouvelle>();
		this.listeNouvelles = StubFactory.getStubNouvelles();
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
	 * Public method to add a news to the system.
	 * @param nouvelleToAdd A news bean object that contains informations for the news to add
	 */
	public void ajouterNouvelle(NouvelleBean nouvelleToAdd)
	{
		Nouvelle nouvelle = (Nouvelle) nouvelleToAdd.getModelObject();
		
		listeNouvelles.add(nouvelle);
	}
	
	/**
	 * Public method to edit a news in the system.
	 * @param nouvelleToEdit A news bean that contains modifications to a news
	 */
	public void modifierNouvelle(NouvelleBean nouvelleToEdit)
	{
		//TODO : Need some sort of validation on nouvelleToEdit
		
		// Iterators are faster than indexed loops for ArrayList
		int i = 0;
		for(Nouvelle nouvelle : listeNouvelles)
		{
			if(nouvelle.getId() == nouvelleToEdit.getId())
			{
				listeNouvelles.set(i, (Nouvelle) nouvelleToEdit.getModelObject());
				break;
			}
			
			i++;
		}
		
	}
	
	/**
	 * Public method to delete a news from the system.
	 * @param nouvelleToDelete A news bean object that we wish to delete
	 */
	public void supprimerNouvelle(NouvelleBean nouvelleToDelete)
	{
		int i = 0;

		// Iterators are faster than indexed loops for ArrayList
		for(Nouvelle nouvelle : listeNouvelles)
		{
			if(nouvelle.getId() == nouvelleToDelete.getId())
			{
				listeNouvelles.remove(i);
				break;
			}
			
			i++;
		}
		
	}
	
	/**
	 * Public method to obtain all news from the system.
	 * @return The list of all news
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
		
		//TODO Sort by date
		
		return nouvelles;
	}
}
