package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;

public class ArtisteBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -8367220438236798436L;
	
	private String nom;
	private String description;
	private TagsBean[] tags;
	
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
	
	public TagsBean[] getTags()
	{
		return tags;
	}
	
	public void setTags(TagsBean[] tags)
	{
		this.tags = tags;
	}

	@Override
	public AbstractModelObject getModelObject()
	{
		// TODO Auto-generated method stub
		return null;
	}
}