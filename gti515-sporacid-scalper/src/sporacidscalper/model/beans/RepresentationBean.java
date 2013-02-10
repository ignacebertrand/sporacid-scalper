package sporacidscalper.model.beans;

import java.util.Date;

import sporacidscalper.model.AbstractModelObject;

public class RepresentationBean extends AbstractBean implements Modelable
{
	private Date dateDebutRepresentation;
	private Date dateFinRepresentation;
	private String statut;
	private TypeBilletRepresentationBean[] typesBillet;
	private SalleBean salle;
	
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
	
	public TypeBilletRepresentationBean[] getTypesBillet()
	{
		return typesBillet;
	}
	
	public void setTypesBillet(TypeBilletRepresentationBean[] typesBillet)
	{
		this.typesBillet = typesBillet;
	}
	
	public SalleBean getSalle()
	{
		return salle;
	}
	
	public void setSalle(SalleBean salle)
	{
		this.salle = salle;
	}

	@Override
	public AbstractModelObject getModelObject()
	{
		// TODO Auto-generated method stub
		return null;
	}
}