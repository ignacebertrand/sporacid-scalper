package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;

public class SalleBean extends AbstractBean implements Modelable
{
	private String nom;
	private int capacite;
	private AdresseBean adresse;
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public int getCapacite()
	{
		return capacite;
	}
	
	public void setCapacite(int capacite)
	{
		this.capacite = capacite;
	}
	
	public AdresseBean getAdresse()
	{
		return adresse;
	}
	
	public void setAdresse(AdresseBean adresse)
	{
		this.adresse = adresse;
	}

	@Override
	public AbstractModelObject getModelObject()
	{
		// TODO Auto-generated method stub
		return null;
	}
}