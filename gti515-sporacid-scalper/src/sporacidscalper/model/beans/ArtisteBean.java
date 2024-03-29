package sporacidscalper.model.beans;

import java.util.ArrayList;
import java.util.List;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Artiste;
import sporacidscalper.model.Tags;

public class ArtisteBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -8367220438236798436L;
	
	private int id;
	private String nom;
	private String description;
	private List<TagsBean> tags;
	
	public ArtisteBean()
	{
		this(-1);
	}
	
	public ArtisteBean(int id)
	{
		this.id = id;
		this.nom = null;
		this.description = null;
		this.tags = new ArrayList<TagsBean>();
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
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public List<TagsBean> getTags()
	{
		return tags;
	}
	
	public void setTags(List<TagsBean> tags)
	{
		this.tags = tags;
	}
	
	private List<Tags> toTagsList(List<TagsBean> tagsBean)
	{
		List<Tags> tags = new ArrayList<Tags>();
		
		for(TagsBean t : tagsBean)
		{
			tags.add((Tags)t.getModelObject());
		}
		
		return tags;
	}
	
	@Override
	public AbstractModelObject getModelObject()
	{
		Artiste artiste = null;
		
		if(this != null)
		{
			artiste = new Artiste(this.id);
			
			artiste.setDescription(this.description);
			artiste.setNom(this.nom);
			artiste.setTags(toTagsList(this.tags));
		}
		
		return artiste;
	}
}