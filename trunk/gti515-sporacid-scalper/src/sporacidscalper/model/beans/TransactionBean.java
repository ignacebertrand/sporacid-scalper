package sporacidscalper.model.beans;

import sporacidscalper.model.*;

public class TransactionBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -1577684604314224161L;
	
	private int id;
	private int noConfirmationPaiement;
	private int noConfirmationVente;
	private ClientBean client;
	private AdresseBean adresseFacturation;
	private AdresseBean adresseLivraison;
	private CommandeBean commande;
	
	public int getId()
	{
		return id;
	}
	
	public int getNoConfirmationPaiement()
	{
		return noConfirmationPaiement;
	}
	
	public void setNoConfirmationPaiement(int noConfirmationPaiement)
	{
		this.noConfirmationPaiement = noConfirmationPaiement;
	}
	
	public int getNoConfirmationVente()
	{
		return noConfirmationVente;
	}
	
	public void setNoConfirmationVente(int noConfirmationVente)
	{
		this.noConfirmationVente = noConfirmationVente;
	}
	
	public ClientBean getClient()
	{
		return client;
	}
	
	public void setClient(ClientBean client)
	{
		this.client = client;
	}
	
	public AdresseBean getAdresseFacturation()
	{
		return adresseFacturation;
	}
	
	public void setAdresseFacturation(AdresseBean adresseFacturation)
	{
		this.adresseFacturation = adresseFacturation;
	}
	
	public AdresseBean getAdresseLivraison()
	{
		return adresseLivraison;
	}
	
	public void setAdresseLivraison(AdresseBean adresseLivraison)
	{
		this.adresseLivraison = adresseLivraison;
	}
	
	public CommandeBean getCommande()
	{
		return commande;
	}
	
	public void setCommande(CommandeBean commande)
	{
		this.commande = commande;
	}
	
	@Override
	public AbstractModelObject getModelObject()
	{
		// TODO Auto-generated method stub
		return null;
	}
}