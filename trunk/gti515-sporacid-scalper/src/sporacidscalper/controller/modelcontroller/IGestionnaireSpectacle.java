package sporacidscalper.controller.modelcontroller;

import java.util.List;

import sporacidscalper.model.beans.ArtisteBean;
import sporacidscalper.model.beans.SalleBean;
import sporacidscalper.model.beans.SpectacleBean;
import sporacidscalper.model.beans.TypeSpectacleBean;

public interface IGestionnaireSpectacle 
{
	/**
	 * Public method to add a Spectacle to the system.
	 * @param spectacleToAdd A Spectacle bean object that contains informations for the Spectacle to add
	 */
	public Integer ajouterSpectacle(SpectacleBean spectacleToAdd);
	/**
	 * Public method to edit a Spectacle in the system.
	 * @param spectacleToEdit A Spectacle bean object that contains modifications to a Spectacle
	 */
	public void modifierSpectacle(SpectacleBean spectacleToEdit);
	/**
	 * Public method to delete a Spectacle from the system.
	 * If some Representation are still linked to Transaction, then the deletion won't happen.
	 * We cannot delete something that has a relationship to a transaction.
	 * @param spectacleToDelete A Spectacle bean object that we wish to delete
	 * @param transactionManager Inversion of control for the transaction manager 
	 */
	public void supprimerSpectacle(SpectacleBean spectacleToDelete, IGestionnaireTransaction transactionManager);
	/**
	 * Public method to obtain a Spectacle from the system.
	 * @param spectacleId The Spectacle unique id
	 * @return The Spectacle bean associated with the Spectacle
	 */
	public SpectacleBean obtenirSpectacle(int spectacleId);
	/**
	 * Public method to obtain the list of all Spectacle in the system.
	 * @return The list of all Spectacle
	 */
	public List<SpectacleBean> obtenirCatalogueSpectacles();
    /**
     * Public method to obtain the list of Spectacle, with search criterias, in the system.
     * @return The list of all Spectacle
     */
    public List<SpectacleBean> obtenirCatalogueSpectacles(String searchCategory, String searchString);
    /**
     * Public method to get the number of ticket remaining for a Spectacle Representation.
     * @param spectacleId Id the the show
     * @param representationId Id of the representation
     * @param typeBilletId Id of ticket type
     * @param transactionManager Instance of a transaction manager
     * @return The number of ticket remaining
     */
    public int obtenirNbBilletRestant(int spectacleId, int representationId, int typeBilletId, IGestionnaireTransaction transactionManager);
	/**
	 * Public method to obtain the list of all Artiste in the system.
	 * @return The list of all Spectacle
	 */
	public List<ArtisteBean> obtenirCatalogueArtistes();
	/**
	 * Public method to obtain the list of all Salle in the system.
	 * @return The list of all Salle
	 */
	public List<SalleBean> obtenirCatalogueSalles();
	/**
	 * Public method to obtain the list of all types of Spectacle in the system.
	 * @return The list of all types of Spectacle
	 */
	public List<TypeSpectacleBean> obtenirCatalogueTypeSpectacle();
}