package sporacidscalper.model;

import java.util.Date;

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
import javax.persistence.Version;

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
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id", 
				referencedColumnName = "id", 
				nullable = true)
	private Client client;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, 
					generator = "transaction_id_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "nom")
	private String nom;

	@Column(name = "numero_confirmation_paiement")
	private int noConfirmationPaiement;
	
	@Column(name = "total_transaction")
	private double totalTransaction;
	
	@Version
	@Column(name = "date_creation", 
			insertable = true, 
			updatable = false)
	private Date dateCreation;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "adresse_livraison_id", 
				referencedColumnName = "id",
				nullable = false)
	private Adresse adresseLivraison;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "commande_id", 
				referencedColumnName = "id", 
				nullable = false)
	private Commande commande;
	
	public Transaction()
	{
		this(-1);
	}
	
	public Transaction(int id)
	{
		// Upper reference
		this.client = null;
		
		this.id = id;
		this.noConfirmationPaiement = -1;
		this.adresseLivraison = null;
		this.commande = null;
	}
	
	public int getId()
	{
		return id;
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
		return client;
	}
	
	public void setClientReference(Client clientReference)
	{
		this.client = clientReference;
	}
	
	public Adresse getAdresseLivraison()
	{
		return adresseLivraison;
	}

	public Date getDateCreation() 
	{
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) 
	{
		this.dateCreation = dateCreation;
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
			bean = new TransactionBean(this.id);
			
			bean.setNom(this.nom);
			bean.setAdresseLivraison((AdresseBean) this.adresseLivraison.getBean());
			bean.setTotalTransaction(this.totalTransaction);
			bean.setCommande((CommandeBean)this.commande.getBean());
			bean.setNoConfirmationPaiement(this.noConfirmationPaiement);
		}
		
		return bean;
	}
}