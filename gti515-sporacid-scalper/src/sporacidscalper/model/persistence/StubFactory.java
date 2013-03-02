package sporacidscalper.model.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import sporacidscalper.model.Adresse;
import sporacidscalper.model.Artiste;
import sporacidscalper.model.Client;
import sporacidscalper.model.Nouvelle;
import sporacidscalper.model.Representation;
import sporacidscalper.model.Salle;
import sporacidscalper.model.Spectacle;
import sporacidscalper.model.Tags;
import sporacidscalper.model.Transaction;
import sporacidscalper.model.TypeBillet;
import sporacidscalper.model.TypeBilletRepresentation;
import sporacidscalper.model.TypeSpectacle;

public class StubFactory 
{
	
	private static StubFactory instance;
	
	private List<Client> listeClients;
	private List<Artiste> listeArtistes;
	private List<Nouvelle> listeNouvelles;
	private Vector<Spectacle> listeSpectacles;
	private List<Transaction> listeTransactions;
	private List<TypeSpectacle> listeTypesSpectacle;
	private List<Adresse> listeAdresses;
	private List<Salle> listeSalles;

	private StubFactory() 
	{
		setStubAdresse();
		setStubSalles();
		setStubClient();
		setStubArtistes();
		setStubTransactions();
		setStubNouvelles();
		setStubTypesSpectacle();
		setStubSpectacles();
	}

	public static StubFactory getInstance() 
	{
		if (StubFactory.instance == null)
			StubFactory.instance = new StubFactory();

		return StubFactory.instance;
	}

	public List<Client> getStubClients() 
	{

		return this.listeClients;
	}

	private void setStubNouvelles() 
	{
		List<Nouvelle> listeNouvelles = new ArrayList<Nouvelle>();

		Nouvelle n1 = new Nouvelle(1);
		n1.setAuteur("Simon Turcotte-Langevin");
		n1.setDate(new Date());
		n1.setTitre("Va chier Pat");
		n1.setDescription("self explanatory");

		Nouvelle n2 = new Nouvelle(2);
		n2.setAuteur("Pat Lavallée");
		n2.setDate(new Date());
		n2.setTitre("Je sors du placard");
		n2.setDescription("self explanatory");

		Nouvelle n3 = new Nouvelle(3);
		n3.setAuteur("Patrick Groulx");
		n3.setDate(new Date());
		n3.setTitre("Moi j'aime ça les patates");
		n3.setDescription("pis les bons légumes");

		listeNouvelles.add(n1);
		listeNouvelles.add(n2);
		listeNouvelles.add(n3);

		this.listeNouvelles = listeNouvelles;
	}

	public List<Nouvelle> getStubNouvelles() 
	{
		return this.listeNouvelles;
	}

	private void setStubSpectacles() 
	{
		Vector<Spectacle> listeSpectacles = new Vector<Spectacle>();

		Spectacle s1 = new Spectacle(1);
		s1.setNom("Les trois accords");
		s1.setDescription("Les trois accords en spectacle");
		s1.setPosterUrl("styles/images/trois_accords.jpg");
		List<Artiste> listeArtistes1 = new ArrayList<Artiste>();
		listeArtistes1.add(getStubArtistes().get(0));
		listeArtistes1.add(getStubArtistes().get(1));
		s1.setArtistes(listeArtistes1);
		s1.setType(getStubTypesSpectacles().get(2));
		
		Representation r = new Representation(1, s1.getId());
		TypeBilletRepresentation typeBilletRepresentation = new TypeBilletRepresentation(r.getId());
		TypeBillet typeBillet = new TypeBillet(1);
		typeBillet.setNom("Admission Générale");
		typeBilletRepresentation.setNbBilletEmis(300);
		typeBilletRepresentation.setPrix(30);
		typeBilletRepresentation.setType(typeBillet);
		r.ajouterTypeBilletRepresentation(typeBilletRepresentation);
		r.setSalle(this.listeSalles.get(2));
		s1.ajouterRepresentation(r);

		Spectacle s2 = new Spectacle(2);
		s2.setNom("Les bobos");
		s2.setDescription("Les bobos en spectacle");
		s2.setPosterUrl("styles/images/les_bobos.jpg");
		List<Artiste> listeArtistes2 = new ArrayList<Artiste>();
		listeArtistes2.add(getStubArtistes().get(3));
		s2.setArtistes(listeArtistes2);
		s2.setType(getStubTypesSpectacles().get(0));

		Spectacle s3 = new Spectacle(3);
		s3.setNom("Decrepit birth event");
		s3.setDescription("Decrepit birth en spectacle");
		s3.setPosterUrl("styles/images/decrepit-birth-event.jpg");
		List<Artiste> listeArtistes3 = new ArrayList<Artiste>();
		listeArtistes3.add(getStubArtistes().get(2));
		s3.setArtistes(listeArtistes3);
		s3.setType(getStubTypesSpectacles().get(1));

		listeSpectacles.add(s1);
		listeSpectacles.add(s2);
		listeSpectacles.add(s3);

		this.listeSpectacles = listeSpectacles;
	}

	public Vector<Spectacle> getStubSpectacles() 
	{
		return this.listeSpectacles;
	}

	private void setStubArtistes() {

		List<Artiste> listeArtistes = new ArrayList<Artiste>();

		Artiste a1 = new Artiste(1);
		a1.setNom("Pat Lavallée");
		a1.setDescription("métalleux - bassiste");
		List<Tags> tags1 = new ArrayList<Tags>();
		Tags tag1 = new Tags();
		tag1.setNom("Bruiteur");
		tag1.setUrl("www.google.ca");
		tags1.add(tag1);
		a1.setTags(tags1);
		
		Artiste a2 = new Artiste(2);
		a2.setNom("Simon Turcotte");
		a2.setDescription("métalleux - guitariste");
		List<Tags> tags2= new ArrayList<Tags>();
		Tags tag2 = new Tags();
		tag2.setNom("Progressive metal");
		tag2.setUrl("www.google.ca");
		tags2.add(tag2);
		a2.setTags(tags2);

		Artiste a3 = new Artiste(3);
		a3.setNom("Francois Gagné");
		a3.setDescription("père de famille");
		List<Tags> tags3= new ArrayList<Tags>();
		Tags tag3 = new Tags();
		tag3.setNom("Fernand Gignac");
		tag3.setUrl("www.google.ca");
		tags3.add(tag3);
		a3.setTags(tags3);

		Artiste a4 = new Artiste(4);
		a4.setNom("Julien Pelletier");
		a4.setDescription("humoriste");
		List<Tags> tags4= new ArrayList<Tags>();
		Tags tag4 = new Tags();
		tag4.setNom("Reggaeton");
		tag4.setUrl("www.google.ca");
		tags4.add(tag4);
		a4.setTags(tags4);

		listeArtistes.add(a1);
		listeArtistes.add(a2);
		listeArtistes.add(a3);
		listeArtistes.add(a4);

		this.listeArtistes = listeArtistes;
	}

	public List<Artiste> getStubArtistes() 
	{
		return this.listeArtistes;
	}

	private void setStubTypesSpectacle() 
	{

		List<TypeSpectacle> listeTypesSpectacle = new ArrayList<TypeSpectacle>();

		TypeSpectacle ts1 = new TypeSpectacle();
		ts1.setNom("Humour");
		ts1.setDescription("Un spectacle qui fait rire");

		TypeSpectacle ts2 = new TypeSpectacle();
		ts2.setNom("Métal");
		ts2.setDescription("Un spectacle qui fait peur");

		TypeSpectacle ts3 = new TypeSpectacle();
		ts3.setNom("Country");
		ts3.setDescription("Un spectacle qui fait dur");

		TypeSpectacle ts4 = new TypeSpectacle();
		ts4.setNom("Classique");
		ts4.setDescription("Un spectacle qui endort");

		listeTypesSpectacle.add(ts1);
		listeTypesSpectacle.add(ts2);
		listeTypesSpectacle.add(ts3);
		listeTypesSpectacle.add(ts4);

		this.listeTypesSpectacle = listeTypesSpectacle;
	}

	public List<TypeSpectacle> getStubTypesSpectacles() 
	{
		return this.listeTypesSpectacle;
	}

	private void setStubTransactions() 
	{
		List<Transaction> listeTransactions = new ArrayList<Transaction>();
		List<Client> listeClients = getStubClient();
		List<Adresse> listeAdresses = getStubAdresse();
		
		Transaction t1 = new Transaction(1);
		t1.setNoConfirmationPaiement(1);
		t1.setNoConfirmationVente(1);
		t1.setClient(listeClients.get(0));
		t1.setAdresseFacturation(listeAdresses.get(0));
		t1.setAdresseLivraison(listeAdresses.get(0));
		t1.setCommande(null);

		Transaction t2 = new Transaction(1);
		t2.setNoConfirmationPaiement(1);
		t2.setNoConfirmationVente(1);
		t2.setClient(listeClients.get(1));
		t2.setAdresseFacturation(listeAdresses.get(1));
		t2.setAdresseLivraison(listeAdresses.get(1));
		t2.setCommande(null);
		
		Transaction t3 = new Transaction(1);
		t3.setNoConfirmationPaiement(1);
		t3.setNoConfirmationVente(1);
		t3.setClient(listeClients.get(2));
		t3.setAdresseFacturation(listeAdresses.get(2));
		t3.setAdresseLivraison(listeAdresses.get(2));
		t3.setCommande(null);
		
		Transaction t4 = new Transaction(1);
		t4.setNoConfirmationPaiement(1);
		t4.setNoConfirmationVente(1);
		t4.setClient(listeClients.get(3));
		t4.setAdresseFacturation(listeAdresses.get(3));
		t4.setAdresseLivraison(listeAdresses.get(3));
		t4.setCommande(null);
		
		listeTransactions.add(t1);
		listeTransactions.add(t2);
		listeTransactions.add(t3);
		listeTransactions.add(t4);

		this.listeTransactions = listeTransactions;
	}

	public List<Transaction> getStubTransactions() 
	{
		return this.listeTransactions;
	}

	private void setStubClient(){
		
		List<Client> listeClients = new ArrayList<Client>();
		List<Adresse> listeAdresses = getStubAdresse();
		
		Client c1 = new Client(1);
		c1.setMotDePasse("noob");
		c1.setIdentifiant("noob");
		c1.setNom("noob");
		c1.setCourriel("noob@gmail.com");
		c1.setAdresse(listeAdresses.get(0));

		Client c2 = new Client(2);
		c2.setMotDePasse("noob1");
		c2.setIdentifiant("noob1");
		c2.setNom("noob1");
		c2.setCourriel("noob1@gmail.com");
		c2.setAdresse(listeAdresses.get(1));
		
		Client c3 = new Client(3);
		c3.setMotDePasse("noob2");
		c3.setIdentifiant("noob2");
		c3.setNom("noob2");
		c3.setCourriel("noob2@gmail.com");
		c3.setAdresse(listeAdresses.get(2));
		
		Client c4 = new Client(4);
		c4.setMotDePasse("noob3");
		c4.setIdentifiant("noob3");
		c4.setNom("noob3");
		c4.setCourriel("noob3@gmail.com");
		c4.setAdresse(listeAdresses.get(3));
		
		listeClients.add(c1);
		listeClients.add(c2);
		listeClients.add(c3);
		listeClients.add(c4);

		this.listeClients = listeClients;
	}
	
	public List<Client> getStubClient() 
	{
		return this.listeClients;
	}
	
	private void setStubAdresse()
	{
		List<Adresse> listeAdresses = new ArrayList<Adresse>();
		
		Adresse adr1 = new Adresse(1);
		adr1.setCodePostal("H2B 2S3");
		adr1.setNoCivique(10140);
		adr1.setNomRue("Bruchési");
		adr1.setProvince("Qc");
		
		Adresse adr2 = new Adresse(2);
		adr2.setCodePostal("G1Q 1Q9");
		adr2.setNoCivique(2020);
		adr2.setNomRue("Du finfin");
		adr2.setProvince("Qc");
		
		Adresse adr3 = new Adresse(3);
		adr3.setCodePostal("H0H0H0");
		adr3.setNoCivique(10);
		adr3.setNomRue("Popa noel");
		adr3.setProvince("Qc");
		
		Adresse adr4 = new Adresse(4);
		adr4.setCodePostal("Q2W3E4");
		adr4.setNoCivique(1234);
		adr4.setNomRue("Bamboula");
		adr4.setProvince("On");
		
		listeAdresses.add(adr1);
		listeAdresses.add(adr2);
		listeAdresses.add(adr3);
		listeAdresses.add(adr4);
		
		this.listeAdresses = listeAdresses;
	}
	
	public List<Adresse> getStubAdresse()
	{
		return this.listeAdresses;
	}
	
	private void setStubSalles()
	{
		List<Salle> salles = new ArrayList<Salle>();
		Salle salle = new Salle();
		salle.setNom("Aucun");
		salles.add(salle);
		
		salle = new Salle(1);
		salle.setAdresse(this.listeAdresses.get(0));
		salle.setCapacite(50);
		salle.setNom("Centre Bell");
		salles.add(salle);
		
		salle = new Salle(2);
		salle.setAdresse(this.listeAdresses.get(1));
		salle.setCapacite(15);
		salle.setNom("Métropolis");
		salles.add(salle);
		
		salle = new Salle(3);
		salle.setAdresse(this.listeAdresses.get(2));
		salle.setCapacite(20);
		salle.setNom("Olympia");
		salles.add(salle);
		
		salle = new Salle(4);
		salle.setAdresse(this.listeAdresses.get(3));
		salle.setCapacite(20);
		salle.setNom("Stade olympique");
		salles.add(salle);
		
		this.listeSalles = salles;
	}
	
	public List<Salle> getStubSalle()
	{
		return this.listeSalles;
	}
}
