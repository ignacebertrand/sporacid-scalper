package sporacidscalper.controller.modelcontroller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sporacidscalper.controller.modelcontroller.IGestionnaireNouvelle;
import sporacidscalper.controller.modelcontroller.util.HibernateQueriesUtil;
import sporacidscalper.model.Nouvelle;
import sporacidscalper.model.beans.NouvelleBean;

public class GestionnaireNouvelle implements IGestionnaireNouvelle
{
	/**
	 * Reference to the SessionFactory implementation
	 * of the application context bean configuration.
	 */
	private SessionFactory sessionFactory;
	
	/**
	 * Public method to add a news to the system.
	 * @param nouvelleToAdd A news bean object that contains informations for the news to add
	 */
	public Integer ajouterNouvelle(NouvelleBean nouvelleToAdd)
	{
		//TODO : Need some sort of validation on nouvelleToAdd
		
		// Get a nouvelle entity from the bean supplied
		Nouvelle entity = (Nouvelle) nouvelleToAdd.getModelObject();
		
		// Add the entity
		Integer entityId = HibernateQueriesUtil.<Nouvelle>ajouterEntite(entity, sessionFactory);
		
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
	@SuppressWarnings("unchecked")
	public NouvelleBean obtenirNouvelle(int nouvelleId)
	{
		NouvelleBean nouvelleToGet = null;
		List<Nouvelle> nouvelles = null;

		Session session = sessionFactory.openSession(); 
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();
			
			Criteria equalCriteria = session.createCriteria(Nouvelle.class); 
			equalCriteria.add(Restrictions.eq("id", nouvelleId));

			nouvelles = equalCriteria.list();
		
			nouvelles = session.createQuery("FROM Nouvelles").list();

			tx.commit();
		}
		catch (HibernateException e) 
		{ 
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}
		finally 
		{ 
			session.close(); 
		}
		
		if(nouvelles.size() == 1)
			nouvelleToGet = (NouvelleBean)nouvelles.get(0).getBean();
				
		return nouvelleToGet;
	}
	
	/**
	 * Public method to obtain all news from the system.
	 * @return The list of all news
	 */
	public List<NouvelleBean> obtenirNouvelles()
	{
		List<NouvelleBean> nouvellesBean = new ArrayList<NouvelleBean>();
		List<Nouvelle> nouvelles = 
				HibernateQueriesUtil.<Nouvelle>obtenirEntites(sessionFactory, Nouvelle.class);

		for(Nouvelle nouvelle:nouvelles)
			nouvellesBean.add((NouvelleBean)nouvelle.getBean());
		
		return nouvellesBean;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
