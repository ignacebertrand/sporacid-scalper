package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.TypeBillet;

public class TypeBilletBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -6630697032069563682L;
	
	private int id;
	private String nom;
	private String description;
	
	public TypeBilletBean()
	{
		this(-1);
	}
	
	public TypeBilletBean(int id)
	{
		this.id = id;
		this.nom = null;
		this.description = null;
	}
	
	public int getId()
	{
		return id;
	}
	
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
		TypeBillet t =  null;
		
		if(this != null)
		{
			t = new TypeBillet(this.id);
			
			t.setDescription(this.description);
			t.setNom(this.nom);
		}
		
		return t;
	}
}