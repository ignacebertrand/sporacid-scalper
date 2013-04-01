package sporacidscalper.model;

import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.TypeBilletBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;

// TODO composite foreign key donc doit etre gerer differemment
/*
@AttributeOverrides({
    @AttributeOverride(name="representation_id", @Column(name="representation_id"))
    @AttributeOverride(name="type_billet_id", @Column(name="type_billet_id"))
})
*/
/*
 * 
	@JoinColumn(name = "representation_id", 
				referencedColumnName = "id",
				nullable = false)
 */

@Entity
@Table(name = "types_billet_representation")
public class TypeBilletRepresentation extends AbstractModelObject implements Beanable
{
	@AttributeOverrides({
		@AttributeOverride(name="representation_id", column=@Column(name="representation_id")),
	    @AttributeOverride(name="type_billet_id", column=@Column(name="type_billet_id"))
	})
	@EmbeddedId
	TypeBilletRepresentationCompositeKey id;
	
	/*@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "representation_id", 
				referencedColumnName = "id",
				nullable = false)*/
	@MapsId("representation_id")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "representation_id", 
	referencedColumnName = "id",
	nullable = false)
	private Representation representation; 
	
	/*@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_billet_id", 
				referencedColumnName = "id",
				nullable = false)*/
	@MapsId("type_billet_id")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_billet_id", 
	referencedColumnName = "id",
	nullable = false)
	private TypeBillet typeBillet;
	
	@Column(name = "prix")
	private double prix;
	
	@Column(name = "nb_billet_emis")
	private int nbBilletEmis;
	
	public TypeBilletRepresentation()
	{
		this.representation= null;
		this.typeBillet = null;
		
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
		return typeBillet;
	}
	
	public void setType(TypeBillet type)
	{
		this.typeBillet = type;
	}
	
	@Override
	public AbstractBean getBean()
	{
		TypeBilletRepresentationBean bean = new TypeBilletRepresentationBean();
		
		if(this != null)
		{	
			bean.setNbBilletEmis(this.nbBilletEmis);
			bean.setPrix(this.prix);
			bean.setType((TypeBilletBean)this.typeBillet.getBean());
		}
		
		return bean;
	}
}