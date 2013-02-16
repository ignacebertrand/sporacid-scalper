package sporacidscalper.model;

import java.util.Date;
import java.util.List;

import sporacidscalper.model.beans.AbstractBean;

public class Commande extends AbstractModelObject implements Beanable
{
	private int noCommande;
	private Date dateCreation;
	private List<ItemCommande> items;

	public double getTotal()
	{
		double total = 0;
		
		for (ItemCommande item : items)
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

	public List<ItemCommande> getItems()
	{
		return items;
	}

	@Override
	public AbstractBean getBean()
	{
		// TODO Auto-generated method stub
		return null;
	}
}