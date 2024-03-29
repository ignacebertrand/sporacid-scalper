package sporacidscalper.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.AdresseBean;
import sporacidscalper.model.beans.ClientBean;

@Entity
@Table(name = "clients")
@SequenceGenerator(name = "client_id_seq", 
				sequenceName = "client_id_seq", 
				allocationSize=1)
public class Client extends AbstractModelObject implements Beanable
{
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
	@Column(name = "id")
	private int id;

	@Column(name = "identifiant")
	private String identifiant;

	@Column(name = "mot_de_passe")
	private String motDePasse;

	@Column(name = "est_authentifie")
	private boolean estAuthentifie;

	@Column(name = "nom")
	private String nom;

	@Column(name = "courriel")
	private String courriel;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "adresse_id", 
				referencedColumnName = "id",
				nullable = false)
	private Adresse adresse;

	public Client()
	{
		this(-1);
	}
	
	public Client(int id)
	{
		this.id = id;
		this.identifiant = null;
		this.motDePasse = null;
		this.estAuthentifie = false;
		this.nom = null;
		this.courriel = null;
		this.adresse = null;
	}
	
	public boolean authentifier(String encryptedPassword)
	{
		//TODO : Decrypt the password, test the password and return false if the password does not match
		estAuthentifie = true;
		return true;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getIdentifiant()
	{
		return identifiant;
	}

	public void setIdentifiant(String identifiant)
	{
		this.identifiant = identifiant;
	}

	public String getMotDePasse()
	{
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse)
	{
		this.motDePasse = motDePasse;
	}

	public boolean isEstAuthentifie()
	{
		return estAuthentifie;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getCourriel()
	{
		return courriel;
	}

	public void setCourriel(String courriel)
	{
		this.courriel = courriel;
	}

	public Adresse getAdresse()
	{
		return adresse;
	}

	public void setAdresse(Adresse adresse)
	{
		this.adresse = adresse;
	}

	@Override
	public AbstractBean getBean()
	{
		ClientBean bean = null;
		
		if(this != null)
		{
			bean = new ClientBean(this.id);
			
			bean.setAdresseBean((AdresseBean)this.adresse.getBean());
			bean.setCourriel(this.courriel);
			bean.setIdentifiant(this.identifiant);
			bean.setNom(this.nom);
		}
		
		return bean;
	}
}