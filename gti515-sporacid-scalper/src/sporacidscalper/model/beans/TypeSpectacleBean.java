package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.TypeSpectacle;

public class TypeSpectacleBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -4373537804034790057L;
	
	private int id;
	private String nom;
	private String description;
	
	public TypeSpectacleBean()
	{
		this(-1);
	}
	
	public TypeSpectacleBean(int id)
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
	public AbstractModelObject getModelObject()
	{
		TypeSpectacle ts = null;
		
		if(this != null)
		{
			ts = new TypeSpectacle(this.id);
			
			ts.setDescription(this.description);
			ts.setNom(this.nom);
		}
		
		return ts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}