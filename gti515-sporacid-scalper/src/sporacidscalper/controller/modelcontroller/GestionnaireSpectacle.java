package sporacidscalper.controller.modelcontroller;

import java.util.ArrayList;
import java.util.List;

import sporacidscalper.model.*;

public class GestionnaireSpectacle
{
	private List<Spectacle> listeSpectacles;
	private static GestionnaireSpectacle instance;

	private GestionnaireSpectacle()
	{
		this.listeSpectacles = new ArrayList<Spectacle>();
	}

	public static GestionnaireSpectacle getInstance()
	{
		if(GestionnaireSpectacle.instance == null)
			GestionnaireSpectacle.instance = new GestionnaireSpectacle();
		
		return GestionnaireSpectacle.instance;
	}

	public void ajouterSpectacle()
	{
		throw new UnsupportedOperationException();
	}

	public void modifierSpectacle()
	{
		throw new UnsupportedOperationException();
	}

	public void supprimerSpectacle()
	{
		throw new UnsupportedOperationException();
	}

	public void ajouterRepresentation()
	{
		throw new UnsupportedOperationException();
	}

	public void modifierRepresentation()
	{
		throw new UnsupportedOperationException();
	}

	public void supprimerRepresentation()
	{
		throw new UnsupportedOperationException();
	}

	public int obtenirNbBilletRestant()
	{
		throw new UnsupportedOperationException();
	}

	public Representation[] obtenirRepresentations()
	{
		throw new UnsupportedOperationException();
	}

	public Spectacle[] obtenirSpectacles()
	{
		throw new UnsupportedOperationException();
	}
}