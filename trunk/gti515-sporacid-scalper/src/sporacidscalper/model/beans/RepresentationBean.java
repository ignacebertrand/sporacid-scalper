package sporacidscalper.model.beans;

import java.util.Date;
import java.util.List;

import sporacidscalper.model.AbstractModelObject;

public class RepresentationBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = 1875304992245566973L;
	
	private int id;
	private Date dateDebutRepresentation;
	private Date dateFinRepresentation;
	private String statut;
	private List<TypeBilletRepresentationBean> typesBillet;
	private SalleBean salle;
	
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
		// TODO Auto-generated method stub
		return null;
	}
}