package sporacidscalper.view.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class FormulairePaiementSecurise 
{
	@NotNull(message="Le num�ro civique est obligatoire.")
	@Range(min=0, message="Le num�ro civique est un entier positif.")
	private Integer noCivique;
	
	@Range(min=0, message="Le num�ro d'appartement est un entier positif.")
	private Integer noAppartement;

	@NotEmpty(message="Le nom de la rue est ogligatoire.")
	@Length(max=50, message="Le nom de la rue ne peux exc�der 50 caract�res.")
	private String nomRue;
	
	@NotEmpty(message="Le code postal est obligatoire.")
	@Length(min=6, max=6, message="Le code postal doit avoir 6 caract�res.")
	private String codePostal;
	
	public Integer getNoCivique() {
		return noCivique;
	}

	public void setNoCivique(Integer noCivique) {
		this.noCivique = noCivique;
	}

	public Integer getNoAppartement() {
		return noAppartement;
	}

	public void setNoAppartement(Integer noAppartement) {
		this.noAppartement = noAppartement;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNoCarte() {
		return noCarte;
	}

	public void setNoCarte(String noCarte) {
		this.noCarte = noCarte;
	}

	public String getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public String getCodeCvv() {
		return codeCvv;
	}

	public void setCodeCvv(String codeCvv) {
		this.codeCvv = codeCvv;
	}

	@NotEmpty(message="Le nom de la ville est obligatoire.")
	@Length(max=50, message="Le nom de la ville ne peux exc�der 50 caract�res.")
	private String ville;

	@NotEmpty(message="Le nom de la province est obligatoire.")
	@Length(max=25, message="Le nom de la province ne peux exc�der 25 caract�res.")
	private String province;
	
	@NotEmpty(message="Le nom de client est obligatoire.")
	@Length(max=75, message="Le nom de client ne peut pas d�passer 75 caract�res.")
	private String nom;
	
	@NotEmpty(message="Le no de carte est obligatoire.")
	@Pattern(regexp="[0-9]{16}", message="Le no de carte doit �tre compos� de 16 chiffres.")
	private String noCarte;
	
	@NotEmpty(message="La date d'expiration de la carte est obligatoire.")
	@Pattern(regexp="[0-9]{2}/[0-9]{2}", message="La date d'expiration de la carte doit �tre au format mm/yy.")
	private String dateExpiration;
	
	@NotEmpty(message="Le code cvv de la carte est obligatoire.")
	@Pattern(regexp="[0-9]{3}", message="Le code cvv de la carte est compos� de 3 chiffres.")
	private String codeCvv;
}
