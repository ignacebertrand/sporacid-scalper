package sporacidscalper.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.CommandeBean;
import sporacidscalper.model.beans.ItemCommandeBean;

public class Commande extends AbstractModelObject implements Beanable
{
	private int noCommande;
	private Date dateCreation;
	private List<ItemCommande> items;

	public double getTotal()
	{
		double total = 0;
		
		for (ItemCommande item : items)
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
		CommandeBean bean = new CommandeBean();
		
		bean.setDateCreation(this.dateCreation);
		bean.setItems(this.toItemCommandeBeanList(this.items));
		bean.setNoCommande(this.noCommande);
		
		return bean;
	}
}