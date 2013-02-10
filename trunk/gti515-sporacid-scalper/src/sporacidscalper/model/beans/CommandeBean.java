package sporacidscalper.model.beans;

import java.util.Date;

import sporacidscalper.model.AbstractModelObject;

public class CommandeBean extends AbstractBean implements Modelable
{
	private int noCommande;
	private Date dateCreation;
	private double total;
	private ItemCommandeBean[] items;
	
	public int getNoCommande()
	{
		return noCommande;
	}
	
	public void setNoCommande(int noCommande)
	{
		this.noCommande = noCommande;
	}
	
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
		return total;
	}
	
	public ItemCommandeBean[] getItems()
	{
		return items;
	}
	
	public void setItems(ItemCommandeBean[] items)
	{
		this.items = items;
	}
	
	@Override
	public AbstractModelObject getModelObject()
	{
		// TODO Auto-generated method stub
		return null;
	}

}