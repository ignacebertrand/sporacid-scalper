package sporacidscalper.model.beans;

import java.util.Date;

import sporacidscalper.model.AbstractModelObject;

public class PanierAchatBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -5741990719386774842L;
	
	private Date dateCreation;
	private double total;
	private ItemPanierAchatBean[] items;
	
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
	
	public void setTotal(double total)
	{
		this.total = total;
	}
	
	public ItemPanierAchatBean[] getItems()
	{
		return items;
	}
	
	public void setItems(ItemPanierAchatBean[] items)
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