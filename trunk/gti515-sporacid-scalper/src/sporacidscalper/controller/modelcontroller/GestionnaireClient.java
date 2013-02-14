package sporacidscalper.controller.modelcontroller;

import java.util.List;
import java.util.ArrayList;

import sporacidscalper.model.Client;
import sporacidscalper.model.beans.ClientBean;

public class GestionnaireClient implements IGestionnaireClient
{
	/**
	 * List of all clients on which we'll do operations
	 */
	private List<Client> listeClients;
	
	/**
	 * Singleton instance for the class
	 */
	private static GestionnaireClient instance;

	/**
	 * Private constructor for the singleton
	 */
	private GestionnaireClient()
	{
		this.listeClients = new ArrayList<Client>();
	}

	/**
	 * Public method to obtain the singleton instance.
	 * @return The singleton instance
	 */
	public static GestionnaireClient getInstance()
	{
		if(GestionnaireClient.instance == null)
			GestionnaireClient.instance = new GestionnaireClient();
		
		return GestionnaireClient.instance;
	}

	/**
	 * Public method to add a client to the system.
	 * @param clientToAdd A client bean object that contains informations for the client to add
	 */
	public void ajouterClient(ClientBean clientToAdd)
	{
		Client client = (Client) clientToAdd.getModelObject();
		
		//TODO : Need some sort of validation on the client to add
		
		listeClients.add(client);
	}

	/**
	 * Public method to edit a client in the system.
	 * @param clientToEdit A client bean that contains modifications to a client
	 */
	public void modifierClient(ClientBean clientToEdit)
	{
		//TODO : Need some sort of validation on the client to edit
		
		// Iterators are faster than indexed loops for ArrayList
		int i = 0;
		for(Client client : listeClients)
		{
			if(client.getIdentifiant().equals(clientToEdit.getIdentifiant()))
			{
				listeClients.set(i, (Client) clientToEdit.getModelObject());
				break;
			}
			
			i++;
		}
	}

	/**
	 * Public method to obtain a client from the system.
	 * @param clientIdentifier The unique identifier for the client
	 * @return The client bean associated with the client, if it exists, or null
	 */
	public ClientBean obtenirClient(String clientIdentifier)
	{
		ClientBean clientToGet = null;
		
		for(Client client : listeClients)
		{
			if(client.getIdentifiant().equals(clientIdentifier))
			{
				clientToGet = (ClientBean) client.getBean();
				break;
			}
		}
		
		return clientToGet;
	}

	/**
	 * Public method to authenticate a client in the system.
	 * @param clientToAuthentificate A client to authenticate in the system
	 * @param cryptedPassword Encrypted password to test the client's authenticity
	 * @return true if the client is now authenticated, false if the authentication failed
	 */
	public boolean authentifierClient(ClientBean clientToAuthenticate, String encryptedPassword)
	{
		Client client = (Client) clientToAuthenticate.getModelObject();
		return client.authentifier(encryptedPassword);
	}
}