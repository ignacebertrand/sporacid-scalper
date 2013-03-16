package sporacidscalper.model.beans;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
	
	@Range(min=-1, message="Le no de confirmation de la transaction est invalide.")
	private int noConfirmationPaiement;
	
	@Range(min=-1, message="Le no de confirmation de la vente est invalide.")
	private int noConfirmationVente;
	
	@Valid
	@NotNull
	private AdresseBean adresseFacturation;
	
	@Valid
	@NotNull
	private AdresseBean adresseLivraison;
	
	@Valid
	@NotNull
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
		this.noConfirmationVente = -1;
		this.adresseFacturation = null;
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
	
	public int getNoConfirmationVente()
	{
		return noConfirmationVente;
	}
	
	public void setNoConfirmationVente(int noConfirmationVente)
	{
		this.noConfirmationVente = noConfirmationVente;
	}
	
	public int getClientId()
	{
		return this.clientId;
	}
	
	public ClientBean getClientReference()
	{
		return clientReference;
	}
	
	public void setClientReference(ClientBean clientReference)
	{
		this.clientReference = clientReference;
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
		Transaction t = null;
		
		if(this != null)
		{
			t = new Transaction(this.id, this.clientId);
			
			t.setAdresseFacturation((Adresse)this.adresseFacturation.getModelObject());
			t.setAdresseLivraison((Adresse)this.adresseLivraison.getModelObject());
			t.setClientReference((Client)this.clientReference.getModelObject());
			t.setCommande((Commande)this.commande.getModelObject());
			t.setNoConfirmationPaiement(this.noConfirmationPaiement);
			t.setNoConfirmationVente(this.noConfirmationVente);
		}
		
		return t;
	}
}