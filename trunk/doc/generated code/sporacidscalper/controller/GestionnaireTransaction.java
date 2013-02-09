package sporacidscalper.controller;

import sporacidscalper.model.*;



public class GestionnaireTransaction
{
	private List<Transaction> listeTransactions;
	private static GestionnaireTransaction instance;

	public void ajouterTransaction()
	{
		throw new UnsupportedOperationException();
	}

	public Transaction[] obtenirTransactionsClient()
	{
		throw new UnsupportedOperationException();
	}

	private GestionnaireTransaction()
	{
		throw new UnsupportedOperationException();
	}

	public static GestionnaireTransaction getInstance()
	{
		return this.instance;
	}

}