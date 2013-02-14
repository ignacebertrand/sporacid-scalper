package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;

public class Spectacle extends AbstractModelObject implements Beanable
{
	private int id;
	private String nom;
	private String description;
	private Artiste[] artistes;
	private TypeSpectacle type;
	private Representation[] representations;
	
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
	
	public Artiste[] getArtistes()
	{
		return artistes;
	}
	
	public void setArtistes(Artiste[] artistes)
	{
		this.artistes = artistes;
	}
	
	public TypeSpectacle getType()
	{
		return type;
	}
	
	public void setType(TypeSpectacle type)
	{
		this.type = type;
	}
	
	public Representation[] getRepresentations()
	{
		return representations;
	}
	
	public void setRepresentations(Representation[] representations)
	{
		this.representations = representations;
	}
	
	@Override
	public AbstractBean getBean()
	{
		// TODO Auto-generated method stub
		return null;
	}
}