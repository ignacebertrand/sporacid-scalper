/**
 * 
 */
package sporacidscalper.tests.controller.modelcontroller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sporacidscalper.controller.modelcontroller.GestionnaireNouvelle;
import sporacidscalper.model.beans.NouvelleBean;
 
public class GestionnaireNouvelleTest 
{
	private GestionnaireNouvelle gn;
	private int initialCount;
	
	@Before
	public void testSetup()
	{
		gn = new GestionnaireNouvelle();
		initialCount = gn.obtenirNouvelles().length;
	}

	@After
	public void tearDown() throws Exception 
	{
		gn = null;
	}

	@Test
	public void testIsCreated() 
	{
		assertTrue(gn.obtenirNouvelles().length > 0);
	}

	@Test
	public void testAjoutNouvelle() 
	{
		NouvelleBean n = new NouvelleBean(42);
		n.setAuteur("Nicolo Milioto");
		n.setDescription("Euh je sais pas! M'en souviens plus");
		n.setTitre("Corruption");
		gn.ajouterNouvelle(n);
		
		NouvelleBean clone = gn.obtenirNouvelle(n.getId());
		
		assertNotNull(clone);
		assertTrue(gn.obtenirNouvelles().length > initialCount &&
				   clone.getId() == n.getId() &&
				   clone.getAuteur().equals(n.getAuteur()) &&
				   clone.getDescription().equals(n.getDescription()) &&
				   clone.getTitre().equals(n.getTitre()));
	}
	
	@Test
	public void testModificationNouvelle()
	{
		fail("Not yet Implemented!");
	}
	
	@Test
	public void testSuppressionNouvelle()
	{
		fail("Not yet implemented!");
	}
}
