package sporacidscalper.model.beans;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Adresse;
import sporacidscalper.model.Client;
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
	
	@Range(min=-1, message = "Le id client est invalide.")
	private int clientId;
	
	@Range(min=-1, message="Le id de transaction est invalide.")
	private int id;
	
	@NotEmpty(message="Le nom du client est obligatoire.")
	@Size(max=70, message="Le nom du client ne peut dépasser 70 caractères.")
	private String nom;
	
	@Range(min=-1, message="Le no de confirmation de la transaction est invalide.")
	private int noConfirmationPaiement;
	
	@Valid
	@NotNull(message="L'adresse de livraison est obligatoire.")
	private AdresseBean adresseLivraison;
	
	/*@Valid
	@NotNull(message="La commande est obligatoire.")*/
	private CommandeBean commande;
	
	public TransactionBean()
	{
		this(-1, -1);
	}
	
	public TransactionBean(int id, int clientId)
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
	
	public int getNoConfirmationPaiement()
	{
		return noConfirmationPaiement;
	}
	
	public void setNoConfirmationPaiement(int noConfirmationPaiement)
	{
		this.noConfirmationPaiement = noConfirmationPaiement;
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
	
	public ClientBean getClientReference()
	{
		return clientReference;
	}
	
	public void setClientReference(ClientBean clientReference)
	{
		this.clientReference = clientReference;
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
			t = new Transaction(this.id, this.clientId);
			
			t.setNom(this.nom);
			t.setAdresseLivraison((Adresse)this.adresseLivraison.getModelObject());
			//t.setClientReference((Client)this.clientReference.getModelObject());
			t.setCommande((Commande)this.commande.getModelObject());
			t.setNoConfirmationPaiement(this.noConfirmationPaiement);
		}
		
		return t;
	}
}