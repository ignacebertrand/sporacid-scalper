package sporacidscalper.controller.modelcontroller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sporacidscalper.controller.modelcontroller.IGestionnaireNouvelle;
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
	 * Reference to the SessionFactory implementation
	 * of the application context bean configuration.
	 */
	private SessionFactory sessionFactory;
	
	/**
	 * Private constructor for the singleton
	 */
	public GestionnaireNouvelle()
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
		
		Integer entityId = null;
		
		// Get a nouvelle entity from the bean supplied
		Nouvelle entity = (Nouvelle) nouvelleToAdd.getModelObject();
		
		// If the entity is a non-null object
		if(entity != null)
		{
			// Get a session from the session factory
			Session session = sessionFactory.openSession();
			
			// Transaction object to wrap the database save operation
			Transaction tx = null;
			
			try
			{
				// Try to begin a transaction
				tx = session.beginTransaction();
				
				// Save the entity to the database
				entityId = (Integer) session.save(entity);
				
				// Commit the transaction
				tx.commit();
			}
			catch(HibernateException e)
			{
				// An error occured; rollback the transaction
				tx.rollback();
			}
			finally
			{
				// Always close the session
				session.close();
			}
		}
		
		// Return the id of the saved transaction or null
		return entityId;
		
	}
	
	/**
	 * Public method to edit a news in the system.
	 * @param nouvelleToEdit A news bean that contains modifications to a news
	 */
	public void modifierNouvelle(NouvelleBean nouvelleToEdit)
	{
		Session session = sessionFactory.openSession(); 
		Transaction tx = null; 
		
		// Get a nouvelle entity from the bean supplied
		Nouvelle entity = (Nouvelle) nouvelleToEdit.getModelObject();
		
		// If the entity is a non-null object
		if(entity != null)
		{
			try
			{ 
				tx = session.beginTransaction(); 
				session.update(entity); 
				tx.commit(); 
			}
			catch (HibernateException e) 
			{ 
				if (tx!=null) 
					tx.rollback(); 
				
				e.printStackTrace(); 
			}
			finally 
			{ 
				session.close(); 
			}
		}
	}
	
	/**
	 * Public method to delete a news from the system.
	 * @param nouvelleToDelete A news bean object that we wish to delete
	 */
	public void supprimerNouvelle(NouvelleBean nouvelleToDelete)
	{
		Session session = sessionFactory.openSession(); 
		Transaction tx = null; 
		
		Nouvelle entity = (Nouvelle) nouvelleToDelete.getModelObject();

		if(entity != null)
		{
			try
			{ 
				tx = session.beginTransaction(); 
				session.delete(entity); 
				tx.commit(); 
			}
			catch (HibernateException e) 
			{ 
				if (tx!=null) 
					tx.rollback();
				
				e.printStackTrace(); 
			}
			finally 
			{ 
				session.close(); 
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
