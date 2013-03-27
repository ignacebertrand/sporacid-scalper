package sporacidscalper.view.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.model.beans.CommandeBean;
import sporacidscalper.model.beans.ItemCommandeBean;
import sporacidscalper.model.beans.RepresentationBean;

public class PanierAchatBean
{
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
		
		for(ItemPanierAchatBean item : items)
		{
			RepresentationBean represPanier = item.getBilletRepresentation().getRepresentationReference();
						
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
		
		for(ItemPanierAchatBean item : items)
		{
			ItemCommandeBean itemCommande = new ItemCommandeBean();
			
			itemCommande.setCommande(commande);
			itemCommande.setQuantite(item.getQuantite());
			itemCommande.setBilletRepresentation(item.getBilletRepresentation());
			
			commande.ajouterItem(itemCommande);
		}
		
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
}