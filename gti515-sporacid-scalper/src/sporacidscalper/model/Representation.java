package sporacidscalper.model;

import java.util.Date;
import java.util.List;

import sporacidscalper.model.beans.AbstractBean;

public class Representation extends AbstractModelObject implements Beanable
{
	private int id;
	private Date dateDebutRepresentation;
	private Date dateFinRepresentation;
	private String statut;
	private Salle salle;
	private List<TypeBilletRepresentation> typesBillet;
	
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

	@Override
	public AbstractBean getBean()
	{
		// TODO Auto-generated method stub
		return null;
	}
}