package sporacidscalper.model.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.controller.modelcontroller.GestionnaireNouvelle;
import sporacidscalper.model.*;

public class StubFactory 
{
	private static StubFactory instance;
	private static List<Client> listeClients;
	private static List<Nouvelle> listeNouvelles;
	private static List<Spectacle> listeSpectacles;
	private static List<Transaction> listeTransactions;
	
	private StubFactory()
	{
		setStubNouvelles();
	}
	
	public StubFactory getInstance()
	{
		if(StubFactory.instance == null)
			StubFactory.instance = new StubFactory();
		
		return StubFactory.instance;
	}
	
	public List<Client> getStubClients()
	{
		return null;
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
		
		StubFactory.listeNouvelles = listeNouvelles;
	}
	
	public static List<Nouvelle> getStubNouvelles()
	{
		return listeNouvelles;
	}
	
	public static List<Spectacle> getStubSpectacles()
	{
		return null;
	}
	
	public static List<Transaction> getStubTransactions()
	{
		return null;
	}
}
