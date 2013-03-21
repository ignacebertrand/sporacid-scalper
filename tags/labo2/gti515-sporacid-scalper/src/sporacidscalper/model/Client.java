package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.AdresseBean;
import sporacidscalper.model.beans.ClientBean;
import sporacidscalper.model.beans.ItemPanierAchatBean;

public class Client extends AbstractModelObject implements Beanable
{
	private int id;
	private String identifiant;
	private String motDePasse;
	private boolean estAuthentifie;
	private String nom;
	private String courriel;
	private Adresse adresse;
	private PanierAchat panierAchat;

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
		this.panierAchat = null;
	}
	
	public boolean authentifier(String encryptedPassword)
	{
		//TODO : Decrypt the password, test the password and return false if the password does not match
		estAuthentifie = true;
		return true;
	}

	public PanierAchat getPanierAchat()
	{
		return this.panierAchat;
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
			
			for(ItemPanierAchat item : this.panierAchat.getItems())
				bean.getPanierAchat().ajouterItem((ItemPanierAchatBean) item.getBean());
		}
		
		return bean;
	}
}