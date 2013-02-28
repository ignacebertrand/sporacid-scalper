package sporacidscalper.tests.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sporacidscalper.model.*;
import sporacidscalper.model.beans.*;

import static org.junit.Assert.assertNotNull;

public class ModelObjectToBeanTests 
{
	private Adresse adr;
	private Artiste art;
	private Client cln;
	private Commande cmd;
	private ItemCommande itc;
	private ItemPanierAchat ipa;
	private Nouvelle nvl;
	private PanierAchat pa;
	private Representation rep;
	private Salle salle;
	private Spectacle spc;
	private Tags tags;
	private Transaction trans;
	private TypeBillet tb;
	private TypeBilletRepresentation tbr;
	private TypeSpectacle ts;
	
	@Before
	public void testSetup()
	{
		this.adr = new Adresse();		
		this.art = new Artiste();
		this.cln = new Client();
		this.cmd = new Commande();
		this.itc = new ItemCommande();
		this.ipa = new ItemPanierAchat();
		this.nvl = new Nouvelle(5);
		this.pa = new PanierAchat();
		this.rep = new Representation();
		this.salle = new Salle();
		this.spc = new Spectacle();
		this.tags = new Tags();
		this.trans = new Transaction();
		this.tb = new TypeBillet();
		this.tbr = new TypeBilletRepresentation(5);
		this.ts = new TypeSpectacle();
	}

	@After
	public void tearDown() throws Exception 
	{
		this.adr = null;
		this.art = null;
		this.cln = null;
		this.cmd = null;
		this.itc = null;
		this.ipa = null;
		this.nvl = null;
		this.pa =  null;
		this.rep = null;
		this.salle = null;
		this.spc = null;
		this.tags = null;
		this.trans = null;
		this.tb = null;
		this.tbr = null;
		this.ts = null;
	}

	@Test
	public void testToBean() 
	{
		//TODO: Arrange getBean defects.
		assertNotNull((AdresseBean)this.adr.getBean());
		//assertNotNull((ArtisteBean)this.art.getBean());
		//assertNotNull((ClientBean)this.cln.getBean());
		//assertNotNull((CommandeBean)this.cmd.getBean());
		assertNotNull((ItemCommandeBean)this.itc.getBean());
		assertNotNull((ItemPanierAchatBean)this.ipa.getBean());
		assertNotNull((NouvelleBean)this.nvl.getBean());
		assertNotNull((PanierAchatBean)this.pa.getBean());
		assertNotNull((RepresentationBean)this.rep.getBean());
		assertNotNull((SalleBean)this.salle.getBean());
		assertNotNull((SpectacleBean)this.spc.getBean());
		assertNotNull((TagsBean)this.tags.getBean());
		//assertNotNull((TransactionBean)this.trans.getBean());
		assertNotNull((TypeBilletBean)this.tb.getBean());
		assertNotNull((TypeBilletRepresentationBean)this.tbr.getBean());
		assertNotNull((TypeSpectacleBean)this.ts.getBean());
	}

}
