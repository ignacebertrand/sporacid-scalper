package sporacidscalper.view.beans;

import sporacidscalper.model.beans.TypeBilletRepresentationBean;

public class ItemPanierAchatBean
{
	private int id;
	private int quantite;
	private TypeBilletRepresentationBean billetRepresentation;
	
	public ItemPanierAchatBean()
	{
		this(-1);
	}
	
	public ItemPanierAchatBean(int id)
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
}