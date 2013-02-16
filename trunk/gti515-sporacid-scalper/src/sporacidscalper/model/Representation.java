package sporacidscalper.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.SalleBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;

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
		RepresentationBean bean = new RepresentationBean();
		
		bean.setDateDebutRepresentation(this.dateDebutRepresentation);
		bean.setDateFinRepresentation(this.dateFinRepresentation);
		bean.setSalle((SalleBean)this.salle.getBean());
		bean.setStatut(this.statut);
		bean.setTypesBillet(this.toTagsBeanList(this.typesBillet));
		
		return bean;
	}
}