package sporacidscalper.model.beans;

import java.util.Date;

import sporacidscalper.model.AbstractModelObject;

public class CommandeBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -9198676745711308773L;
	
	private int noCommande;
	private Date dateCreation;
	private ItemCommandeBean[] items;
	
	public double getTotal()
	{
		double total = 0;
		
		for (ItemCommandeBean item : items)
			total += item.getQuantite() * item.getBilletRepresentation().getPrix();
		
		return total;
	}
	
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