package sporacidscalper.controller.modelcontroller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import sporacidscalper.controller.modelcontroller.util.HibernateQueriesUtil;
import sporacidscalper.model.ItemCommande;
import sporacidscalper.model.StatutCommande;
import sporacidscalper.model.Transaction;
import sporacidscalper.model.beans.StatutCommandeBean;
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
		// Get the model object from the bean
		Transaction entityToAdd = (Transaction) transactionToAdd.getModelObject();
		
		// Add the entity
		Integer entityId = HibernateQueriesUtil.<Transaction>ajouterEntite(entityToAdd, sessionFactory);
		
		// Return the id of the saved transaction or null
		return entityId;
	}

	/**
	 * Public method to obtain all transactions made by a client.
	 * @param clientId The client id
	 * @return A list of all transactions made by the client
	 */
	public List<TransactionBean> obtenirTransactionsClient(int clientId)
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
				if(representationId == ic.getBilletRepresentation().getRepresentation().getId())
				{
					repTransactions.add((TransactionBean)trans.getBean());
					break;
				}
			}
		}
		return repTransactions.size();
	}
	
	/**
	 * Public method to obtain all command statuses from the system.
	 * @return A list of all command statuses
	 */
	public List<StatutCommandeBean> obtenirStatutsCommande()
	{
		List<StatutCommandeBean> listeBeans = new ArrayList<StatutCommandeBean>();
		List<StatutCommande> listeStatuts = 
				HibernateQueriesUtil.<StatutCommande>obtenirEntites(sessionFactory, StatutCommande.class);
		
		for(StatutCommande statut : listeStatuts)
			listeBeans.add((StatutCommandeBean) statut.getBean());
		
		listeStatuts = null;
			
		return listeBeans;
	}
	
	/**
	 * Public method to obtain the default command status from the system.
	 * @return The default command status
	 */
	public StatutCommandeBean obtenirStatutCommandeParDefaut()
	{
		List<StatutCommandeBean> listeBeans = obtenirStatutsCommande();
		StatutCommandeBean defaultBean = null;
		
		for(StatutCommandeBean statut : listeBeans)
			if(statut.isDefault())
			{
				defaultBean = statut;
				break;
			}
		
		return defaultBean;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}