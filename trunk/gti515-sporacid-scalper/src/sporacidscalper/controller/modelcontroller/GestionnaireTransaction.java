package sporacidscalper.controller.modelcontroller;

import java.util.List;
import java.util.ArrayList;

import sporacidscalper.model.Transaction;
import sporacidscalper.model.beans.TransactionBean;

public class GestionnaireTransaction implements IGestionnaireTransaction
{
	/**
	 * List of all transactions on which we'll do operations
	 */
	private List<Transaction> listeTransactions;
	
	/**
	 * Singleton instance for the class
	 */
	private static GestionnaireTransaction instance;

	/**
	 * Private constructor for the singleton
	 */
	private GestionnaireTransaction()
	{
		this.listeTransactions = new ArrayList<Transaction>();
	}

	/**
	 * Public method to obtain the singleton instance.
	 * @return The singleton instance
	 */
	public static GestionnaireTransaction getInstance()
	{
		if(GestionnaireTransaction.instance == null)
			GestionnaireTransaction.instance = new GestionnaireTransaction();
		
		return GestionnaireTransaction.instance;
	}
	
	/**
	 * Public method to add a transaction to the system.
	 * The insertion must follow the ACID transaction paradigm.
	 * @param transactionToAdd A transaction bean object that contains informations for the transaction to add
	 */
	public void ajouterTransaction(TransactionBean transactionToAdd)
	{
		Transaction transaction = (Transaction) transactionToAdd.getModelObject();
		
		//TODO : Need some sort of validation on the transaction to add and we need to make sure it's ACID.
		
		listeTransactions.add(transaction);
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
}