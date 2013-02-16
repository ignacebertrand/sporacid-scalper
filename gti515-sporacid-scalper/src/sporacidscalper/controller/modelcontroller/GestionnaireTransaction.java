package sporacidscalper.controller.modelcontroller;

import java.util.List;

import sporacidscalper.model.Transaction;
import sporacidscalper.model.beans.TransactionBean;
import sporacidscalper.model.persistence.StubFactory;

public class GestionnaireTransaction implements IGestionnaireTransaction
{
	/**
	 * List of all transactions on which we'll do operations
	 */
	private List<Transaction> listeTransactions;

	/**
	 * Private constructor for the singleton
	 */
	private GestionnaireTransaction()
	{
		this.listeTransactions = StubFactory.getInstance().getStubTransactions();
	}
	
	/**
	 * Public method to add a transaction to the system.
	 * The insertion must follow the ACID transaction paradigm.
	 * @param transactionToAdd A transaction bean object that contains informations for the transaction to add
	 */
	public void ajouterTransaction(TransactionBean transactionToAdd)
	{
		//TODO : Need some sort of validation on the transaction to add and we need to make sure it's ACID.
		
		// Access listeTransactions thread-safely.
		synchronized(listeTransactions)
		{
			listeTransactions.add((Transaction) transactionToAdd.getModelObject());
		}
	}

	/**
	 * Public method to obtain all transactions made by a client.
	 * @param clientIdentifier The client unique identifier
	 * @return A list of all transactions made by the client
	 */
	public TransactionBean[] obtenirTransactionsClient(String clientIdentifier)
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Public method to obtain all transactions that were made for a representation.
	 * @param representationId The Representation unique id
	 * @return A list of all transactions made for the representation
	 */
	public TransactionBean[] obtenirTransactionsRepresentation(int representationId)
	{
		throw new UnsupportedOperationException();
	}
}