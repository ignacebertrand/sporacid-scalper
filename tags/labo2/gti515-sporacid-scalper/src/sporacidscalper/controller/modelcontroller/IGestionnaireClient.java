package sporacidscalper.controller.modelcontroller;

import sporacidscalper.model.beans.ClientBean;

public interface IGestionnaireClient 
{
	/**
	 * Public method to add a client to the system.
	 * @param clientToAdd A client bean object that contains informations for the client to add
	 */
	public void ajouterClient(ClientBean clientToAdd);
	/**
	 * Public method to edit a client in the system.
	 * @param clientToEdit A client bean that contains modifications to a client
	 */
	public void modifierClient(ClientBean clientToEdit);
	/**
	 * Public method to obtain a client from the system.
	 * @param clientIdentifier The unique identifier for the client
	 * @return The client bean associated with the client, if it exists, or null
	 */
	public ClientBean obtenirClient(String clientIdentifier);
	/**
	 * Public method to authenticate a client in the system.
	 * @param clientToAuthentificate A client to authenticate in the system
	 * @param cryptedPassword Encrypted password to test the client's authenticity
	 * @return true if the client is now authenticated, false if the authentication failed
	 */
	public boolean authentifierClient(ClientBean clientToAuthenticate, String encryptedPassword);
}
