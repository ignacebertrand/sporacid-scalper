package sporacidscalper.model;

import java.util.ArrayList;
import java.util.List;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.ArtisteBean;
import sporacidscalper.model.beans.CategoryBean;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.TypeSpectacleBean;

public class Spectacle extends AbstractModelObject implements Beanable
{
	private int id;
	private String nom;
	private String description;
	private String posterUrl;
	private Category category;
	private List<Artiste> artistes;
	private TypeSpectacle type;
	private List<Representation> representations;
	
	public Spectacle()
	{
		this(-1);
	}
	
	public Spectacle(int id)
	{
		this.id = id;
		this.nom = "";
		this.description = "";
		this.posterUrl = "";
		this.artistes = new ArrayList<Artiste>();
		this.type = new TypeSpectacle();
		this.representations = new ArrayList<Representation>();
	}
	
	public void ajouterRepresentation(Representation representationToAdd)
	{
		if(representationToAdd != null)
		{	
			this.representations.add(representationToAdd);
		}
	}
	
	public void supprimerRepresentation(Representation representationToDelete)
	{
		this.representations.remove(representationToDelete);
	}
	
	public Representation obtenirRepresentation(int representationIdToGet)
	{
		Representation representationToGet = null;
		
		for(Representation representation : this.representations)
		{
			if(representation.getId() == representationIdToGet)
			{
				representationToGet = representation;
				break;
			}
		}
		
		return representationToGet;
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
	
	public String getPosterUrl() 
	{
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) 
	{
		this.posterUrl = posterUrl;
	}
	
	public Category getCategory() 
	{
		return category;
	}

	public void setCategory(Category category) 
	{
		this.category = category;
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
		SpectacleBean bean = new SpectacleBean(this.id);
		
		bean.setArtistes(toTagsBeanList(this.artistes));
		bean.setDescription(this.description);
		bean.setNom(this.nom);
		bean.setPosterUrl(this.posterUrl);
		bean.setType((TypeSpectacleBean)this.type.getBean());
		bean.setCategory((CategoryBean)this.category.getBean());
		
		for(Representation representation : this.representations)
			bean.ajouterRepresentation((RepresentationBean) representation.getBean());
		
		return bean;
	}
}