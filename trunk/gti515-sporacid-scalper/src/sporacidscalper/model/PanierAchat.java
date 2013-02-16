package sporacidscalper.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.ItemPanierAchatBean;
import sporacidscalper.model.beans.PanierAchatBean;

public class PanierAchat extends AbstractModelObject implements Beanable
{
	private Date dateCreation;
	private List<ItemPanierAchat> items;
	private double total;

	public double getTotal()
	{
		this.total = 0.0;
		
		for(ItemPanierAchat ipa : items)
		{
			this.total += ipa.getBilletRepresentation().getPrix();
		}
		
		return this.total;
	}
	
	public void setTotal(double total)
	{
		this.total = total;
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
	
	public void setItems(List<ItemPanierAchat> items)
	{
		this.items = items;
	}	
	
	public List<ItemPanierAchatBean> toTagsBeanList(List<ItemPanierAchat> items)
	{
		List<ItemPanierAchatBean> beans = new ArrayList<ItemPanierAchatBean>();
		
		for(ItemPanierAchat ipa : items)
		{
			beans.add((ItemPanierAchatBean)ipa.getBean());
		}
		
		return beans;
	}


	@Override
	public AbstractBean getBean()
	{
		PanierAchatBean bean = new PanierAchatBean();
		
		bean.setDateCreation(this.dateCreation);
		bean.setItems(this.toTagsBeanList(this.items));
		bean.setTotal(this.getTotal());
		
		return bean;
	}
}