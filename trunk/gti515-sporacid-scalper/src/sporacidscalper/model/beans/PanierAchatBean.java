package sporacidscalper.model.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.ItemPanierAchat;
import sporacidscalper.model.PanierAchat;

public class PanierAchatBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -5741990719386774842L;
	
	private int id;
	private Date dateCreation;
	private List<ItemPanierAchatBean> items;
	
	public PanierAchatBean()
	{
		this(-1);
	}

	public PanierAchatBean(int id)
	{
		this.id = id;
		this.dateCreation = null;
		this.items = new ArrayList<ItemPanierAchatBean>();
	}
	
	public ItemPanierAchatBean obtenirItem(int itemId)
	{
		ItemPanierAchatBean itemToGet = null;
			
		for(ItemPanierAchatBean item : this.items)
		{
			if(item.getId() == itemId)
			{
				itemToGet = item;
				break;
			}
		}
		
		return itemToGet;
	}
	
	public boolean ajouterItem(ItemPanierAchatBean itemToAdd)
	{
		boolean ok = true;
		
		if(itemToAdd != null)
		{
			ok = verifierDoublon(itemToAdd);
			
			if(ok)
				this.items.add(itemToAdd);
		}
		
		return ok;
	}
	
	private boolean verifierDoublon(ItemPanierAchatBean itemToAdd) {
		boolean ok = true;
		
		RepresentationBean represToAdd  = itemToAdd.getBilletRepresentation().getRepresentationReference();
		
		int spectId = represToAdd.getSpectacleId();
		int represId = represToAdd.getId();
		int typeBilletId = itemToAdd.getBilletRepresentation().getType().getId();
		
		System.out.println("item a ajouter (idspect, repres, typebill): " + spectId + represId + typeBilletId);
		
		for(ItemPanierAchatBean item : items)
		{
			RepresentationBean represPanier = item.getBilletRepresentation().getRepresentationReference();
			
			System.out.println("item dans panier (idspect, repres, typebill): " + represPanier.getSpectacleId() + 
					represPanier.getId() + item.getBilletRepresentation().getType().getId());
			
			if(represPanier.getSpectacleId() == spectId &&
			   represPanier.getId() == represId &&
			   item.getBilletRepresentation().getType().getId() == typeBilletId)
				ok = false;					
			
		}
		
		return ok;
	}

	public void supprimerItem(int itemIdToDelete)
	{
		supprimerItem(obtenirItem(itemIdToDelete));
	}
	
	public void supprimerItem(ItemPanierAchatBean itemToDelete)
	{
		this.items.remove(itemToDelete);
	}
	
	public double getTotal()
	{
		double total = 0.0;
		
		for(ItemPanierAchatBean item : this.items)
			total += item.getTotal();
		
		return total;
	}
	
	public CommandeBean creerCommande()
	{
		CommandeBean commande = new CommandeBean();
		
		return commande;
	}
	
	public int getNumberOfBillets(){
		
		List<ItemPanierAchatBean> items = this.getItems();
		int size = items.size();
		int qty = 0;
		
		for(int i = 0; i < size; i++){
			qty += items.get(i).getQuantite();
		}
		return qty;
	}

	public int getId()
	{
		return this.id;
	}
	
	public Date getDateCreation()
	{
		return dateCreation;
	}
	
	public void setDateCreation(Date dateCreation)
	{
		this.dateCreation = dateCreation;
	}
	
	public List<ItemPanierAchatBean> getItems()
	{
		return items;
	}
	
	@Override
	public AbstractModelObject getModelObject()
	{
		PanierAchat pa = null;
		
		if(this != null)
		{
			pa = new PanierAchat(this.id);
	
			for(ItemPanierAchatBean item : this.items)
				pa.ajouterItem((ItemPanierAchat) item.getModelObject());
			
			pa.setDateCreation(this.dateCreation);
		}
		
		return pa;
	}
}