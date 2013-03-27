package sporacidscalper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.StatutCommandeBean;

@Entity
@Table(name = "statut_commandes")
@SequenceGenerator(name = "statut_commande_id_seq", 
				sequenceName = "statut_commande_id_seq", 
				allocationSize = 1)
public class StatutCommande extends AbstractModelObject implements Beanable
{
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statut_commande_id_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "is_default")
	private boolean isDefault;

	public StatutCommande()
	{
		this(-1);
	}
	
	public StatutCommande(int id)
	{
		this.id = id;
		this.nom = null;
		this.description = null;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	
	@Override
	public AbstractBean getBean() 
	{
		StatutCommandeBean bean = new StatutCommandeBean(this.id);
		
		bean.setNom(this.nom);
		bean.setDescription(this.description);
		bean.setDefault(this.isDefault);
		
		return bean;
	}
}
