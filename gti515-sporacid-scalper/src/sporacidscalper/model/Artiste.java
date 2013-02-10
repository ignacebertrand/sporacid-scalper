package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;

public class Artiste extends AbstractModelObject implements Beanable
{
	private String nom;
	private String description;
	private Tags[] tags;
	
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
	
	public Tags[] getTags()
	{
		return tags;
	}
	
	public void setTags(Tags[] tags)
	{
		this.tags = tags;
	}
	
	@Override
	public AbstractBean getBean()
	{
		// TODO Auto-generated method stub
		return null;
	}
}