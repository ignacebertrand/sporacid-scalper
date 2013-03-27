package sporacidscalper.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.ItemCommandeBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;

@Entity
@Table(name = "item_commandes")
@SequenceGenerator(name = "item_commande_id_seq", 
				sequenceName = "item_commande_id_seq", 
				allocationSize = 1)
public class ItemCommande extends AbstractModelObject implements Beanable
{	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "commande_id", 
				referencedColumnName = "id", 
				nullable = false)
	private Commande commande;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_commande_id_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "quantite")
	private int quantite;

	@Transient
	private TypeBilletRepresentation billetRepresentation;
	
	public ItemCommande()
	{
		this(-1);
	}
	
	public ItemCommande(int id)
	{
		this.id = id;
		this.quantite = 0;
		this.commande = null;
		this.billetRepresentation = null;
	}
	
	public double getTotal()
	{
		return this.quantite * this.billetRepresentation.getPrix();
	}
	
	public int getId()
	{
		return id;
	}
	
	public Commande getCommande() 
	{
		return commande;
	}

	public void setCommande(Commande commande) 
	{
		this.commande = commande;
	}
	
	public int getQuantite()
	{
		return quantite;
	}
	
	public void setQuantite(int quantite)
	{
		this.quantite = quantite;
	}
	
	public TypeBilletRepresentation getBilletRepresentation()
	{
		return billetRepresentation;
	}
	
	public void setBilletRepresentation(TypeBilletRepresentation billetRepresentation)
	{
		this.billetRepresentation = billetRepresentation;
	}

	@Override
	public AbstractBean getBean()
	{
		ItemCommandeBean bean = null;
		
		if(this != null)
		{
			bean = new ItemCommandeBean(this.id);
			
			//bean.setCommande((CommandeBean)this.commande.getBean());
			bean.setBilletRepresentation((TypeBilletRepresentationBean) this.billetRepresentation.getBean());
			bean.setQuantite(this.quantite);
		}
		
		return bean;
	}
}