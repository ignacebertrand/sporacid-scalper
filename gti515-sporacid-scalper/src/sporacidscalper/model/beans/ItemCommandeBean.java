package sporacidscalper.model.beans;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.ItemCommande;
import sporacidscalper.model.TypeBilletRepresentation;

public class ItemCommandeBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -4556798955596199754L;
	
	@Range(min=-1)
	private int id;
	
	@Range(min=1, max=6)
	private int quantite;
	
	@NotEmpty
	private TypeBilletRepresentationBean billetRepresentation;
	
	public ItemCommandeBean()
	{
		this(-1);
	}
	
	public ItemCommandeBean(int id)
	{
		this.id = id;
		this.quantite = -1;
		this.billetRepresentation = null;
	}
	
	public double getTotal()
	{
		return this.quantite * this.billetRepresentation.getPrix();
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getQuantite()
	{
		return quantite;
	}
	
	public void setQuantite(int quantite)
	{
		this.quantite = quantite;
	}
	
	public TypeBilletRepresentationBean getBilletRepresentation()
	{
		return billetRepresentation;
	}
	
	public void setBilletRepresentation(TypeBilletRepresentationBean billetRepresentation)
	{
		this.billetRepresentation = billetRepresentation;
	}

	@Override
	public AbstractModelObject getModelObject()
	{
		ItemCommande ic = null;
		
		if(this != null)
		{
			ic = new ItemCommande(this.id);
			
			ic.setQuantite(this.quantite);
			ic.setBilletRepresentation((TypeBilletRepresentation)this.billetRepresentation.getModelObject());
		}
		
		return ic;
	}
}