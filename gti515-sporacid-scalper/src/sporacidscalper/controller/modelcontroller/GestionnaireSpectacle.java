package sporacidscalper.controller.modelcontroller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import sporacidscalper.controller.modelcontroller.IGestionnaireSpectacle;
import sporacidscalper.controller.modelcontroller.IGestionnaireTransaction;
import sporacidscalper.controller.modelcontroller.util.HibernateQueriesUtil;
import sporacidscalper.model.Artiste;
import sporacidscalper.model.Salle;
import sporacidscalper.model.Spectacle;
import sporacidscalper.model.TypeSpectacle;
import sporacidscalper.model.beans.ArtisteBean;
import sporacidscalper.model.beans.SalleBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.TypeSpectacleBean;

public class GestionnaireSpectacle implements IGestionnaireSpectacle 
{
	/**
	 * Reference to the SessionFactory implementation
	 * of the application context bean configuration.
	 */
	private SessionFactory sessionFactory;

	/**
	 * Empty constructor
	 */
	public GestionnaireSpectacle() { }

	/**
	 * Public method to add a Spectacle to the DB.
	 * @param spectacleToAdd  A Spectacle bean object that contains informations for the Spectacle to add
	 */
	@Override
	public Integer ajouterSpectacle(SpectacleBean spectacleToAdd) 
	{
		// Get the model object from the bean
		Spectacle entityToAdd = (Spectacle) spectacleToAdd.getModelObject();
		
		// Add the entity
		Integer entityId = HibernateQueriesUtil.<Spectacle>ajouterEntite(entityToAdd, sessionFactory);
		
		// Return the id of the saved transaction or null
		return entityId;
	}

	/**
	 * Public method to edit a Spectacle in the database.
	 * @param spectacleToEdit A Spectacle bean object that contains modifications to a Spectacle
	 */
	@Override
	public void modifierSpectacle(SpectacleBean spectacleToEdit) 
	{
		// Get the model object from the bean
		Spectacle entityToEdit = (Spectacle) spectacleToEdit.getModelObject();
		
		// Update the entity
		HibernateQueriesUtil.<Spectacle>modifierEntite(entityToEdit, sessionFactory);
	}

	/**
	 * Public method to delete a Spectacle from the DB. If some
	 * Representation are still linked to Transaction, then the deletion won't
	 * happen. We cannot delete something that has a relationship to a
	 * transaction.
	 * @param spectacleToDelete  A Spectacle bean object that we wish to delete
	 * @param transactionManager Inversion of control for the transaction manager
	 */
	@Override
	public void supprimerSpectacle(SpectacleBean spectacleToDelete, IGestionnaireTransaction transactionManager) 
	{
		// Flag to check if we can delete the spectacle or not.
		/*boolean okForDeletion = true;

		for(Representation representation : spectacleToDelete.getRepresentations())
		{
			int transactionCount = transactionManager.obtenirTransactionsRepresentationCount(representation.getId());
			
			if(transactionCount > 0)
			{
				//There's transaction linked to that Spectacle, we cannot delete it.
				okForDeletion = false;
				break;
			}
		}*/
		
		// Get the model object from the bean
		Spectacle entityToDelete = (Spectacle) spectacleToDelete.getModelObject();
		
		// Delete the entity
		HibernateQueriesUtil.<Spectacle>supprimerEntite(entityToDelete, sessionFactory);
	}

	/**
	 * Public method to obtain a Spectacle from the system.
	 * @param spectacleId The Spectacle unique id
	 * @return The Spectacle bean associated with the Spectacle
	 */
	@Override
	public SpectacleBean obtenirSpectacle(int spectacleId) 
	{
		// Bean object to return
		SpectacleBean bean = null;
		
		// Get the entity
		Spectacle entity = HibernateQueriesUtil.<Spectacle>obtenirEntite(spectacleId, sessionFactory, Spectacle.class);
		
		if(entity != null)
			bean = (SpectacleBean) entity.getBean();
		
		// Return the bean
		return bean;
	}

	/**
	 * Public method to obtain the list of all Spectacle in the system.
	 * 
	 * @return The list of all Spectacle
	 */
	@Override
	public List<SpectacleBean> obtenirCatalogueSpectacles() 
	{
		// Beans list to return
		List<SpectacleBean> beans = new ArrayList<SpectacleBean>();
		
		// Get the entities
		List<Spectacle> spectacleEntities = HibernateQueriesUtil.<Spectacle>obtenirEntites(sessionFactory, Spectacle.class);

		// Transform entities into bean. Stupid iteration through the whole list but whatever.
		// We got transfer objects!
		for (Spectacle spectacle : spectacleEntities) 
			beans.add((SpectacleBean) spectacle.getBean());

		// Return the beans
		return beans;
	}
	
	/**
	 * Public method to obtain the list of Spectacle, withn search criterias, in the system.
	 * @return The list of all Spectacle
	 */
	@Override
	public List<SpectacleBean> obtenirCatalogueSpectacles(String searchCategory, String searchString)
	{
		// Beans list to return
		List<SpectacleBean> beans = new ArrayList<SpectacleBean>();
		
		// Get the entities
		List<Spectacle> spectacleEntities = HibernateQueriesUtil.<Spectacle>obtenirEntites(sessionFactory, Spectacle.class);
		
		int iSearchCategory = 0;
		
		// if only numbers value
		if(searchCategory != null && searchCategory.matches("{" + searchCategory.length() + "}\\d"))
			iSearchCategory = Integer.parseInt(searchCategory);
		
		if(searchString == null)
			searchString = "";
	
		// Apply the search filter
		for(Spectacle spectacle : spectacleEntities) 
		{
			if((spectacle.getTypeSpectacle() != null && (
					spectacle.getTypeSpectacle().getId() == iSearchCategory || iSearchCategory == 0)) &&
			   (spectacle.getNom() != null && (
				   	spectacle.getNom().toLowerCase().contains(searchString.toLowerCase()) || searchString.equals(""))))
				beans.add((SpectacleBean)spectacle.getBean());
		}
		
		// Return the beans
		return beans;
	}

    /**
     * Public method to get the number of ticket remaining for a Spectacle Representation.
     * @param spectacleId Id the the show
     * @param representationId Id of the representation
     * @param typeBilletId Id of ticket type
     * @param transactionManager Instance of a transaction manager
     * @return The number of ticket remaining
     */
	@Override
	public int obtenirNbBilletRestant(int spectacleId, int representationId, int typeBilletId, IGestionnaireTransaction transactionManager)
	{
		int salleCapacity = obtenirSpectacle(spectacleId).getRepresentation(representationId).obtenirTypeBilletRepresentation(typeBilletId).getNbBilletEmis();
		int transactionsCnt = transactionManager.obtenirTransactionsRepresentationCount(representationId);
		return salleCapacity - transactionsCnt;	
	}
	
	/**
	 * Public method to obtain the list of all Artiste in the system.
	 * @return The list of all Spectacle
	 */
	@Override
	public List<ArtisteBean> obtenirCatalogueArtistes() 
	{
		// Beans list to return
		List<ArtisteBean> beans = new ArrayList<ArtisteBean>();
		
		// Get the entities
		List<Artiste> artisteEntities = HibernateQueriesUtil.<Artiste>obtenirEntites(sessionFactory, Artiste.class);
		
		// Transform entities into bean. Stupid iteration through the whole list but whatever.
		// We got transfer objects!
		for (Artiste artiste : artisteEntities) 
			beans.add((ArtisteBean) artiste.getBean());
		
		// Return the beans
		return beans;
	}

	/**
	 * Public method to obtain the list of all types of Spectacle in the system.
	 * @return The list of all types of Spectacle
	 */
	@Override
	public List<TypeSpectacleBean> obtenirCatalogueTypeSpectacle() 
	{
		// Beans list to return
		List<TypeSpectacleBean> beans = new ArrayList<TypeSpectacleBean>();
		
		// Get the entities
		List<TypeSpectacle> typeSpectacleEntities = HibernateQueriesUtil.<TypeSpectacle>obtenirEntites(sessionFactory, TypeSpectacle.class);
		
		// Transform entities into bean. Stupid iteration through the whole list but whatever.
		// We got transfer objects!
		for (TypeSpectacle type : typeSpectacleEntities) 
			beans.add((TypeSpectacleBean) type.getBean());
		
		// Return the beans
		return beans;
	}

	/**
	 * Public method to obtain the list of all Salle in the system.
	 * @return The list of all Salle
	 */
	@Override
	public List<SalleBean> obtenirCatalogueSalles() 
	{
		// Beans list to return
		List<SalleBean> beans = new ArrayList<SalleBean>();
		
		// Get the entities
		List<Salle> salleEntities = HibernateQueriesUtil.<Salle>obtenirEntites(sessionFactory, Salle.class);
		
		// Transform entities into bean. Stupid iteration through the whole list but whatever.
		// We got transfer objects!
		for (Salle salle : salleEntities) 
			beans.add((SalleBean) salle.getBean());
		
		// Return the beans
		return beans;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}