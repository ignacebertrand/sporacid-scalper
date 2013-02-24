package sporacidscalper.tests.controller.modelcontroller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sporacidscalper.controller.modelcontroller.GestionnaireSpectacle;
import sporacidscalper.controller.modelcontroller.GestionnaireTransaction;
import sporacidscalper.controller.modelcontroller.IGestionnaireTransaction;
import sporacidscalper.model.beans.SpectacleBean;

public class GestionnaireSpectacleTests 
{	
	@Before
	public void testSetup()
	{
	}

	@After
	public void tearDown() throws Exception 
	{
			
	}

	@Test
	public void testIsCreated() 
	{
		GestionnaireSpectacle gestionnaireSpectacle = new GestionnaireSpectacle();
		
		assertTrue(gestionnaireSpectacle.obtenirSpectacles().length > 0 &&
				   gestionnaireSpectacle.obtenirCategory().length > 0);
	}
	
	@Test
	public void testAjoutSpectacle() 
	{
		GestionnaireSpectacle gestionnaireSpectacle = new GestionnaireSpectacle();
		int initialCount = gestionnaireSpectacle.obtenirSpectacles().length;
		SpectacleBean s = new SpectacleBean(42);
		s.setDescription("The Answer");
		s.setNom("TEST");
	
		gestionnaireSpectacle.ajouterSpectacle(s);
		SpectacleBean clone = gestionnaireSpectacle.obtenirSpectacle(s.getId());
		
		assertNotNull(clone);
		assertTrue(gestionnaireSpectacle.obtenirSpectacles().length > initialCount &&
			   clone.getId() == s.getId() &&
			   clone.getNom().equals(s.getNom()) &&
			   clone.getDescription().equals(s.getDescription()));
		
		gestionnaireSpectacle = null;
	}
	
	@Test
	public void testModificationSpectacle() 
	{
		GestionnaireSpectacle gestionnaireSpectacle = new GestionnaireSpectacle();
		int initialCount = gestionnaireSpectacle.obtenirSpectacles().length;
		SpectacleBean s = new SpectacleBean(123);
		s.setDescription("Viens de sept-iles");
		s.setNom("Joe Bobette");
	
		gestionnaireSpectacle.ajouterSpectacle(s);
		
		s.setNom("MEH");
		s.setDescription("The Deception");
		
		gestionnaireSpectacle.modifierSpectacle(s);
		SpectacleBean clone = gestionnaireSpectacle.obtenirSpectacle(s.getId());
		
		assertTrue(clone != null &&
				   clone.getId() == s.getId() &&
			       clone.getNom().equals(s.getNom()) &&
			       clone.getDescription().equals(s.getDescription()) && 
			       gestionnaireSpectacle.obtenirSpectacles().length == initialCount + 1);
		
		gestionnaireSpectacle = null;
	}
	
	@Test
	public void testSuppressionSpectacle()
	{
		GestionnaireSpectacle gestionnaireSpectacle = new GestionnaireSpectacle();
		int initialCount = gestionnaireSpectacle.obtenirSpectacles().length;
		IGestionnaireTransaction transactionManager = new GestionnaireTransaction();
		
		SpectacleBean s = new SpectacleBean(12);
		gestionnaireSpectacle.ajouterSpectacle(s);
		assertTrue(gestionnaireSpectacle.obtenirSpectacles().length == initialCount + 1);
		
		gestionnaireSpectacle.supprimerSpectacle(s, transactionManager);
		assertTrue(gestionnaireSpectacle.obtenirSpectacles().length == initialCount);
		
		SpectacleBean clone = gestionnaireSpectacle.obtenirSpectacle(12);
		assertNull(clone);
		
		//gestionnaireSpectacle = null;
	}
}
