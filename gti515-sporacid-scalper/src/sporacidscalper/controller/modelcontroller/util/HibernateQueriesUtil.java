package sporacidscalper.controller.modelcontroller.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.beans.AbstractBean;

public final class HibernateQueriesUtil 
{	
	/**
	 * 
	 * @param objectToAdd
	 * @param sessionFactory Reference to the SessionFactory implementation
	 * of the application context bean configuration.
	 * @return
	 */
	public static <E extends AbstractBean> Integer ajouterEntite(E objectToAdd, SessionFactory sessionFactory) 
	{
		Integer entityId = null;
		
		// Get a spectacle entity from the bean supplied
		AbstractModelObject entity = objectToAdd.getModelObject();
		
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
}
