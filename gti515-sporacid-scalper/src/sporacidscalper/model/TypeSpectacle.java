package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.TypeSpectacleBean;

public class TypeSpectacle extends AbstractModelObject implements Beanable
{
	private int id;
	private String nom;
	private String description;
	
	public TypeSpectacle()
	{
		this(-1);
	}
	
	public TypeSpectacle(int id)
	{
		this.id = id;
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
	public AbstractBean getBean()
	{
		TypeSpectacleBean bean = new TypeSpectacleBean();
		
		bean.setDescription(this.description);
		bean.setNom(this.nom);
		
		return bean;
	}
}