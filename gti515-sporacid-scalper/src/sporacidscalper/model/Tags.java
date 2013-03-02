package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.TagsBean;

public class Tags extends AbstractModelObject implements Beanable
{
	private int id;
	private String nom;
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