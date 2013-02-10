package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;

public class Salle extends AbstractModelObject implements Beanable
{
	private String nom;
	private int capacite;
	private Adresse adresse;
	
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
	
	public Adresse getAdresse()
	{
		return adresse;
	}
	
	public void setAdresse(Adresse adresse)
	{
		this.adresse = adresse;
	}
	
	@Override
	public AbstractBean getBean()
	{
		// TODO Auto-generated method stub
		return null;
	}
}