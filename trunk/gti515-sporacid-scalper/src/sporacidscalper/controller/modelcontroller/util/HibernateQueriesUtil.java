package sporacidscalper.controller.modelcontroller.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sporacidscalper.model.AbstractModelObject;

public final class HibernateQueriesUtil 
{	
	/**
	 * Public utility method to add an entity to the database using hibernate
	 * @param entityToAdd The entity to add
	 * @param sessionFactory Reference to the SessionFactory implementation of the application context bean configuration
	 * @return The id of the entity if the addition happened or null.
	 */
	public static <E extends AbstractModelObject> Integer ajouterEntite(E entityToAdd, SessionFactory sessionFactory) 
	{
		Integer entityId = null;
		
		// If the entity is a non-null object
		if(entityToAdd != null)
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
				entityId = (Integer) session.save(entityToAdd);
				
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
	 * Public utility method to update an entity in the database using hibernate
	 * @param entityToEdit The entity to edit
	 * @param sessionFactory Reference to the SessionFactory implementation of the application context bean configuration
	 */
	public static <E extends AbstractModelObject> void modifierEntite(E entityToEdit, SessionFactory sessionFactory) 
	{
		// If the entity is a non-null object
		if(entityToEdit != null)
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
				session.update(entityToEdit);
				
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
	}
	
	/**
	 * Public utility method to delete an entity from the database using hibernate
	 * @param entityToDelete
	 * @param sessionFactory
	 */
	public static <E extends AbstractModelObject> void supprimerEntite(E entityToDelete, SessionFactory sessionFactory) 
	{
		// If the entity is a non-null object
		if(entityToDelete != null)
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
				session.delete(entityToDelete);
				
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
	}
	
	/**
	 * Public utility method to get a list of entities of a specific type from the database using hibernate
	 * @param sessionFactory Reference to the SessionFactory implementation of the application context bean configuration
	 * @param classObj Java cannot fetch the class object from the generic type...
	 * @return The list of entities
	 */
	@SuppressWarnings("unchecked")
	public static <E extends AbstractModelObject> List<E> obtenirEntites(SessionFactory sessionFactory, Class<E> classObj)
	{
		List<E> entitiesList = new ArrayList<E>();
		
		// Get a session from the session factory
		Session session = sessionFactory.openSession();

		try
		{
			// Create the query to get the list
			Query queryResult = session.createQuery("select o from " + classObj.getSimpleName() + " o");
			
			// Put the query result into the list
			entitiesList = (List<E>) queryResult.list();
			
		}
		catch(HibernateException e)
		{
			// An error occured.
		}
		finally
		{
			// Always close the session
			session.close();
		}
		
		// Return the list of entities
		return entitiesList;
	}
	
	/**
	 * Public utility method to get an entity of a specific type and id from the database using hibernate
	 * @param entityId Id of the entity
	 * @param sessionFactory Reference to the SessionFactory implementation of the application context bean configuration
	 * @param classObj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <E extends AbstractModelObject> E obtenirEntite(int entityId, SessionFactory sessionFactory, Class<E> classObj)
	{
		E entity = null;
		
		// Get a session from the session factory
		Session session = sessionFactory.openSession();

		try
		{
			classObj.getMethod("getId");
			
			// Put the query result into the list
			entity = (E)session.createCriteria(classObj)
		            .add(Restrictions.eq("id", entityId)).uniqueResult();
		}
		catch(HibernateException e)
		{
			// An error occured.
		} 
		catch (SecurityException e) 
		{
			// An error occured because the type supplied has no public id getter.
		} 
		catch (NoSuchMethodException e) 
		{
			// An error occured because the type supplied has no public id getter.
		}
		finally
		{
			// Always close the session
			session.close();
		}
		
		// Return the entity
		return entity;
	}
}
