package sporacidscalper.controller.modelcontroller;

import java.util.List;
import java.util.Vector;

import sporacidscalper.model.Representation;
import sporacidscalper.model.Spectacle;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.TypeSpectacleBean;
import sporacidscalper.model.persistence.StubFactory;

public class GestionnaireSpectacle implements IGestionnaireSpectacle
{
	/**
	 * List of all Spectacle on which we'll do operations
	 */
	private List<Spectacle> listeSpectacles;

	/**
	 * Private constructor for the singleton
	 */
	public GestionnaireSpectacle()
	{
		this.listeSpectacles = (Vector<Spectacle>)StubFactory.getInstance().getStubSpectacles();
	}

	/**
	 * Public method to add a Spectacle to the system.
	 * @param spectacleToAdd A Spectacle bean object that contains informations for the Spectacle to add
	 */
	public void ajouterSpectacle(SpectacleBean spectacleToAdd)
	{
		//TODO : Need some sort of validation on the spectacle to add
		
		// Access listeSpectacles thread-safely.
		synchronized(listeSpectacles)
		{
			listeSpectacles.add((Spectacle) spectacleToAdd.getModelObject());
		}
	}

	/**
	 * Public method to edit a Spectacle in the system.
	 * @param spectacleToEdit A Spectacle bean object that contains modifications to a Spectacle
	 */
	public void modifierSpectacle(SpectacleBean spectacleToEdit)
	{
		int i = 0;
		//TODO : Need some sort of validation on the spectacle to edit
		
		// Access listeSpectacles thread-safely.
		synchronized(listeSpectacles)
		{
			// Iterators are faster than indexed loops for ArrayList
			for(Spectacle spectacle : listeSpectacles)
			{
				if(spectacle.getId() == spectacleToEdit.getId())
				{
					listeSpectacles.set(i, (Spectacle) spectacleToEdit.getModelObject());
					break;
				}
				
				i++;
			}
		}
	}

	/**
	 * Public method to delete a Spectacle from the system.
	 * If some Representation are still linked to Transaction, then the deletion won't happen.
	 * We cannot delete something that has a relationship to a transaction.
	 * @param spectacleToDelete A Spectacle bean object that we wish to delete
	 * @param transactionManager Inversion of control for the transaction manager 
	 */
	public void supprimerSpectacle(SpectacleBean spectacleToDelete, IGestionnaireTransaction transactionManager)
	{
		Spectacle spectacle = (Spectacle) spectacleToDelete.getModelObject();
		
		// Flag to check if we can delete the spectacle or not.
		boolean okForDeletion = true;
		for(Representation representation : spectacle.getRepresentations())
		{
			int transactionCount = transactionManager.obtenirTransactionsRepresentation(representation.getId()).length;
			
			if(transactionCount > 0)
			{
				//There's transaction linked to that Spectacle, we cannot delete it.
				okForDeletion = false;
				break;
			}
		}
		
		// Access listeSpectacles thread-safely.
		synchronized(listeSpectacles)
		{
			if(okForDeletion)
			{
				//Proceed with the deletion
				//listeSpectacles.get(spectacle.getId())
				listeSpectacles.remove(spectacle);
			}
		}
	}

	/**
	 * Public method to add a Representation to a Spectacle.
	 * @param spectacleId The Spectacle id to which we want to add a Representation
	 * @param representationToAdd A Representation bean that contains informations for the Representation to add
	 */
	public void ajouterRepresentation(int spectacleId, RepresentationBean representationToAdd)
	{
		Spectacle spectacleToEdit = null;
		
		// Access listeSpectacles thread-safely.
		synchronized(listeSpectacles)
		{
			for(Spectacle spectacle : listeSpectacles)
			{
				if(spectacle.getId() == spectacleId)
					spectacleToEdit = spectacle;
			}
		
			if(spectacleToEdit != null)
			{
				//TODO : Need some sort of validation on the representation to add
				
				spectacleToEdit.getRepresentations().add((Representation) representationToAdd.getModelObject());
			}
		}
	}

	/**
	 * Public method to edit a Representation of a Spectacle.
	 * @param spectacleId The Spectacle id to which we want to edit a Representation
	 * @param representationToEdit A Representation bean object that contains modifications to a Representation
	 */
	public void modifierRepresentation(int spectacleId, RepresentationBean representationToEdit)
	{
		Spectacle spectacleToEdit = null;
			
		// Access listeSpectacles thread-safely.
		synchronized(listeSpectacles)
		{
			for(Spectacle spectacle : listeSpectacles)
			{
				if(spectacle.getId() == spectacleId)
					spectacleToEdit = spectacle;
			}
			
			if(spectacleToEdit != null)
			{
				List<Representation> spectacleToEditRepresentations = spectacleToEdit.getRepresentations();
				
				// Iterators are faster than indexed loops for ArrayList
				int i = 0;
				for(Representation representation : spectacleToEditRepresentations)
				{
					if(representation.getId() == representationToEdit.getId())
					{
						//TODO : Need some sort of validation on the representation to edit
						
						spectacleToEditRepresentations.set(i, (Representation) representationToEdit.getModelObject());
						break;
					}
					
					i++;
				}
			}
		}
	}

	/**
	 * Public method to delete a Representation from a Spectacle.
	 * If the Representation is still linked to Transaction, then the deletion won't happen.
	 * We cannot delete something that has a relationship to a transaction.
	 * @param spectacleId The Spectacle id to which we want to delete a Representation
	 * @param representationToDelete A Representation bean object that we wish to delete
	 * @param transactionManager Inversion of control for the transaction manager
	 */
	public void supprimerRepresentation(RepresentationBean representationToDelete, IGestionnaireTransaction transactionManager)
	{
		Representation representation = (Representation) representationToDelete.getModelObject();
		// Flag checking if any transaction is binded to the representation object. Cannot delete object if 
		// one or more transaction is binded.
		boolean okForDeletion = transactionManager.obtenirTransactionsRepresentation(representation.getId()).length == 0;
		// Access listeSpectacles thread-safely.
		synchronized(listeSpectacles)
		{
			if(okForDeletion)
			{			
				// Iterators are faster than indexed loops for ArrayList
				int i = 0;
				for(Representation r : listeSpectacles.get(representation.getSpectacleId()).getRepresentations())
				{
					if(r.getId() == representation.getId())
					{
						listeSpectacles.get(r.getSpectacleId()).getRepresentations().remove(i);
						break;
					}
					i++;
				}
			}
		}
	}
	
	/**
	 * Public method to obtain a Spectacle from the system.
	 * @param spectacleId The Spectacle unique id
	 * @return The Spectacle bean associated with the Spectacle
	 */
	public SpectacleBean obtenirSpectacle(int spectacleId)
	{
		SpectacleBean spectacleToGet = null;
		
		// Access listeSpectacles thread-safely.
		synchronized(listeSpectacles)
		{
			for(Spectacle spectacle : listeSpectacles)
			{
				if(spectacle.getId() == spectacleId)
				{
					spectacleToGet = (SpectacleBean) spectacle.getBean();
					break;
				}
			}
		}
		
		return spectacleToGet;
	}
	
	/**
	 * Public method to obtain a Spectacle from the system.
	 * @param spectacleId The Spectacle unique id
	 * @return The Spectacle bean associated with the Spectacle
	 */
//	public SpectacleBean obtenirSpectacle(TypeBilletRepresentationBean typeRepresentation)
//	{
//		SpectacleBean spectacleToGet = null;
//		
//		// Access listeSpectacles thread-safely.
//		synchronized(listeSpectacles)
//		{
//			for(Spectacle spectacle : listeSpectacles)
//			{
//				if(spectacle.getId() == spectacleId)
//				{
//					spectacleToGet = (SpectacleBean) spectacle.getBean();
//					break;
//				}
//			}
//		}
//		
//		return spectacleToGet;
//	}
	
	/**
	 * Public method to obtain the list of all Spectacle in the system.
	 * @return The list of all Spectacle
	 */
	public SpectacleBean[] obtenirSpectacles()
	{	
		int i = 0;
		
		SpectacleBean[] spectacles = new SpectacleBean[listeSpectacles.size()];
	
		// Access listeSpectacles thread-safely.
		synchronized(listeSpectacles)
		{
			// Iterators are faster than indexed loops for ArrayList
			for(Spectacle spectacle : listeSpectacles)
			{
				spectacles[i] = (SpectacleBean)spectacle.getBean();
				i++;
			}
		}
		
		return spectacles;
	}

	/**
	 * Public method to get the number of ticket remaining for a Spectacle Representation.
	 * @return The number of ticket remaining
	 */
	public int obtenirNbBilletRestant(int spectacleId, int representationId)
	{
		//TODO : this method is kinda hard to do; we need to check the number of transactions 
		// done for the current spectacle and representation, plus we have an additional parameter (the ticket type)
		//that I haven't put.
		throw new UnsupportedOperationException();
	}
	
	/*public CategoryBean[] obtenirCategories()
	{
		int i = 0;
		CategoryBean[] categories = new CategoryBean[listeCategories.size()];
		
		// Access listeSpectacles thread-safely.
		synchronized(listeCategories)
		{
			// Iterators are faster than indexed loops for ArrayList
			for(Category category : listeCategories)
			{
				categories[i] = (CategoryBean) category.getBean();
				i++;
			}
		}
		
		return categories;
	}*/

	public TypeSpectacleBean[] obtenirTypesSpectacle() 
	{
		return null;
//		int i = 0;
//		CategoryBean[] categories = new CategoryBean[listeCategories.size()];
//		
//		// Access listeSpectacles thread-safely.
//		synchronized(listeCategories)
//		{
//			// Iterators are faster than indexed loops for ArrayList
//			for(Category category : listeCategories)
//			{
//				categories[i] = (CategoryBean) category.getBean();
//				i++;
//			}
//		}
//		
//		return categories;
	}
	
}