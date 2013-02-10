package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;

public class Tags extends AbstractModelObject implements Beanable
{
	private String nom;
	private String url;
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public String getUrl()
	{
		return url;
	}
	
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	@Override
	public AbstractBean getBean()
	{
		// TODO Auto-generated method stub
		return null;
	}
}