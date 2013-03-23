package sporacidscalper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.TagsBean;

@Entity
@Table(name = "tags")
@SequenceGenerator(name = "tag_id_seq", sequenceName = "tag_id_seq", allocationSize=1)
public class Tags extends AbstractModelObject implements Beanable
{
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_id_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "url")
	private String url;
	
	public Tags()
	{
		this(-1);
	}
	
	public Tags(int id)
	{
		this.id = id;
		this.nom = null;
		this.url = null;
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
	
	public String getUrl()
	{
		return url;
	}
	
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	@Override
	public AbstractBean getBean()
	{
		TagsBean bean = null;
		
		if(this != null)
		{
			bean = new TagsBean(this.id);
			
			bean.setNom(this.nom);
			bean.setUrl(this.url);
		}
		
		return bean;
	}
}