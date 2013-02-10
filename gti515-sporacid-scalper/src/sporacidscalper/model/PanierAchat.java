package sporacidscalper.model;

import java.util.Date;

import sporacidscalper.model.beans.AbstractBean;

public class PanierAchat extends AbstractModelObject implements Beanable
{
	private Date dateCreation;
	private ItemPanierAchat items;

	public void getTotal()
	{
		throw new UnsupportedOperationException();
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

	public ItemPanierAchat getItems()
	{
		return items;
	}

	public void setItems(ItemPanierAchat items)
	{
		this.items = items;
	}

	@Override
	public AbstractBean getBean()
	{
		// TODO Auto-generated method stub
		return null;
	}
}