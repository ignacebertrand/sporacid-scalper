package sporacidscalper.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.CommandeBean;
import sporacidscalper.model.beans.ItemCommandeBean;
import sporacidscalper.model.beans.StatutCommandeBean;

@Entity
@Table(name = "commandes")
@SequenceGenerator(name = "commande_id_seq", 
				sequenceName = "commande_id_seq", 
				allocationSize = 1)
public class Commande extends AbstractModelObject implements Beanable
{
	@OneToOne(mappedBy = "commande")
	private Transaction transaction;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commande_id_seq")
	@Column(name = "id")
	private int id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "statut_commande_id", 
				referencedColumnName = "id", 
				nullable = false)
	private StatutCommande statut;

	@Version
	@Column(name = "date_modification", insertable = true, updatable = true)
	private Date dateModification;
	
	@OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ItemCommande> items;
	
	public Commande()
	{
		this(-1);
	}
	
	public Commande(int id)
	{
		this.id = id;
		this.dateModification = new Date();
		this.items = new ArrayList<ItemCommande>();
	}
	
	public ItemCommande obtenirItem(int itemId)
	{
		ItemCommande itemToGet = null;
			
		for(ItemCommande item : this.items)
		{
			if(item.getId() == itemId)
			{
				itemToGet = item;
				break;
			}
		}
		
		return itemToGet;
	}
	
	public void ajouterItem(ItemCommande itemToAdd)
	{
		if(itemToAdd != null)
		{	
			this.items.add(itemToAdd);
		}
	}

	public void supprimerItem(int itemIdToDelete)
	{
		supprimerItem(obtenirItem(itemIdToDelete));
	}
	
	public void supprimerItem(ItemCommande itemToDelete)
	{
		this.items.remove(itemToDelete);
	}
	
	public double getTotal()
	{
		double total = 0;
		
		for (ItemCommande item : items)
			total += item.getTotal();
		
		return total;
	}

	public int getId()
	{
		return id;
	}
	
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public StatutCommande getStatut() {
		return statut;
	}

	public void setStatut(StatutCommande statut) {
		this.statut = statut;
	}
	
	public Date getDateCreation()
	{
		return dateModification;
	}

	public void setDateCreation(Date dateCreation)
	{
		this.dateModification = dateCreation;
	}

	public void setItems(List<ItemCommande> items)
	{
		this.items = items;
	}
	
	public List<ItemCommande> getItems()
	{
		return items;
	}

	@Override
	public AbstractBean getBean()
	{
		CommandeBean bean = null;
		
		if(this != null)
		{
			bean = new CommandeBean(this.id);
			
			bean.setDateCreation(this.dateModification);
			
			if(this.statut != null)
				bean.setStatut((StatutCommandeBean) this.statut.getBean());
			
			for(ItemCommande item : this.items)
			{
				ItemCommandeBean itemBean = (ItemCommandeBean) item.getBean();
				itemBean.setCommande(bean);
				bean.ajouterItem(itemBean);
			}
		}
		
		return bean;
	}
}