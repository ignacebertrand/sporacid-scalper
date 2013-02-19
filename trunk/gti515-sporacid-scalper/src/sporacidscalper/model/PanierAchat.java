package sporacidscalper.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.ItemPanierAchatBean;
import sporacidscalper.model.beans.PanierAchatBean;

public class PanierAchat extends AbstractModelObject implements Beanable
{
	private int id;
	private Date dateCreation;
	private List<ItemPanierAchat> items;

	public PanierAchat()
	{
		this(-1);
	}

	public PanierAchat(int id)
	{
		this.id = id;
		this.dateCreation = new Date();
		this.items = new ArrayList<ItemPanierAchat>();
	}
	
	public void ajouterItem(ItemPanierAchat itemToAdd)
	{
		if(itemToAdd != null)
		{	
			this.items.add(itemToAdd);
		}
	}
	
	public void supprimerItem(ItemPanierAchat itemToDelete)
	{
		this.items.remove(itemToDelete);
	}
	
	public double getTotal()
	{
		double total = 0.0;
		
		for(ItemPanierAchat ipa : items)
		{
			total += ipa.getBilletRepresentation().getPrix();
		}
		
		return total;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public Commande creerCommande()
	{
		throw new UnsupportedOperationException();
	}

	public Date getDateCreation()
	{
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation)
	{
		this.dateCreation = dateCreation;
	}

	public List<ItemPanierAchat> getItems()
	{
		return items;
	}
//	
//	public void setItems(List<ItemPanierAchat> items)
//	{
//		this.items = items;
//	}	
//	
//	public List<ItemPanierAchatBean> toTagsBeanList(List<ItemPanierAchat> items)
//	{
//		List<ItemPanierAchatBean> beans = new ArrayList<ItemPanierAchatBean>();
//		
//		for(ItemPanierAchat ipa : items)
//		{
//			beans.add((ItemPanierAchatBean)ipa.getBean());
//		}
//		
//		return beans;
//	}


	@Override
	public AbstractBean getBean()
	{
		PanierAchatBean bean = new PanierAchatBean();
		
		bean.setDateCreation(this.dateCreation);

		//bean.setItems(this.toTagsBeanList(this.items));
		for(ItemPanierAchat item : this.items)
			bean.ajouterItem((ItemPanierAchatBean) item.getBean());
		
		return bean;
	}
}