package sporacidscalper.model.beans;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Adresse;
import sporacidscalper.model.Client;

public class ClientBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = -4839483441907619015L;
	
	@Range(min = -1, message="Le id du client est invalide.")
	private int id;
	
	@NotEmpty(message="Un nom de clien est obligatoire.")
	private String nom;

	private String identifiant;
	private String courriel;
	private AdresseBean adresse;
	
	public ClientBean()
	{
		this(-1);
	}
	
	public ClientBean(int id)
	{
		this.id = id;
		this.identifiant = null;
		this.nom = null;
		this.courriel = null;
		this.adresse = null;
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
	
	public AdresseBean getAdresseBean()
	{
		return adresse;
	}
	
	public void setAdresseBean(AdresseBean adresse)
	{
		this.adresse = adresse;
	}

	@Override
	public AbstractModelObject getModelObject()
	{
		Client client = null;
		
		if(this != null)
		{
			client = new Client(this.id);
			
			client.setAdresse((Adresse)this.adresse.getModelObject());
			client.setCourriel(this.courriel);
			client.setIdentifiant(this.identifiant);
			client.setNom(this.nom);
		}
		
		return client;
	}
}