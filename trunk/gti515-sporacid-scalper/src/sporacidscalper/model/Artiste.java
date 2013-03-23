package sporacidscalper.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.ArtisteBean;
import sporacidscalper.model.beans.TagsBean;

@Entity
@Table(name = "artistes")
@SequenceGenerator(name = "artiste_id_seq", sequenceName = "artiste_id_seq", allocationSize=1)

public class Artiste extends AbstractModelObject implements Beanable
{
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artiste_id_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "description")
	private String description;
	
	
	private List<Tags> tags;
	
	public Artiste()
	{
		this(-1);
	}
	
	public Artiste(int id)
	{
		this.id = id;
		this.nom = null;
		this.description = null;
		this.tags = new ArrayList<Tags>();
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
	
	public List<Tags> getTags()
	{
		return tags;
	}
	
	public void setTags(List<Tags> tags)
	{
		this.tags = tags;
	}
	
	public List<TagsBean> toTagsBeanList(List<Tags> items)
	{
		List<TagsBean> beans = new ArrayList<TagsBean>();
		
		for(Tags t : items)
		{
			beans.add((TagsBean)t.getBean());
		}
		
		return beans;
	}
	
	@Override
	public AbstractBean getBean()
	{
		ArtisteBean bean = null;
		
		if(this != null)
		{
			bean = new ArtisteBean(this.id);
			bean.setDescription(this.description);
			bean.setNom(this.nom);
			bean.setTags(this.toTagsBeanList(this.tags));
		}

		return bean;
	}
}