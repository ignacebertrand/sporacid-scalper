package sporacidscalper.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.AdresseBean;
import sporacidscalper.model.beans.CommandeBean;
import sporacidscalper.model.beans.TransactionBean;

@Entity
@Table(name = "transactions")
@SequenceGenerator(name = "transaction_id_seq", 
				sequenceName = "transaction_id_seq", 
				allocationSize = 1)
public class Transaction extends AbstractModelObject implements Beanable
{
	// Upper reference
	@Transient
	private Client clientReference;
	@Transient
	private int clientId;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "nom")
	private String nom;

	@Column(name = "numero_confirmation_paiement")
	private int noConfirmationPaiement;
	
	@Column(name = "total_transaction")
	private double totalTransaction;

	@Transient
	private Adresse adresseLivraison;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "commande_id", 
				referencedColumnName = "id", 
				nullable = true)
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
	
	public Client getClientReference()
	{
		return clientReference;
	}
	
	public void setClientReference(Client clientReference)
	{
		this.clientReference = clientReference;
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
	
	public double getTotalTransaction() 
	{
		return totalTransaction;
	}

	public void setTotalTransaction(double totalTransaction) 
	{
		this.totalTransaction = totalTransaction;
	}

	@Override
	public AbstractBean getBean()
	{
		TransactionBean bean = null;
		
		if(this != null)
		{
			bean = new TransactionBean(this.id, this.clientId);
			
			bean.setNom(this.nom);
			bean.setAdresseLivraison((AdresseBean) this.adresseLivraison.getBean());
			bean.setTotalTransaction(this.totalTransaction);
			bean.setCommande((CommandeBean)this.commande.getBean());
			bean.setNoConfirmationPaiement(this.noConfirmationPaiement);
		}
		
		return bean;
	}
}