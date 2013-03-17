package sporacidscalper.model.beans;

import javax.validation.constraints.NotNull;

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
	
	@NotNull
	@Range(min=0, message="Le numéro civique est obligatoire.")
	private Integer noCivique;
	
	@Range(min=0, message="Le numéro d'appartement est invalide.")
	private Integer noAppartement;

	@NotEmpty(message="Le nom de la rue est ogligatoire.")
	@Length(max=50, message="Le nom de la rue ne peux excéder 50 caractères.")
	private String nomRue;
	
	@NotEmpty(message="Le code postal est obligatoire")
	@Length(min=6, max=6, message="Le code postal doit avoir 6 caractères.")
	private String codePostal;
	
	@NotEmpty(message="Le nom de la ville est obligatoire.")
	@Length(max=50, message="Le nom de la ville ne peux excéder 50 caractères.")
	private String ville;

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
		this.noCivique = null;
		this.noAppartement = null;
		this.nomRue = null;
		this.codePostal = null;
		this.province = null;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	
	public String getVille() 
	{
		return ville;
	}

	public void setVille(String ville) 
	{
		this.ville = ville;
	}
	
	public Integer getNoCivique()
	{
		return noCivique;
	}
	
	public void setNoCivique(Integer noCivique)
	{
		this.noCivique = noCivique;
	}
	
	public Integer getNoAppartement() 
	{
		return noAppartement;
	}

	public void setNoAppartement(Integer noAppartement) 
	{
		this.noAppartement = noAppartement;
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
			adresse.setNoAppartement(this.noAppartement);
			adresse.setNomRue(this.nomRue);
			adresse.setVille(this.ville);
			adresse.setProvince(this.province);
		}
		
		return adresse;
	}

}