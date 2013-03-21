package sporacidscalper.model;

import java.util.Date;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.NouvelleBean;

public class Nouvelle extends AbstractModelObject implements Beanable
{
	private int id;
	private String titre;
	private String description;
	private Date date;
	private String auteur;

	public Nouvelle()
	{
		this(-1);
	}
	
	public Nouvelle(int id)
	{
		this.id = id;
		this.titre = null;
		this.description = null;
		this.auteur = null;
		this.date = null;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getTitre()
	{
		return titre;
	}
	
	public void setTitre(String titre)
	{
		this.titre = titre;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	public String getAuteur()
	{
		return auteur;
	}
	
	public void setAuteur(String auteur)
	{
		this.auteur = auteur;
	}

	@Override
	public AbstractBean getBean()
	{
		NouvelleBean bean = null;
		
		if(this != null)
		{
			bean = new NouvelleBean(this.id);
			
			bean.setAuteur(this.auteur);
			bean.setDate(this.date);
			bean.setDescription(this.description);
			bean.setTitre(this.titre);
		}

		return bean;
	}
}