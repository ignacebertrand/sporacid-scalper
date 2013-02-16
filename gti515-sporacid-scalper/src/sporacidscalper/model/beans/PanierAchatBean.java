package sporacidscalper.model.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.ItemPanierAchat;
import sporacidscalper.model.PanierAchat;

public class PanierAchatBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -5741990719386774842L;
	
	private Date dateCreation;
	private double total;
	private List<ItemPanierAchatBean> items;
	
	public Date getDateCreation()
	{
		return dateCreation;
	}
	
	public void setDateCreation(Date dateCreation)
	{
		this.dateCreation = dateCreation;
	}
	
	public double getTotal()
	{
		this.total = 0.0;
		
		for(ItemPanierAchatBean ipa : this.items)
		{
			this.total += ipa.getQuantite() * ipa.getBilletRepresentation().getPrix();
		}
		
		return this.total;
	}
	
	public void setTotal(double total)
	{
		this.total = total;
	}
	
	public List<ItemPanierAchatBean> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemPanierAchatBean> items)
	{
		this.items = items;
	}
	
	private List<ItemPanierAchat> toItemPanierAchatList(List<ItemPanierAchatBean> items)
	{
		List<ItemPanierAchat> ipas = new ArrayList<ItemPanierAchat>();
		
		for(ItemPanierAchatBean ipa : items)
		{
			ipas.add((ItemPanierAchat)ipa.getModelObject());
		}
		
		return ipas;
	}
	
	@Override
	public AbstractModelObject getModelObject()
	{
		PanierAchat pa = new PanierAchat();
		
		pa.setItems(this.toItemPanierAchatList(this.items));
		pa.setDateCreation(this.dateCreation);
		pa.setTotal(this.getTotal());
		
		return pa;
	}
}