package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.TagsBean;

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
		TagsBean bean = new TagsBean();
		
		bean.setNom(this.nom);
		bean.setUrl(this.url);
		
		return bean;
	}
}