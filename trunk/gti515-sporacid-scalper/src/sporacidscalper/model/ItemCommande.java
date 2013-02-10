package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;

public class ItemCommande extends AbstractModelObject implements Beanable
{
	private int quantite;
	private TypeBilletRepresentation billetRepresentation;
	
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
		return null;
	}
}