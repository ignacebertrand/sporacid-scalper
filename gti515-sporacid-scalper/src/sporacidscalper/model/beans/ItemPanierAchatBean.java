package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;

public class ItemPanierAchatBean extends AbstractBean implements Modelable
{
	private int quantite;
	private TypeBilletRepresentationBean billetRepresentation;
	
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
		// TODO Auto-generated method stub
		return null;
	}
}