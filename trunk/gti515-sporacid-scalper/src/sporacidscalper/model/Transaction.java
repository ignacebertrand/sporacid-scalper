package sporacidscalper.model;

import org.hibernate.validator.constraints.*;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.AdresseBean;
import sporacidscalper.model.beans.ClientBean;
import sporacidscalper.model.beans.CommandeBean;
import sporacidscalper.model.beans.TransactionBean;

public class Transaction extends AbstractModelObject implements Beanable
{
	// Upper reference
	private Client clientReference;
	
	@Range(min=-1)
	private int clientId;
	
	@Range(min=-1)
	private int id;
	
	@NotEmpty
	private String nom;

	@Range(min=-1)
	private int noConfirmationPaiement;
	
	@Range(min=-1)
	private int noConfirmationVente;
	
	@NotEmpty
	private Adresse adresseFacturation;
	
	@NotEmpty
	private Adresse adresseLivraison;
	
	@NotEmpty
	private Commande commande;
	
	public Transaction()
	{
		this(-1, -1);
	}
	
	public Transaction(int id, int clientId)
	{
		// Upper reference
		this.clientId = clientId;
		this.clientReference = null;
		
		this.id = id;
		this.noConfirmationPaiement = -1;
		this.noConfirmationVente = -1;
		this.adresseFacturation = null;
		this.adresseLivraison = null;
		this.commande = null;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getClientId()
	{
		return this.clientId;
	}
	
	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
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
	
	public Client getClientReference()
	{
		return clientReference;
	}
	
	public void setClientReference(Client clientReference)
	{
		this.clientReference = clientReference;
	}
	
	public Adresse getAdresseFacturation()
	{
		return adresseFacturation;
	}
	
	public void setAdresseFacturation(Adresse adresseFacturation)
	{
		this.adresseFacturation = adresseFacturation;
	}
	
	public Adresse getAdresseLivraison()
	{
		return adresseLivraison;
	}
	
	public void setAdresseLivraison(Adresse adresseLivraison)
	{
		this.adresseLivraison = adresseLivraison;
	}
	
	public Commande getCommande()
	{
		return commande;
	}
	
	public void setCommande(Commande commande)
	{
		this.commande = commande;
	}

	@Override
	public AbstractBean getBean()
	{
		TransactionBean bean = null;
		
		if(this != null)
		{
			bean = new TransactionBean(this.id, this.clientId);
			
			bean.setNom(this.nom);
			bean.setAdresseFacturation((AdresseBean) this.adresseFacturation.getBean());
			bean.setAdresseLivraison((AdresseBean) this.adresseLivraison.getBean());
			bean.setClientReference((ClientBean) this.clientReference.getBean());
			bean.setCommande((CommandeBean)this.commande.getBean());
			bean.setNoConfirmationPaiement(this.noConfirmationPaiement);
			bean.setNoConfirmationVente(this.noConfirmationVente);
		}
		
		return bean;
	}
}