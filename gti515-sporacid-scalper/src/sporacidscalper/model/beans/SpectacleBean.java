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
	private String nomSpectacle;
	private String description;
	private String posterUrl;
	private List<ArtisteBean> artistes;
	private TypeSpectacleBean typeSpectacle;
	private List<RepresentationBean> representations;
	
	public SpectacleBean()
	{
		this(-1);
	}
	
	public SpectacleBean(int id)
	{
		this.id = id;
		this.nomSpectacle = null;
		this.description = null;
		this.posterUrl = null;
		this.artistes = new ArrayList<ArtisteBean>();
		this.typeSpectacle = null;
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
		return nomSpectacle;
	}
	
	public void setNom(String nom)
	{
		this.nomSpectacle = nom;
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
		return typeSpectacle;
	}
	
	public void setType(TypeSpectacleBean type)
	{
		this.typeSpectacle = type;
	}
	
	public List<RepresentationBean> getRepresentations()
	{
		return representations;
	}
	
	public RepresentationBean getRepresentation(int representationId)
	{
		RepresentationBean repBean = new RepresentationBean();
		for(RepresentationBean r : this.representations)
		{
			if(r.getId() == representationId)
			{
				repBean = r;
				break;		
			}
		}
		
		return repBean;
	}
	
	private List<Artiste> toArtistesList(List<ArtisteBean> artistesBean)
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
		Spectacle s = null;
		
		if(this != null)
		{
			s = new Spectacle(this.id);
			
			s.setDescription(this.description);
			s.setNom(this.nomSpectacle);
			s.setPosterUrl(this.posterUrl);
			
			if(this.typeSpectacle != null)
				s.setTypeSpectacle((TypeSpectacle) this.typeSpectacle.getModelObject());
			
			s.setArtistes(this.toArtistesList(this.artistes));
			s.setId(this.id);
			
			for(RepresentationBean representation : this.representations)
				s.ajouterRepresentation((Representation) representation.getModelObject());
		}
		
		return s;
	}

	
}