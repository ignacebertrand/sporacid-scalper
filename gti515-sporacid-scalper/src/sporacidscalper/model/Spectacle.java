package sporacidscalper.model;

import java.util.ArrayList;
import java.util.List;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.ArtisteBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.TypeSpectacleBean;

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
	
	public void setArtistes(List<Artiste> artistes)
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
	
	public List<Representation> getRepresentations()
	{
		return representations;
	}
	
	public List<ArtisteBean> toTagsBeanList(List<Artiste> artistes)
	{
		List<ArtisteBean> beans = new ArrayList<ArtisteBean>();
		
		for(Artiste a : artistes)
		{
			beans.add((ArtisteBean)a.getBean());
		}
		
		return beans;
	}
	
	@Override
	public AbstractBean getBean()
	{
		SpectacleBean bean = new SpectacleBean();
		
		bean.setArtistes(this.toTagsBeanList(artistes));
		bean.setDescription(this.description);
		bean.setNom(this.nom);
		bean.setPosterUrl(this.posterUrl);
		bean.setType((TypeSpectacleBean)this.type.getBean());
		
		return bean;
	}
}