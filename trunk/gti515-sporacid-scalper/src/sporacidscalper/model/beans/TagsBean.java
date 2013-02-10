package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;

public class TagsBean extends AbstractBean implements Modelable
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
	public AbstractModelObject getModelObject()
	{
		// TODO Auto-generated method stub
		return null;
	}
}