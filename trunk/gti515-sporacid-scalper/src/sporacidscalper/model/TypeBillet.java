package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.TypeBilletBean;

public class TypeBillet extends AbstractModelObject implements Beanable
{
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
	public AbstractBean getBean()
	{
		TypeBilletBean bean = new TypeBilletBean();
		
		bean.setDescription(this.description);
		bean.setNom(this.nom);
		
		return bean;
	}
}