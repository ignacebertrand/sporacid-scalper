package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.ItemCommandeBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;

public class ItemCommande extends AbstractModelObject implements Beanable
{	
	private int id;
	private int quantite;
	private TypeBilletRepresentation billetRepresentation;
	
	public ItemCommande()
	{
		this(-1);
	}
	
	public ItemCommande(int id)
	{
		this.id = id;
		this.quantite = 0;
		this.billetRepresentation = new TypeBilletRepresentation(-1);
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
	
	public TypeBilletRepresentation getBilletRepresentation()
	{
		return billetRepresentation;
	}
	
	public void setBilletRepresentation(TypeBilletRepresentation billetRepresentation)
	{
		this.billetRepresentation = billetRepresentation;
	}

	@Override
	public AbstractBean getBean()
	{
		// TODO Auto-generated method stub
		ItemCommandeBean bean = new ItemCommandeBean(this.id);
		
		bean.setBilletRepresentation((TypeBilletRepresentationBean)this.billetRepresentation.getBean());
		bean.setQuantite(this.quantite);
		
		return bean;
	}
}