package sporacidscalper.model.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Commande;
import sporacidscalper.model.ItemCommande;
import sporacidscalper.model.StatutCommande;

public class CommandeBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -9198676745711308773L;
	
	private int id;
	private StatutCommandeBean statut;
	private Date dateCreation;
	private List<ItemCommandeBean> items;
	
	public CommandeBean()
	{
		this(-1);
	}
	
	public CommandeBean(int id)
	{
		this.id = id;
		this.dateCreation = null;
		this.items = new ArrayList<ItemCommandeBean>();
	}
	
	public ItemCommandeBean obtenirItem(int itemId)
	{
		ItemCommandeBean itemToGet = null;
			
		for(ItemCommandeBean item : this.items)
		{
			if(item.getId() == itemId)
			{
				itemToGet = item;
				break;
			}
		}
		
		return itemToGet;
	}
	
	public void ajouterItem(ItemCommandeBean itemToAdd)
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
	
	public void supprimerItem(ItemCommandeBean itemToDelete)
	{
		this.items.remove(itemToDelete);
	}
	
	public double getTotal()
	{
		double total = 0;
		
		for (ItemCommandeBean item : items)
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
	
	public StatutCommandeBean getStatut()
	{
		return statut;
	}

	public void setStatut(StatutCommandeBean statut) 
	{
		this.statut = statut;
	}
	
	public List<ItemCommandeBean> getItems()
	{
		return items;
	}
	
	@Override
	public AbstractModelObject getModelObject()
	{
		Commande c = null;
		
		if(this != null)
		{
			c = new Commande(this.id);
			
			c.setDateCreation(this.dateCreation);
			c.setStatut((StatutCommande) this.statut.getModelObject());

			for(ItemCommandeBean item : this.items)
			{
				ItemCommande ic = (ItemCommande) item.getModelObject();
				ic.setCommande(c);
				c.ajouterItem(ic);
			}
		}
		
		return c;
	}

}