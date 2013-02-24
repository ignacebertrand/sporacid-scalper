package sporacidscalper.model.beans;

import java.util.ArrayList;
import java.util.List;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Artiste;
import sporacidscalper.model.Representation;
import sporacidscalper.model.Spectacle;
import sporacidscalper.model.TypeSpectacle;

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
	private List<ArtisteBean> artistes;
	private TypeSpectacleBean type;
	private List<RepresentationBean> representations;
	
	public SpectacleBean()
	{
		this(-1);
	}
	
	public SpectacleBean(int id)
	{
		this.id = id;
		this.nom = "";
		this.description = "";
		this.posterUrl = "";
		this.artistes = new ArrayList<ArtisteBean>();
		this.type = new TypeSpectacleBean();
		this.representations = new ArrayList<RepresentationBean>();
	}
	
	public void ajouterRepresentation(RepresentationBean representationToAdd)
	{
		if(representationToAdd != null)
		{	
			this.representations.add(representationToAdd);
		}
	}
	
	public void supprimerRepresentation(RepresentationBean representationToDelete)
	{
		this.representations.remove(representationToDelete);
	}
	
	public RepresentationBean obtenirRepresentation(int representationIdToGet)
	{
		RepresentationBean representationToGet = null;
		
		for(RepresentationBean representation : this.representations)
		{
			if(representation.getId() == representationIdToGet)
			{
				representationToGet = representation;
				break;
			}
		}
		
		return representationToGet;
	}
	
	public void setId(int id) 
	{
		this.id = id;
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
	
	public List<ArtisteBean> getArtistes()
	{
		return artistes;
	}
	
	public void setArtistes(List<ArtisteBean> artistes)
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
	
	public List<RepresentationBean> getRepresentations()
	{
		return representations;
	}
	
	private List<Artiste> toArtisteList(List<ArtisteBean> artistesBean)
	{
		List<Artiste> artistes = new ArrayList<Artiste>();
		
		for(ArtisteBean ab : artistesBean)
		{
			artistes.add((Artiste)ab.getModelObject());
		}
		
		return artistes;
	}

	@Override
	public AbstractModelObject getModelObject()
	{
		Spectacle s = new Spectacle();
		
		s.setDescription(this.description);
		s.setNom(this.nom);
		s.setPosterUrl(this.posterUrl);
		s.setType((TypeSpectacle) this.type.getModelObject());
		s.setArtistes(this.toArtisteList(this.artistes));
		s.setId(this.id);
		
		for(RepresentationBean representation : this.representations)
			s.ajouterRepresentation((Representation) representation.getModelObject());
		
		return s;
	}

	
}