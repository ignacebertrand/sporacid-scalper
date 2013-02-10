package sporacidscalper.controller.modelcontroller;

import java.util.ArrayList;
import java.util.List;

import sporacidscalper.model.*;

public class GestionnaireTransaction
{
	private List<Transaction> listeTransactions;
	private static GestionnaireTransaction instance;

	private GestionnaireTransaction()
	{
		this.listeTransactions = new ArrayList<Transaction>();
	}

	public static GestionnaireTransaction getInstance()
	{
		if(GestionnaireTransaction.instance == null)
			GestionnaireTransaction.instance = new GestionnaireTransaction();
		
		return GestionnaireTransaction.instance;
	}
	
	public void ajouterTransaction()
	{
		throw new UnsupportedOperationException();
	}

	public Transaction[] obtenirTransactionsClient()
	{
		throw new UnsupportedOperationException();
	}
}