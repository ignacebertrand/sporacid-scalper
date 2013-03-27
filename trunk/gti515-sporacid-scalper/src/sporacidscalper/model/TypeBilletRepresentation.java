package sporacidscalper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.TypeBilletBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;

@Entity
@Table(name = "types_billet_representation")
public class TypeBilletRepresentation extends AbstractModelObject implements Beanable
{
	@Transient
	private Representation representation; 
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_billet_id", 
				referencedColumnName = "id",
				nullable = false)
	private TypeBillet type;
	
	@Column(name = "prix")
	private double prix;
	
	@Column(name = "nb_billet_emis")
	private int nbBilletEmis;
	
	public TypeBilletRepresentation()
	{
		this.representation= null;
		this.type = null;
		
		this.prix = 0;
		this.nbBilletEmis = 0;
	}
	
	public Representation getRepresentation()
	{
		return this.representation;
	}
	
	public void setRepresentation(Representation representation)
	{
		this.representation = representation;
	}
	
	public double getPrix()
	{
		return prix;
	}
	
	public void setPrix(double prix)
	{
		this.prix = prix;
	}
	
	public int getNbBilletEmis()
	{
		return nbBilletEmis;
	}
	
	public void setNbBilletEmis(int nbBilletEmis)
	{
		this.nbBilletEmis = nbBilletEmis;
	}
	
	public TypeBillet getType()
	{
		return type;
	}
	
	public void setType(TypeBillet type)
	{
		this.type = type;
	}
	
	@Override
	public AbstractBean getBean()
	{
		TypeBilletRepresentationBean bean = new TypeBilletRepresentationBean();
		
		if(this != null)
		{	
			bean.setNbBilletEmis(this.nbBilletEmis);
			bean.setPrix(this.prix);
			bean.setType((TypeBilletBean)this.type.getBean());
		}
		
		return bean;
	}
}