package sporacidscalper.controller.modelcontroller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sporacidscalper.model.ItemCommande;
import sporacidscalper.model.Transaction;
import sporacidscalper.model.beans.TransactionBean;
import sporacidscalper.model.persistence.StubFactory;

public class GestionnaireTransaction implements IGestionnaireTransaction
{
	/**
	 * List of all transactions on which we'll do operations
	 */
	private List<Transaction> listeTransactions;

	/**`
	 * Reference to the SessionFactory implementation
	 * of the application context bean configuration.
	 */
	private SessionFactory sessionFactory;
	
	/**
	 * Private constructor for the singleton
	 */
	public GestionnaireTransaction()
	{
		this.listeTransactions = StubFactory.getInstance().getStubTransactions();
	}
	
	/**
	 * Public method to add a transaction to the system.
	 * The insertion must follow the ACID transaction paradigm.
	 * @param transactionToAdd A transaction bean object that contains informations for the transaction to add
	 */
	public Integer ajouterTransaction(TransactionBean transactionToAdd)
	{
		Integer entityId = null;
		// Get a transaction entity from the bean supplied
		Transaction entity = (Transaction) transactionToAdd.getModelObject();
		
		// If the entity is a non-null object
		if(entity != null)
		{
			// Get a session from the session factory
			Session session = sessionFactory.openSession();
			// Transaction object to wrap the database save operation
			org.hibernate.Transaction tx = null;
			
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
	 * Public method to obtain all transactions made by a client.
	 * @param clientIdentifier The client unique identifier
	 * @return A list of all transactions made by the client
	 */
	public List<TransactionBean> obtenirTransactionsClient(String clientIdentifier)
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Public method to obtain all transactions that were made for a representation.
	 * @param representationId The Representation unique id
	 * @return A list of all transactions made for the representation
	 */
	public int obtenirTransactionsRepresentationCount(int representationId)
	{
		List<TransactionBean> repTransactions = new ArrayList<TransactionBean>();
		for(Transaction trans : this.listeTransactions)
		{
			for(ItemCommande ic : trans.getCommande().getItems())
			{
				if(representationId == ic.getBilletRepresentation().getRepresentationId())
				{
					repTransactions.add((TransactionBean)trans.getBean());
					break;
				}
			}
		}
		return repTransactions.size();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}