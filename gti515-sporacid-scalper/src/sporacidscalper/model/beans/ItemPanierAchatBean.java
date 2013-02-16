package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;

public class ItemPanierAchatBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = 9038754069973527755L;
	
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