package sporacidscalper.model.beans;

import sporacidscalper.model.*;

public class ClientBean extends AbstractBean implements Modelable
{
	private String identifiant;
	private boolean estAuthentifie;
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
	
	public boolean isEstAuthentifie()
	{
		return estAuthentifie;
	}
	
	public void setEstAuthentifie(boolean estAuthentifie)
	{
		this.estAuthentifie = estAuthentifie;
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
	
	public AdresseBean getAdresse()
	{
		return adresse;
	}
	
	public void setAdresse(AdresseBean adresse)
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
		// TODO Auto-generated method stub
		return null;
	}
}