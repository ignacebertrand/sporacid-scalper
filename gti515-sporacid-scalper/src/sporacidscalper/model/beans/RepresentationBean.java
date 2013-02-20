package sporacidscalper.model.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Representation;
import sporacidscalper.model.Salle;

public class RepresentationBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = 1875304992245566973L;
	
	// Upper reference
	private int spectacleId;
	private SpectacleBean spectacleReference;
	
	private int id;
	private Date dateDebutRepresentation;
	private Date dateFinRepresentation;
	private String statut;
	private List<TypeBilletRepresentationBean> typesBillet;
	private SalleBean salle;
	
	public RepresentationBean()
	{
		this(-1, -1);
	}
	
	public RepresentationBean(int id, int spectacleId)
	{
		// Upper reference
		this.spectacleId = spectacleId;
		this.spectacleReference= null; 
		
		this.id = id;
		this.dateDebutRepresentation = new Date();
		this.dateFinRepresentation = new Date();
		this.statut = "O";
		this.salle = new SalleBean();
		this.typesBillet = new ArrayList<TypeBilletRepresentationBean>();
	}
	
	public void ajouterTypeBilletRepresentation(TypeBilletRepresentationBean typeBilletToAdd)
	{
		if(typeBilletToAdd != null)
		{	
			this.typesBillet.add(typeBilletToAdd);
		}
	}
	
	public void supprimerTypeBilletRepresentation(TypeBilletRepresentationBean typeBilletToDelete)
	{
		this.typesBillet.remove(typeBilletToDelete);
	}
	
	public TypeBilletRepresentationBean obtenirTypeBilletRepresentation(int typeBilletIdToGet)
	{
		TypeBilletRepresentationBean typeBilletToGet = null;
		
		for(TypeBilletRepresentationBean typeBillet : this.typesBillet)
		{
			if(typeBillet.getType().getId() == typeBilletIdToGet)
			{
				typeBilletToGet = typeBillet;
				break;
			}
		}
		
		return typeBilletToGet;
	}

	public int getSpectacleId()
	{
		return spectacleId;
	}
	
	public SpectacleBean getSpectacleReference()
	{
		return this.spectacleReference;
	}
	
	public void setSpectacleReference(SpectacleBean spectacleReference)
	{
		this.spectacleReference = spectacleReference;
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
	
	public List<TypeBilletRepresentationBean> getTypesBillet()
	{
		return typesBillet;
	}
	
	public SalleBean getSalle()
	{
		return salle;
	}
	
	public void setSalle(SalleBean salle)
	{
		this.salle = salle;
	}
	
	public void setTypesBillet(List<TypeBilletRepresentationBean> typesBillet)
	{
		this.typesBillet = typesBillet;
	}

	@Override
	public AbstractModelObject getModelObject()
	{
		Representation r = new Representation(this.id, this.spectacleId);
		
		r.setDateDebutRepresentation(this.dateDebutRepresentation);
		r.setDateFinRepresentation(this.dateFinRepresentation);
		r.setSalle((Salle)this.salle.getModelObject());
		r.setStatut(this.statut);
		
		return r;
	}
}