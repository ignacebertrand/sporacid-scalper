package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;

public class SpectacleBean extends AbstractBean implements Modelable
{
	private String nom;
	private String description;
	private ArtisteBean[] artistes;
	private TypeSpectacleBean type;
	private RepresentationBean[] representations;
	
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
	
	public ArtisteBean[] getArtistes()
	{
		return artistes;
	}
	
	public void setArtistes(ArtisteBean[] artistes)
	{
		this.artistes = artistes;
	}
	
	public TypeSpectacleBean getType()
	{
		return type;
	}
	
	public void setType(TypeSpectacleBean type)
	{
		this.type = type;
	}
	
	public RepresentationBean[] getRepresentations()
	{
		return representations;
	}
	
	public void setRepresentations(RepresentationBean[] representations)
	{
		this.representations = representations;
	}

	@Override
	public AbstractModelObject getModelObject()
	{
		// TODO Auto-generated method stub
		return null;
	}
}