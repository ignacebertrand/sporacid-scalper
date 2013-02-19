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
	
	private int id;
	private Date dateCreation;
	private List<ItemPanierAchatBean> items;
	
	public PanierAchatBean()
	{
		this(-1);
	}

	public PanierAchatBean(int id)
	{
		this.id = id;
		this.dateCreation = new Date();
		this.items = new ArrayList<ItemPanierAchatBean>();
	}
	
	public void ajouterItem(ItemPanierAchatBean itemToAdd)
	{
		if(itemToAdd != null)
		{	
			this.items.add(itemToAdd);
		}
	}
	
	public void supprimerItem(ItemPanierAchatBean itemToDelete)
	{
		this.items.remove(itemToDelete);
	}
	
	public double getTotal()
	{
		double total = 0.0;
		
		for(ItemPanierAchatBean ipa : this.items)
		{
			total += ipa.getQuantite() * ipa.getBilletRepresentation().getPrix();
		}
		
		return total;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public Date getDateCreation()
	{
		return dateCreation;
	}
	
	public void setDateCreation(Date dateCreation)
	{
		this.dateCreation = dateCreation;
	}
	
	public List<ItemPanierAchatBean> getItems()
	{
		return items;
	}
	
//	public void setItems(List<ItemPanierAchatBean> items)
//	{
//		this.items = items;
//	}
//	
//	private List<ItemPanierAchat> toItemPanierAchatList(List<ItemPanierAchatBean> items)
//	{
//		List<ItemPanierAchat> ipas = new ArrayList<ItemPanierAchat>();
//		
//		for(ItemPanierAchatBean ipa : items)
//		{
//			ipas.add((ItemPanierAchat)ipa.getModelObject());
//		}
//		
//		return ipas;
//	}
	
	@Override
	public AbstractModelObject getModelObject()
	{
		PanierAchat pa = new PanierAchat();

		//pa.setItems(this.toItemPanierAchatList(this.items));
		for(ItemPanierAchatBean item : this.items)
			pa.ajouterItem((ItemPanierAchat) item.getModelObject());
		
		pa.setDateCreation(this.dateCreation);
		
		return pa;
	}
}