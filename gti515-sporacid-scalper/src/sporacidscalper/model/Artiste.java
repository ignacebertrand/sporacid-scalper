package sporacidscalper.model;

import java.util.List;

import sporacidscalper.model.beans.AbstractBean;

public class Artiste extends AbstractModelObject implements Beanable
{
	private String nom;
	private String description;
	private List<Tags> tags;
	
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
	
	@Override
	public AbstractBean getBean()
	{
		// TODO Auto-generated method stub
		return null;
	}
}