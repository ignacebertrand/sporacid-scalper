package sporacidscalper.model;

public class Client
{
	private String identifiant;
	private String motDePasse;
	private boolean estAuthentifie;
	private String nom;
	private String courriel;
	private Adresse adresse;
	private PanierAchat panierAchat;

	public void creerPanierAchat()
	{
		throw new UnsupportedOperationException();
	}

	public PanierAchat obtenirPanierAchat()
	{
		throw new UnsupportedOperationException();
	}

}