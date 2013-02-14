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
		throw new UnsupportedOperationException();
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