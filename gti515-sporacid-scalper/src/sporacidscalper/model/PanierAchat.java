package sporacidscalper.model;

import java.util.Date;
import java.util.List;

import sporacidscalper.model.beans.AbstractBean;

public class PanierAchat extends AbstractModelObject implements Beanable
{
	private Date dateCreation;
	private List<ItemPanierAchat> items;

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

	public List<ItemPanierAchat> getItems()
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