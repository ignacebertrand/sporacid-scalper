package sporacidscalper.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.NouvelleBean;

@Entity
@Table(name = "nouvelles")
@SequenceGenerator(name = "nouvelle_id_seq", sequenceName = "nouvelle_id_seq", allocationSize=1)
public class Nouvelle extends AbstractModelObject implements Beanable
{
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nouvelle_id_seq")
	@Column(name = "id")
	private int id;

	@Column(name = "titre")
	private String titre;

	@Column(name = "description")
	private String description;

	@Column(name = "date")
	private Date date;

	@Column(name = "auteur")
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