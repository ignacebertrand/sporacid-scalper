package sporacidscalper.controller.modelcontroller;

import java.util.ArrayList;
import java.util.List;

import sporacidscalper.model.*;

public class GestionnaireClient
{
	private List<Client> listeClients;
	private static GestionnaireClient instance;

	private GestionnaireClient()
	{
		this.listeClients = new ArrayList<Client>();
	}

	public static GestionnaireClient getInstance()
	{
		if(GestionnaireClient.instance == null)
			GestionnaireClient.instance = new GestionnaireClient();
		
		return GestionnaireClient.instance;
	}

	public void ajouterClient()
	{
		throw new UnsupportedOperationException();
	}

	public void modifierClient()
	{
		throw new UnsupportedOperationException();
	}

	public Client obtenirClient()
	{
		throw new UnsupportedOperationException();
	}

	public boolean authentifierClient()
	{
		throw new UnsupportedOperationException();
	}
}