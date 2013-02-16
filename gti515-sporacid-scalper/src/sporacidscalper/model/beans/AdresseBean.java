package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Adresse;

public class AdresseBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -3246967756814110549L;
	
	private int noCivique;
	private String nomRue;
	private String codePostal;
	private String province;
	
	public int getNoCivique()
	{
		return noCivique;
	}
	
	public void setNoCivique(int noCivique)
	{
		this.noCivique = noCivique;
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

	@Override
	public AbstractModelObject getModelObject()
	{
		Adresse adresse = new Adresse();
		
		adresse.setCodePostal(this.codePostal);
		adresse.setNoCivique(this.noCivique);
		adresse.setNomRue(this.nomRue);
		adresse.setProvince(this.province);
		
		return adresse;
	}

}