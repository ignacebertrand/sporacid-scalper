package sporacidscalper.controller.modelcontroller.stubcontroller;

import java.util.ArrayList;
import java.util.List;

import sporacidscalper.controller.modelcontroller.IGestionnaireNouvelle;
import sporacidscalper.model.Nouvelle;
import sporacidscalper.model.beans.NouvelleBean;
import sporacidscalper.model.persistence.StubFactory;

public class GestionnaireStubNouvelle implements IGestionnaireNouvelle
{
	/**
	 * List of all news on which we'll do operations
	 */
	private List<Nouvelle> listeNouvelles;

	/**
	 * Private constructor for the singleton
	 */
	public GestionnaireStubNouvelle()
	{
		this.listeNouvelles = StubFactory.getInstance().getStubNouvelles();
	}
	
	/**
	 * Public method to add a news to the system.
	 * @param nouvelleToAdd A news bean object that contains informations for the news to add
	 */
	public Integer ajouterNouvelle(NouvelleBean nouvelleToAdd)
	{
		//TODO : Need some sort of validation on nouvelleToAdd
		
		// Access listeNouvelles thread-safely.
		synchronized(listeNouvelles)
		{
			listeNouvelles.add((Nouvelle) nouvelleToAdd.getModelObject());
		}
		
		return 1;
	}
	
	/**
	 * Public method to edit a news in the system.
	 * @param nouvelleToEdit A news bean that contains modifications to a news
	 */
	public void modifierNouvelle(NouvelleBean nouvelleToEdit)
	{
		int i = 0;
		
		//TODO : Need some sort of validation on nouvelleToEdit
		
		// Access listeNouvelles thread-safely.
		synchronized(listeNouvelles)
		{
			// Iterators are faster than indexed loops for ArrayList
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
	}
	
	/**
	 * Public method to delete a news from the system.
	 * @param nouvelleToDelete A news bean object that we wish to delete
	 */
	public void supprimerNouvelle(NouvelleBean nouvelleToDelete)
	{
		int i = 0;

		// Access listeNouvelles thread-safely.
		synchronized(listeNouvelles)
		{
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
	}
	
	/**
	 * Public method to obtain a Nouvelle from the system.
	 * @param nouvelleId The Nouvelle unique id
	 * @return The Nouvelle bean associated with the Nouvelle
	 */
	public NouvelleBean obtenirNouvelle(int nouvelleId)
	{
		NouvelleBean nouvelleToGet = null;
		
		// Access listeSpectacles thread-safely.
		synchronized(listeNouvelles)
		{
			for(Nouvelle nouvelle : listeNouvelles)
			{
				if(nouvelle.getId() == nouvelleId)
				{
					nouvelleToGet = (NouvelleBean) nouvelle.getBean();
					break;
				}
			}
		}
		
		return nouvelleToGet;
	}
	
	/**
	 * Public method to obtain all news from the system.
	 * @return The list of all news
	 */
	public List<NouvelleBean> obtenirNouvelles()
	{
		List<NouvelleBean> nouvelles = new ArrayList<NouvelleBean>();

		// Access listeNouvelles thread-safely.
		synchronized(listeNouvelles)
		{
			// Iterators are faster than indexed loops for ArrayList
			for(Nouvelle nouvelle : listeNouvelles)
				nouvelles.add((NouvelleBean) nouvelle.getBean());
		}
		
		//TODO Sort by date
		
		return nouvelles;
	}
}
