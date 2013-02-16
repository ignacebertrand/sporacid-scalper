package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;

public class SpectacleBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -3395964345489788900L;
	
	private int id;
	private String nom;
	private String description;
	private String posterUrl;
	private ArtisteBean[] artistes;
	private TypeSpectacleBean type;
	private RepresentationBean[] representations;
	
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
	
	public String getPosterUrl() 
	{
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) 
	{
		this.posterUrl = posterUrl;
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

	@Override
	public AbstractModelObject getModelObject()
	{
		// TODO Auto-generated method stub
		return null;
	}
}