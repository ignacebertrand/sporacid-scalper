package sporacidscalper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.TypeSpectacleBean;

@Entity
@Table(name = "types_spectacle")
@SequenceGenerator(name = "type_spectacle_id_seq", sequenceName = "type_spectacle_id_seq", allocationSize=1)
public class TypeSpectacle extends AbstractModelObject implements Beanable
{
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_spectacle_id_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "description")
	private String description;
	
	public TypeSpectacle()
	{
		this(-1);
	}
	
	public TypeSpectacle(int id)
	{
		this.id = id;
		this.nom = null;
		this.description = null;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public AbstractBean getBean()
	{
		TypeSpectacleBean bean = null;
		
		if(this != null)
		{
			bean = new TypeSpectacleBean(this.id);
			
			bean.setDescription(this.description);
			bean.setNom(this.nom);
		}
		
		return bean;
	}
}