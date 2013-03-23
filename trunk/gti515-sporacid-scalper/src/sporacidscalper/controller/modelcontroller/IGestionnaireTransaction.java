package sporacidscalper.controller.modelcontroller;

import java.util.List;

import sporacidscalper.model.beans.TransactionBean;

public interface IGestionnaireTransaction 
{
	/**
	 * Public method to add a transaction to the system.
	 * The insertion must follow the ACID transaction paradigm.
	 * @param transactionToAdd A transaction bean object that contains informations for the transaction to add
	 */
	public Integer ajouterTransaction(TransactionBean transactionToAdd);
	/**
	 * Public method to obtain all transactions made by a client.
	 * @param clientIdentifier The client unique identifier
	 * @return A list of all transactions made by the client
	 */
	public List<TransactionBean> obtenirTransactionsClient(String clientIdentifier);
	/**
	 * Public method to obtain all transactions that were made for a representation.
	 * @param representationId The Representation unique id
	 * @return A list of all transactions made for the representation
	 */
	public int obtenirTransactionsRepresentationCount(int representationId);
}
