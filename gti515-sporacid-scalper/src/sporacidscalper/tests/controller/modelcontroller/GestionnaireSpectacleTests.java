package sporacidscalper.tests.controller.modelcontroller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sporacidscalper.controller.modelcontroller.IGestionnaireTransaction;
import sporacidscalper.controller.modelcontroller.stubcontroller.GestionnaireStubSpectacle;
import sporacidscalper.controller.modelcontroller.stubcontroller.GestionnaireStubTransaction;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.SalleBean;
import sporacidscalper.model.beans.SpectacleBean;

public class GestionnaireSpectacleTests 
{	
	private GestionnaireStubSpectacle gs;
	private int initialCount;
	
	@Before
	public void testSetup()
	{
		this.gs = new GestionnaireStubSpectacle();
		this.initialCount = this.gs.obtenirCatalogueSpectacles().size();
	}

	@After
	public void tearDown() throws Exception 
	{
		this.gs = null;	
	}

	@Test
	public void testIsDataLoaded() 
	{		
		assertTrue(this.gs.obtenirCatalogueSpectacles().size() > 0);
	}
	
	@Test
	public void testAjoutSpectacle() 
	{
		SpectacleBean s = new SpectacleBean(42);
		s.setDescription("The Answer");
		s.setNom("TEST");
	
		this.gs.ajouterSpectacle(s);
		SpectacleBean clone = this.gs.obtenirSpectacle(s.getId());
		
		assertNotNull(clone);
		assertTrue(this.gs.obtenirCatalogueSpectacles().size() > initialCount &&
			   clone.getId() == s.getId() &&
			   clone.getNom().equals(s.getNom()) &&
			   clone.getDescription().equals(s.getDescription()));
	}
	
	@Test
	public void testModificationSpectacle() 
	{
		SpectacleBean s = new SpectacleBean(123);
		s.setDescription("Viens de sept-iles");
		s.setNom("Joe Bobette");
	
		this.gs.ajouterSpectacle(s);
		
		s.setNom("MEH");
		s.setDescription("The Deception");
		
		this.gs.modifierSpectacle(s);
		SpectacleBean clone = this.gs.obtenirSpectacle(s.getId());
		
		assertTrue(clone != null &&
				   clone.getId() == s.getId() &&
			       clone.getNom().equals(s.getNom()) &&
			       clone.getDescription().equals(s.getDescription()));
	}
	
	@Test
	public void testSupprimerSpectacle()
	{
		IGestionnaireTransaction transactionManager = new GestionnaireStubTransaction();
		SpectacleBean s = new SpectacleBean(12);
		
		this.gs.ajouterSpectacle(s);
		assertTrue(this.gs.obtenirCatalogueSpectacles().size() == initialCount + 1);
		
		this.gs.supprimerSpectacle(s, transactionManager);
		assertTrue(this.gs.obtenirCatalogueSpectacles().size() == initialCount);
		
		SpectacleBean clone = this.gs.obtenirSpectacle(12);
		assertNull(clone);
	}
	
	@Test
	public void testAjouterRepresentation()
	{
		Date now = new Date();
		int parentId = this.gs.obtenirCatalogueSpectacles().get(0).getId();
		RepresentationBean r = new RepresentationBean(42, parentId);
		
		r.setDateDebutRepresentation(now);
		r.setDateFinRepresentation(now);
		r.setSalle(new SalleBean(1));
		r.setStatut("COMPLET");
		
		this.gs.ajouterRepresentation(parentId, r);
		RepresentationBean rep = this.gs.obtenirSpectacle(parentId).obtenirRepresentation(r.getId());
		
		assertNotNull(rep);
		assertTrue(this.gs.obtenirSpectacle(parentId).getRepresentations().size() == this.initialCount + 1 &&
				   rep.getId() == r.getId() &&
				   rep.getDateDebutRepresentation().equals(r.getDateDebutRepresentation()) &&
				   rep.getDateFinRepresentation().equals(r.getDateFinRepresentation()) &&
				   rep.getSalle().equals(r.getSalle()) &&
				   rep.getStatut().equals(r.getStatut()));
	}
	
	@Test
	public void testModifierRepresentation()
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testSupprimerRepresentation()
	{
		fail("Not yet implemented");
	}
}
