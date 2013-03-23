package sporacidscalper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.AdresseBean;
import sporacidscalper.model.beans.SalleBean;

@Entity
@Table(name = "salles")
@SequenceGenerator(name = "salle_id_seq", sequenceName = "salle_id_seq", allocationSize=1)
public class Salle extends AbstractModelObject implements Beanable
{
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salle_id_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "capacite")
	private int capacite;
	
	private Adresse adresse;
	
	public Salle()
	{
		this(-1);
	}
	
	public Salle(int id)
	{
		this.id = id;
		this.nom = null;
		this.capacite = -1;
		this.adresse = null;
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
		SalleBean bean = null;
		
		if(this != null)
		{
			bean = new SalleBean(this.id);
			
			bean.setAdresse((AdresseBean)this.adresse.getBean());
			bean.setCapacite(this.capacite);
			bean.setNom(this.nom);
		}
		
		return bean;
	}
}