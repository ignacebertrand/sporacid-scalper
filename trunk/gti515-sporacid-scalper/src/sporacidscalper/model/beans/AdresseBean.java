package sporacidscalper.model.beans;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Adresse;

public class AdresseBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -3246967756814110549L;
	
	@Range(min=-1, message="Le id de l'adresse est invalide.")
	private int id;
	
	@Range(min=0, message="Le numéro civique est obligatoire.")
	private int noCivique;
	
	@NotEmpty(message="Le nom de la rue est ogligatoire.")
	@Length(max=50, message="Le nom de la rue ne peux excéder 50 caractères.")
	private String nomRue;
	
	@NotEmpty(message="Le code postal est obligatoire")
	@Length(min=6, max=6, message="Le code postal doit avoir 6 caractères.")
	private String codePostal;
	
	@NotEmpty(message="Le nom de la province est obligatoire")
	@Length(max=25, message="Le nom de la province ne peux excéder 25 caractères.")
	private String province;
	
	public AdresseBean()
	{
		this(-1);
	}
	
	public AdresseBean(int id)
	{
		this.id = id;
		this.noCivique = -1;
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
		Adresse adresse = null;
		
		if(this != null)
		{
			adresse = new Adresse(this.id);
			
			adresse.setCodePostal(this.codePostal);
			adresse.setNoCivique(this.noCivique);
			adresse.setNomRue(this.nomRue);
			adresse.setProvince(this.province);
		}
		
		return adresse;
	}

}