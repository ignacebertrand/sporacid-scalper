package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.AdresseBean;
import sporacidscalper.model.beans.SalleBean;

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
		SalleBean bean = new SalleBean();
		
		bean.setAdresse((AdresseBean)this.adresse.getBean());
		bean.setCapacite(this.capacite);
		bean.setNom(this.nom);
		
		return bean;
	}
}