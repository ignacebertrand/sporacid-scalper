package sporacidscalper.tests.model;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sporacidscalper.model.*;
import sporacidscalper.model.beans.*;

public class BeanToModelObjectTests 
{
	private AdresseBean adrBean;
	private ArtisteBean artBean;
	private ClientBean clnBean;
	private CommandeBean cmdBean;
	private ItemCommandeBean itcBean;
	private NouvelleBean nvlBean;
	private RepresentationBean repBean;
	private SalleBean salleBean;
	private SpectacleBean spcBean;
	private TagsBean tagsBean;
	private TransactionBean transBean;
	private TypeBilletBean tbBean;
	private TypeBilletRepresentationBean tbrBean;
	private TypeSpectacleBean tsBean;
	
	@Before
	public void testSetup()
	{
		this.adrBean = new AdresseBean();		
		this.artBean = new ArtisteBean();
		this.clnBean = new ClientBean();
		this.cmdBean = new CommandeBean();
		this.itcBean = new ItemCommandeBean();
		this.nvlBean = new NouvelleBean(5);
		this.repBean = new RepresentationBean();
		this.salleBean = new SalleBean();
		this.spcBean = new SpectacleBean();
		this.tagsBean = new TagsBean();
		this.transBean = new TransactionBean();
		this.tbBean = new TypeBilletBean();
		this.tbrBean = new TypeBilletRepresentationBean();
		this.tsBean = new TypeSpectacleBean();
	}

	@After
	public void tearDown() throws Exception 
	{
		this.adrBean = null;
		this.artBean = null;
		this.clnBean = null;
		this.cmdBean = null;
		this.itcBean = null;
		this.nvlBean = null;
		this.repBean = null;
		this.salleBean = null;
		this.spcBean = null;
		this.tagsBean = null;
		this.transBean = null;
		this.tbBean = null;
		this.tbrBean = null;
		this.tsBean = null;
	}

	@Test
	public void testToModelObject()
	{
		assertNotNull((Adresse)this.adrBean.getModelObject());
		assertNotNull((Artiste)this.artBean.getModelObject());
		assertNotNull((Client)this.clnBean.getModelObject());
		assertNotNull((Commande)this.cmdBean.getModelObject());
		assertNotNull((ItemCommande)this.itcBean.getModelObject());
		assertNotNull((Nouvelle)this.nvlBean.getModelObject());
		assertNotNull((Representation)this.repBean.getModelObject());
		assertNotNull((Salle)this.salleBean.getModelObject());
		assertNotNull((Spectacle)this.spcBean.getModelObject());
		assertNotNull((Tags)this.tagsBean.getModelObject());
		assertNotNull((Transaction)this.transBean.getModelObject());
		assertNotNull((TypeBillet)this.tbBean.getModelObject());
		assertNotNull((TypeBilletRepresentation)this.tbrBean.getModelObject());
		assertNotNull((TypeSpectacle)this.tsBean.getModelObject());		
	}

}
