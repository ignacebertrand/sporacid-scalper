package sporacidscalper.model;

import java.util.Date;

import sporacidscalper.model.beans.AbstractBean;

public class Nouvelle extends AbstractModelObject implements Beanable
{
	private String titre;
	private String description;
	private Date date;
	private String auteur;
	
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
		// TODO Auto-generated method stub
		return null;
	}
}