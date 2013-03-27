package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.StatutCommande;
import sporacidscalper.model.beans.AbstractBean;

public class StatutCommandeBean extends AbstractBean implements Modelable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1103294160652302157L;
	
	private int id;
	private String nom;
	private String description;
	private boolean isDefault;

	public StatutCommandeBean()
	{
		this(-1);
	}
	
	public StatutCommandeBean(int id)
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
	public AbstractModelObject getModelObject() 
	{
		StatutCommande sc = new StatutCommande(this.id);
		
		sc.setNom(this.nom);
		sc.setDescription(this.description);
		sc.setDefault(this.isDefault);
		
		return sc;
	}
	
}
