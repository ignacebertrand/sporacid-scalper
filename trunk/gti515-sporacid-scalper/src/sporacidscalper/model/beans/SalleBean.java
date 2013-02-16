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
		Salle s = new Salle();
		
		s.setAdresse((Adresse)this.adresse.getModelObject());
		s.setCapacite(this.capacite);
		s.setNom(this.nom);
		
		return s;
	}
}