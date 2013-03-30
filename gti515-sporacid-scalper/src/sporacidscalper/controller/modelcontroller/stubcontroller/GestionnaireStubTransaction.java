package sporacidscalper.controller.modelcontroller.stubcontroller;

import java.util.ArrayList;
import java.util.List;

import sporacidscalper.controller.modelcontroller.IGestionnaireTransaction;
import sporacidscalper.model.ItemCommande;
import sporacidscalper.model.Transaction;
import sporacidscalper.model.beans.StatutCommandeBean;
import sporacidscalper.model.beans.TransactionBean;
import sporacidscalper.model.persistence.StubFactory;

public class GestionnaireStubTransaction implements IGestionnaireTransaction
{
	/**
	 * List of all transactions on which we'll do operations
	 */
	private List<Transaction> listeTransactions;

	/**
	 * Private constructor for the singleton
	 */
	public GestionnaireStubTransaction()
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
		//TODO : Need some sort of validation on the transaction to add and we need to make sure it's ACID.
		
		// Access listeTransactions thread-safely.
		synchronized(listeTransactions)
		{
			listeTransactions.add((Transaction) transactionToAdd.getModelObject());
		}
		
		return 1;
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
				if(representationId == ic.getBilletRepresentation().getRepresentation().getId())
				{
					repTransactions.add((TransactionBean)trans.getBean());
					break;
				}
			}
		}
		return repTransactions.size();
	}

	@Override
	public List<TransactionBean> obtenirTransactionsClient(int clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatutCommandeBean> obtenirStatutsCommande() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatutCommandeBean obtenirStatutCommandeParDefaut() {
		// TODO Auto-generated method stub
		return null;
	}
}