package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.AdresseBean;
import sporacidscalper.model.beans.ClientBean;
import sporacidscalper.model.beans.CommandeBean;
import sporacidscalper.model.beans.TransactionBean;

public class Transaction extends AbstractModelObject implements Beanable
{
	private int id;
	private int noConfirmationPaiement;
	private int noConfirmationVente;
	private Client client;
	private Adresse adresseFacturation;
	private Adresse adresseLivraison;
	private Commande commande;
	
	public Transaction()
	{
		this(-1);
	}
	
	public Transaction(int id)
	{
		this.id = id;
	
	}
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
	
	public Client getClient()
	{
		return client;
	}
	
	public void setClient(Client client)
	{
		this.client = client;
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
		TransactionBean bean = new TransactionBean();
		
		bean.setAdresseFacturation((AdresseBean)this.adresseFacturation.getBean());
		bean.setAdresseLivraison((AdresseBean)this.adresseLivraison.getBean());
		bean.setClient((ClientBean)this.client.getBean());
		bean.setCommande((CommandeBean)this.commande.getBean());
		bean.setNoConfirmationPaiement(this.noConfirmationPaiement);
		bean.setNoConfirmationVente(this.noConfirmationVente);
		
		return bean;
	}
}