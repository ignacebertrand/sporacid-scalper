package sporacidscalper.controller.modelcontroller;

import java.util.List;

import sporacidscalper.model.Client;
import sporacidscalper.model.beans.ClientBean;
import sporacidscalper.model.persistence.StubFactory;

public class GestionnaireClient implements IGestionnaireClient
{
	/**
	 * List of all clients on which we'll do operations
	 */
	private List<Client> listeClients;
	
	/**
	 * Private constructor for the singleton
	 */
	private GestionnaireClient()
	{
		this.listeClients = StubFactory.getInstance().getStubClients();
	}

	/**
	 * Public method to add a client to the system.
	 * @param clientToAdd A client bean object that contains informations for the client to add
	 */
	public void ajouterClient(ClientBean clientToAdd)
	{
		//TODO : Need some sort of validation on the client to add
		
		// Access listeClient thread-safely.
		synchronized(listeClients)
		{
			listeClients.add((Client)clientToAdd.getModelObject());
		}
	}

	/**
	 * Public method to edit a client in the system.
	 * @param clientToEdit A client bean that contains modifications to a client
	 */
	public void modifierClient(ClientBean clientToEdit)
	{
		int i = 0;
		
		//TODO : Need some sort of validation on the client to edit
		
		// Access listeClient thread-safely.
		synchronized(listeClients)
		{
			// Iterators are faster than indexed loops for ArrayList
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
	}

	/**
	 * Public method to obtain a client from the system.
	 * @param clientIdentifier The unique identifier for the client
	 * @return The client bean associated with the client, if it exists, or null
	 */
	public ClientBean obtenirClient(String clientIdentifier)
	{
		ClientBean clientToGet = null;
		
		// Access listeClient thread-safely.
		synchronized(listeClients)
		{
			for(Client client : listeClients)
			{
				if(client.getIdentifiant().equals(clientIdentifier))
				{
					clientToGet = (ClientBean) client.getBean();
					break;
				}
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