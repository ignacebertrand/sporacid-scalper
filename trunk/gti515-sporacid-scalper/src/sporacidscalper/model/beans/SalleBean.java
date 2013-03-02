package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Adresse;
import sporacidscalper.model.Salle;

public class SalleBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -6913709633421518414L;
	
	private int id;
	private String nom;
	private int capacite;
	private AdresseBean adresse;
	
	public SalleBean()
	{
		this(-1);
	}
	
	public SalleBean(int id)
	{
		this.id = id;
		this.nom = null;
		this.capacite = -1;
		this.adresse = new AdresseBean();
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
		Salle s = null;
		
		if(this != null)
		{
			s = new Salle(this.id);
			
			s.setAdresse((Adresse)this.adresse.getModelObject());
			s.setCapacite(this.capacite);
			s.setNom(this.nom);
		}
		
		return s;
	}
}