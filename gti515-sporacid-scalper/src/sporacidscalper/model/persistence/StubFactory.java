package sporacidscalper.model.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sporacidscalper.model.*;

public class StubFactory 
{
	private StubFactory instance;
	private List<Client> listeClients;
	private List<Nouvelle> listeNouvelles;
	private List<Spectacle> listeSpectacles;
	private List<Transaction> listeTransactions;
	
	public List<Client> getStubClients()
	{
		return null;
	}
	
	
	
	public List<Nouvelle> getStubNouvelles()
	{
		List<Nouvelle> listeNouvelles = new ArrayList<Nouvelle>();
		
		Nouvelle n1 = new Nouvelle();
		n1.setAuteur("Simon Turcotte-Langevin");
		n1.setDate(new Date());
		n1.setTitre("Va chier Pat");
		n1.setDescription("self explanatory");
		
		Nouvelle n2 = new Nouvelle();
		n2.setAuteur("Pat Lavallée");
		n2.setDate(new Date());
		n2.setTitre("Je sors du placard");
		n2.setDescription("self explanatory");
		
		listeNouvelles.add(n1);
		listeNouvelles.add(n2);
		
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
