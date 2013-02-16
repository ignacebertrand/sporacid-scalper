package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.TypeBillet;

public class TypeBilletBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -6630697032069563682L;
	
	private String nom;
	private String description;
	
	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public AbstractModelObject getModelObject()
	{
		TypeBillet t = new TypeBillet();
		
		t.setDescription(this.description);
		t.setNom(this.nom);
		
		return t;
	}
}