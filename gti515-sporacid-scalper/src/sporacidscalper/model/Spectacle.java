package sporacidscalper.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.ArtisteBean;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.TypeSpectacleBean;

@Entity
@Table(name = "spectacles")
@SequenceGenerator(name = "spectacle_id_seq", 
				sequenceName = "spectacle_id_seq", 
				allocationSize = 1)
public class Spectacle extends AbstractModelObject implements Beanable
{
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spectacle_id_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "nom")
	private String nom;

	@Column(name = "description")
	private String description;

	@Column(name = "poster_url")
	private String posterUrl;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "artistes_spectacles",
			joinColumns = @JoinColumn(name = "spectacle_id", referencedColumnName = "id"), 
        	inverseJoinColumns = @JoinColumn(name = "artiste_id", referencedColumnName = "id"))
	private List<Artiste> artistes;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_spectacle_id", 
				referencedColumnName = "id", 
				nullable = false)
	private TypeSpectacle typeSpectacle;
	
	@Transient
	private List<Representation> representations;
	
	public Spectacle()
	{
		this(-1);
	}
	
	public Spectacle(int id)
	{
		this.id = id;
		this.nom = null;
		this.description = null;
		this.posterUrl = null;
		this.artistes = new ArrayList<Artiste>();
		this.typeSpectacle = null;
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
	
	public void setId(int id)
	{
		this.id = id;
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
	
	public TypeSpectacle getTypeSpectacle()
	{
		return typeSpectacle;
	}
	
	public void setTypeSpectacle(TypeSpectacle type)
	{
		this.typeSpectacle = type;
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
		SpectacleBean bean = null;
		
		if(this != null)
		{
			bean = new SpectacleBean(this.id);
			
			bean.setArtistes(toTagsBeanList(this.artistes));
			bean.setDescription(this.description);
			bean.setNom(this.nom);
			bean.setPosterUrl(this.posterUrl);
			
			if(this.typeSpectacle != null)
				bean.setType((TypeSpectacleBean)this.typeSpectacle.getBean());
			
			bean.setId(this.id);
			
			for(Representation representation : this.representations)
				bean.ajouterRepresentation((RepresentationBean) representation.getBean());
		}
		
		return bean;
	}
}