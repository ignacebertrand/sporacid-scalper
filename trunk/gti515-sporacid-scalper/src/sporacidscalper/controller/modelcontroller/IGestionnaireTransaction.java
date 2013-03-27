package sporacidscalper.controller.modelcontroller;

import java.util.List;

import sporacidscalper.model.beans.StatutCommandeBean;
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
	 * @param clientId The client id
	 * @return A list of all transactions made by the client
	 */
	public List<TransactionBean> obtenirTransactionsClient(int clientId);
	/**
	 * Public method to obtain all transactions that were made for a representation.
	 * @param representationId The Representation unique id
	 * @return A list of all transactions made for the representation
	 */
	public int obtenirTransactionsRepresentationCount(int representationId);
	/**
	 * Public method to obtain all command statuses from the system.
	 * @return A list of all command statuses
	 */
	public List<StatutCommandeBean> obtenirStatutsCommande();
	/**
	 * Public method to obtain the default command status from the system.
	 * @return The default command status
	 */
	public StatutCommandeBean obtenirStatutCommandeParDefaut();
}
