package sporacidscalper.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.SalleBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;

@Entity
@Table(name = "representations")
@SequenceGenerator(name = "representation_id_seq", sequenceName = "representation_id_seq", allocationSize=1)

public class Representation extends AbstractModelObject implements Beanable
{
	// Upper reference
	@ManyToOne
	@JoinColumn(name = "spectacle_id", 
				referencedColumnName = "id",
				nullable = false)
	private Spectacle spectacleReference;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "representation_id_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "date_debut")
	private Date dateDebutRepresentation;
	
	@Column(name = "date_fin")
	private Date dateFinRepresentation;
	
	@Column(name = "statut")
	private String statut;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "salle_id", 
				referencedColumnName = "id",
				nullable = false)
	private Salle salle;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "representation")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<TypeBilletRepresentation> typesBillet;
	
	public Representation()
	{
		this(-1);
	}
	
	public Representation(int id)
	{
		// Upper reference
		this.spectacleReference= null; 
		
		this.id = id;
		this.dateDebutRepresentation = null;
		this.dateFinRepresentation = null;
		this.statut = "O";
		this.salle = null;
		this.typesBillet = new ArrayList<TypeBilletRepresentation>();
	}
	
	public void ajouterTypeBilletRepresentation(TypeBilletRepresentation typeBilletToAdd)
	{
		if(typeBilletToAdd != null)
		{	
			this.typesBillet.add(typeBilletToAdd);
		}
	}
	
	public void supprimerTypeBilletRepresentation(TypeBilletRepresentation typeBilletToDelete)
	{
		this.typesBillet.remove(typeBilletToDelete);
	}
	
	public TypeBilletRepresentation obtenirTypeBilletRepresentation(int typeBilletIdToGet)
	{
		TypeBilletRepresentation typeBilletToGet = null;
		
		for(TypeBilletRepresentation typeBillet : this.typesBillet)
		{
			if(typeBillet.getType().getId() == typeBilletIdToGet)
			{
				typeBilletToGet = typeBillet;
				break;
			}
		}
		
		return typeBilletToGet;
	}

	public SpectacleBean getSpectacleReference()
	{
		return (SpectacleBean)this.spectacleReference.getBean();
	}
	
	public void setSpectacleReference(SpectacleBean spectacleReference)
	{
		this.spectacleReference = (Spectacle)spectacleReference.getModelObject();
	}
	
	public int getId()
	{
		return id;
	}
	
	public Date getDateDebutRepresentation()
	{
		return dateDebutRepresentation;
	}
	
	public void setDateDebutRepresentation(Date dateDebutRepresentation)
	{
		this.dateDebutRepresentation = dateDebutRepresentation;
	}
	
	public Date getDateFinRepresentation()
	{
		return dateFinRepresentation;
	}
	
	public void setDateFinRepresentation(Date dateFinRepresentation)
	{
		this.dateFinRepresentation = dateFinRepresentation;
	}
	
	public String getStatut()
	{
		return statut;
	}
	
	public void setStatut(String statut)
	{
		this.statut = statut;
	}
	
	public Salle getSalle()
	{
		return salle;
	}
	
	public void setSalle(Salle salle)
	{
		this.salle = salle;
	}
	
	public List<TypeBilletRepresentation> getTypesBillet()
	{
		return typesBillet;
	}
	
	
	public List<TypeBilletRepresentationBean> toTagsBeanList(List<TypeBilletRepresentation> typesBillet)
	{
		List<TypeBilletRepresentationBean> beans = new ArrayList<TypeBilletRepresentationBean>();
		
		for(TypeBilletRepresentation tbr : typesBillet)
		{
			beans.add((TypeBilletRepresentationBean)tbr.getBean());
		}
		
		return beans;
	}

	@Override
	public AbstractBean getBean()
	{
		RepresentationBean bean = null;
		
		if(this != null)
		{
			bean = new RepresentationBean(this.id);
			
			bean.setDateDebutRepresentation(this.dateDebutRepresentation);
			bean.setDateFinRepresentation(this.dateFinRepresentation);
			
			if(salle != null)
				bean.setSalle((SalleBean)this.salle.getBean());
			
			bean.setStatut(this.statut);
			bean.setTypesBillet(this.toTagsBeanList(this.typesBillet));
		}
		
		return bean;
	}
}