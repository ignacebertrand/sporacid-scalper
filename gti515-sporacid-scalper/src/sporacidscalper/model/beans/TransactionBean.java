package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Adresse;
import sporacidscalper.model.Commande;
import sporacidscalper.model.Transaction;

public class TransactionBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -1577684604314224161L;
	
	// Upper reference
	private ClientBean clientReference;
	
	private int id;
	private String nom;
	private int noConfirmationPaiement;
	private double totalTransaction;
	private AdresseBean adresseLivraison;
	private CommandeBean commande;
	
	public TransactionBean()
	{
		this(-1);
	}
	
	public TransactionBean(int id)
	{
		// Upper reference
		this.clientReference = null;
		
		this.id = id;
		this.noConfirmationPaiement = -1;
		this.adresseLivraison = null;
		this.commande = null;
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
	
	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	public ClientBean getClientReference()
	{
		return clientReference;
	}
	
	public void setClientReference(ClientBean clientReference)
	{
		this.clientReference = clientReference;
	}
	
	
	public double getTotalTransaction() 
	{
		return totalTransaction;
	}

	public void setTotalTransaction(double totalTransaction)
	{
		this.totalTransaction = totalTransaction;
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
		Transaction t = null;
		
		if(this != null)
		{
			t = new Transaction(this.id);
			
			t.setNom(this.nom);
			t.setAdresseLivraison((Adresse)this.adresseLivraison.getModelObject());
			t.setCommande((Commande)this.commande.getModelObject());
			t.setTotalTransaction(this.totalTransaction);
			t.setNoConfirmationPaiement(this.noConfirmationPaiement);
		}
		
		return t;
	}
}