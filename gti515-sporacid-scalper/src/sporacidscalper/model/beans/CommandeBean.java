package sporacidscalper.model.beans;

import java.util.Date;
import java.util.List;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Commande;

public class CommandeBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -9198676745711308773L;
	
	private int noCommande;
	private Date dateCreation;
	private List<ItemCommandeBean> items;
	
	public double getTotal()
	{
		double total = 0;
		
		for (ItemCommandeBean item : items)
			total += item.getTotal();
		
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
	
	public List<ItemCommandeBean> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemCommandeBean> items)
	{
		this.items = items;
	}
	
	@Override
	public AbstractModelObject getModelObject()
	{
		Commande c = new Commande();
		
		c.setDateCreation(this.dateCreation);
		c.setNoCommande(this.noCommande);
		
		return c;
	}

}