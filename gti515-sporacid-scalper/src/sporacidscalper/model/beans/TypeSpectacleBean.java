package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;

public class TypeSpectacleBean extends AbstractBean implements Modelable
{
	private String nom;
	private String description;
	
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
	public AbstractModelObject getModelObject()
	{
		// TODO Auto-generated method stub
		return null;
	}
}