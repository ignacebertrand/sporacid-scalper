package sporacidscalper.model.beans;

import java.util.Date;

import sporacidscalper.model.AbstractModelObject;

public class NouvelleBean extends AbstractBean implements Modelable
{

	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = 4973821193002888513L;
	
	private int id;
	private String titre;
	private String description;
	private Date date;
	private String auteur;
	
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
	public AbstractModelObject getModelObject()
	{
		// TODO Auto-generated method stub
		return null;
	}
}