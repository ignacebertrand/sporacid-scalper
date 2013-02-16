package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Adresse;
import sporacidscalper.model.Client;
import sporacidscalper.model.PanierAchat;

public class ClientBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -4839483441907619015L;
	
	private String identifiant;
	private String nom;
	private String courriel;
	private AdresseBean adresse;
	private PanierAchat panierAchat;
	
	public String getIdentifiant()
	{
		return identifiant;
	}
	
	public void setIdentifiant(String identifiant)
	{
		this.identifiant = identifiant;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public String getCourriel()
	{
		return courriel;
	}
	
	public void setCourriel(String courriel)
	{
		this.courriel = courriel;
	}
	
	public AdresseBean getAdresseBean()
	{
		return adresse;
	}
	
	public void setAdresseBean(AdresseBean adresse)
	{
		this.adresse = adresse;
	}
	
	public PanierAchat getPanierAchat()
	{
		return panierAchat;
	}
	
	public void setPanierAchat(PanierAchat panierAchat)
	{
		this.panierAchat = panierAchat;
	}

	@Override
	public AbstractModelObject getModelObject()
	{
		Client client = new Client();
		
		client.setAdresse((Adresse)this.adresse.getModelObject());
		client.setCourriel(this.courriel);
		client.setIdentifiant(this.identifiant);
		client.setNom(this.nom);
		
		return client;
	}
}