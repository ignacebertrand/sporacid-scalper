package sporacidscalper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.AdresseBean;

//@Entity
//@Table(name = "adresses")
public class Adresse extends AbstractModelObject implements Beanable
{
//	@Id @GeneratedValue
//	@Column(name = "id")
	private int id;
	
//	@Column(name = "no_civique")
	private int noCivique;
	
//	@Column(name = "no_appartement")
	private int noAppartement;
	
//	@Column(name = "nom_rue", length = 50)
	private String nomRue;
	
//	@Column(name = "code_postal", length = 6)
	private String codePostal;
	
//	@Column(name = "ville", length = 50)
	private String ville;
	
//	@Column(name = "province", length = 25)
	private String province;
	
	public Adresse()
	{
		this(-1);
	}
	
	public Adresse(int id)
	{
		this.id = id;
		this.noCivique = 0;
		this.nomRue = null;
		this.codePostal = null;
		this.province = null;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public int getNoCivique()
	{
		return noCivique;
	}
	
	public void setNoCivique(int noCivique)
	{
		this.noCivique = noCivique;
	}
	
	public int getNoAppartement() 
	{
		return noAppartement;
	}

	public void setNoAppartement(int noAppartement) 
	{
		this.noAppartement = noAppartement;
	}

	public String getVille() 
	{
		return ville;
	}

	public void setVille(String ville) 
	{
		this.ville = ville;
	}
	
	public String getNomRue()
	{
		return nomRue;
	}
	
	public void setNomRue(String nomRue)
	{
		this.nomRue = nomRue;
	}
	
	public String getCodePostal()
	{
		return codePostal;
	}
	
	public void setCodePostal(String codePostal)
	{
		this.codePostal = codePostal;
	}
	
	public String getProvince()
	{
		return province;
	}
	
	public void setProvince(String province)
	{
		this.province = province;
	}

	/**
	 * 
	 */
	@Override
	public AbstractBean getBean()
	{
		AdresseBean bean = null;
		
		if(this != null)
		{
			bean = new AdresseBean(this.id);
			
			bean.setCodePostal(this.codePostal);
			bean.setNoCivique(this.noCivique);
			bean.setNomRue(this.nomRue);
			bean.setProvince(this.province);
		}

		return bean;
	}
}