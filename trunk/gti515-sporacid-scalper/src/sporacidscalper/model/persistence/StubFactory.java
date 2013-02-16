package sporacidscalper.model.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.model.Artiste;
import sporacidscalper.model.Nouvelle;
import sporacidscalper.model.Spectacle;
import sporacidscalper.model.Transaction;
import sporacidscalper.model.TypeSpectacle;

import com.sun.security.ntlm.Client;

public class StubFactory {
	
	private static StubFactory instance;
	private List<Client> listeClients;
	private List<Artiste> listeArtistes;
	private List<Nouvelle> listeNouvelles;
	private List<Spectacle> listeSpectacles;
	private List<Transaction> listeTransactions;
	private List<TypeSpectacle> listeTypesSpectacle;

	private StubFactory() {
		setStubNouvelles();
		setStubArtistes();
		setStubTypesSpectacle();
		setStubSpectacles();
	}

	public static StubFactory getInstance() {
		if (StubFactory.instance == null)
			StubFactory.instance = new StubFactory();

		return StubFactory.instance;
	}

	public List<Client> getStubClients() {

		return listeClients;
	}

	private void setStubNouvelles() {
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
		return listeNouvelles;
	}

	private void setStubSpectacles() {

		List<Spectacle> listeSpectacles = new ArrayList<Spectacle>();

		Spectacle s1 = new Spectacle();
		s1.setNom("Les trois accords");
		s1.setDescription("Les trois accords en spectacle");
		s1.setPosterUrl("/gti515-sporacid-scalper/web-content/styles/images/trois_accords.jpg");
		List<Artiste> listeArtistes1 = new ArrayList<Artiste>();
		listeArtistes1.add(getStubArtistes().get(0));
		listeArtistes1.add(getStubArtistes().get(1));
		s1.setArtistes(listeArtistes1);
		s1.setType(getStubTypesSpectacles().get(2));

		Spectacle s2 = new Spectacle();
		s2.setNom("Les bobos");
		s2.setDescription("Les bobos en spectacle");
		s2.setPosterUrl("/gti515-sporacid-scalper/web-content/styles/images/les_bobos.jpg");
		List<Artiste> listeArtistes2 = new ArrayList<Artiste>();
		listeArtistes2.add(getStubArtistes().get(3));
		s2.setArtistes(listeArtistes2);
		s2.setType(getStubTypesSpectacles().get(0));

		Spectacle s3 = new Spectacle();
		s3.setNom("Decrepit birth event");
		s3.setDescription("Decrepit birth en spectacle");
		s3.setPosterUrl("/gti515-sporacid-scalper/web-content/styles/images/decrepit-birth-event.jpg");
		List<Artiste> listeArtistes3 = new ArrayList<Artiste>();
		listeArtistes3.add(getStubArtistes().get(2));
		s3.setArtistes(listeArtistes3);
		s3.setType(getStubTypesSpectacles().get(1));

		listeSpectacles.add(s1);
		listeSpectacles.add(s2);
		listeSpectacles.add(s3);

		this.listeSpectacles = listeSpectacles;
	}

	public List<Spectacle> getStubSpectacles() {
		return listeSpectacles;
	}

	private void setStubArtistes() {

		List<Artiste> listeArtistes = new ArrayList<Artiste>();

		Artiste a1 = new Artiste();
		a1.setNom("Pat Lavallée");
		a1.setDescription("métalleux - bassiste");

		Artiste a2 = new Artiste();
		a2.setNom("Simon Turcotte");
		a2.setDescription("métalleux - guitariste");

		Artiste a3 = new Artiste();
		a3.setNom("Francois Gagné");
		a3.setDescription("père de famille");

		Artiste a4 = new Artiste();
		a4.setNom("Julien Pelletier");
		a4.setDescription("humoriste");

		listeArtistes.add(a1);
		listeArtistes.add(a2);
		listeArtistes.add(a3);
		listeArtistes.add(a4);

		this.listeArtistes = listeArtistes;
	}

	public List<Artiste> getStubArtistes() {
		return listeArtistes;
	}

	private void setStubTypesSpectacle() {

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

	public List<TypeSpectacle> getStubTypesSpectacles() {
		return listeTypesSpectacle;
	}

	public List<Transaction> getStubTransactions() {
		return listeTransactions;
	}
}
