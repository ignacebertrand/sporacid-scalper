package sporacidscalper.model;

import java.util.List;

import sporacidscalper.model.beans.AbstractBean;

public class Spectacle extends AbstractModelObject implements Beanable
{
	private int id;
	private String nom;
	private String description;
	private String posterUrl;
	private List<Artiste> artistes;
	private TypeSpectacle type;
	private List<Representation> representations;
	
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

	public List<Artiste> getArtistes()
	{
		return artistes;
	}
	
	public TypeSpectacle getType()
	{
		return type;
	}
	
	public void setType(TypeSpectacle type)
	{
		this.type = type;
	}
	
	public List<Representation> getRepresentations()
	{
		return representations;
	}
	
	@Override
	public AbstractBean getBean()
	{
		// TODO Auto-generated method stub
		return null;
	}
}