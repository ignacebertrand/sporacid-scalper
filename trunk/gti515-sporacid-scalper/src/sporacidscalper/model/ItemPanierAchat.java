package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.ItemPanierAchatBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;

public class ItemPanierAchat extends AbstractModelObject implements Beanable
{
	private int id;
	private int quantite;
	private TypeBilletRepresentation billetRepresentation;
	
	public ItemPanierAchat()
	{
		this(-1);
	}
	
	public ItemPanierAchat(int id)
	{
		this.id = id;
		this.quantite = -1;
		this.billetRepresentation = new TypeBilletRepresentation(-1);
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
		ItemPanierAchatBean bean = null;
		
		if(this != null)
		{
			bean = new ItemPanierAchatBean(this.id);
			
			bean.setBilletRepresentation((TypeBilletRepresentationBean) this.billetRepresentation.getBean());
			bean.setQuantite(this.quantite);
		}
		
		return bean;
	}
}