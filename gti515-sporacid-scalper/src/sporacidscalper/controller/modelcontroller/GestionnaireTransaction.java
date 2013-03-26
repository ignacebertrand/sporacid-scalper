package sporacidscalper.controller.modelcontroller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import sporacidscalper.controller.modelcontroller.util.HibernateQueriesUtil;
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
		Integer entityId = HibernateQueriesUtil.<TransactionBean>ajouterEntite(transactionToAdd, sessionFactory);
		
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