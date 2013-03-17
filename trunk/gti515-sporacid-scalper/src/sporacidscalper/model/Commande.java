package sporacidscalper.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.CommandeBean;
import sporacidscalper.model.beans.ItemCommandeBean;

import org.hibernate.validator.constraints.*;

public class Commande extends AbstractModelObject implements Beanable
{
	private int id;
	
	private Date dateCreation;
	private List<ItemCommande> items;
	
	public Commande()
	{
		this(-1);
	}
	
	public Commande(int id)
	{
		this.id = id;
		this.dateCreation = null;
		this.items = new ArrayList<ItemCommande>();
	}
	
	public ItemCommande obtenirItem(int itemId)
	{
		ItemCommande itemToGet = null;
			
		for(ItemCommande item : this.items)
		{
			if(item.getId() == itemId)
			{
				itemToGet = item;
				break;
			}
		}
		
		return itemToGet;
	}
	
	public void ajouterItem(ItemCommande itemToAdd)
	{
		if(itemToAdd != null)
		{	
			this.items.add(itemToAdd);
		}
	}

	public void supprimerItem(int itemIdToDelete)
	{
		supprimerItem(obtenirItem(itemIdToDelete));
	}
	
	public void supprimerItem(ItemCommande itemToDelete)
	{
		this.items.remove(itemToDelete);
	}
	
	public double getTotal()
	{
		double total = 0;
		
		for (ItemCommande item : items)
			total += item.getTotal();
		
		return total;
	}

	public int getId()
	{
		return id;
	}

	public Date getDateCreation()
	{
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation)
	{
		this.dateCreation = dateCreation;
	}

	public void setItems(List<ItemCommande> items)
	{
		this.items = items;
	}
	
	public List<ItemCommande> getItems()
	{
		return items;
	}
	
	public List<ItemCommandeBean> toItemCommandeBeanList(List<ItemCommande> items)
	{
		List<ItemCommandeBean> beans = new ArrayList<ItemCommandeBean>();
		
		for(ItemCommande ic : items)
		{
			beans.add((ItemCommandeBean)ic.getBean());
		}
		
		return beans;
	}

	@Override
	public AbstractBean getBean()
	{
		CommandeBean bean = null;
		
		if(this != null)
		{
			bean = new CommandeBean(this.id);
			
			bean.setDateCreation(this.dateCreation);
			
			for(ItemCommande item : this.items)
				bean.ajouterItem((ItemCommandeBean) item.getBean());
		}
		
		return bean;
	}
}