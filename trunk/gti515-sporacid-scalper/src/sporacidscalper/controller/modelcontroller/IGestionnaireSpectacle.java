package sporacidscalper.controller.modelcontroller;

import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.SpectacleBean;

public interface IGestionnaireSpectacle 
{
	/**
	 * Public method to add a Spectacle to the system.
	 * @param spectacleToAdd A Spectacle bean object that contains informations for the Spectacle to add
	 */
	public void ajouterSpectacle(SpectacleBean spectacleToAdd);
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
	 */
	public void supprimerSpectacle(SpectacleBean spectacleToDelete);
	/**
	 * Public method to add a Representation to a Spectacle.
	 * @param spectacleId The Spectacle id to which we want to add a Representation
	 * @param representationToAdd A Representation bean that contains informations for the Representation to add
	 */
	public void ajouterRepresentation(int spectacleId, RepresentationBean representationToAdd);
	/**
	 * Public method to edit a Representation of a Spectacle.
	 * @param spectacleId The Spectacle id to which we want to edit a Representation
	 * @param representationToEdit A Representation bean object that contains modifications to a Representation
	 */
	public void modifierRepresentation(int spectacleId, RepresentationBean representationToEdit);
	/**
	 * Public method to delete a Representation from a Spectacle.
	 * If the Representation is still linked to Transaction, then the deletion won't happen.
	 * We cannot delete something that has a relationship to a transaction.
	 * @param spectacleId The Spectacle id to which we want to delete a Representation
	 * @param representationToDelete A Representation bean object that we wish to delete
	 */
	public void supprimerRepresentation(int spectacleId, RepresentationBean representationToDelete);
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
	public SpectacleBean[] obtenirSpectacles();
	/**
	 * Public method to get the number of ticket remaining for a Spectacle Representation.
	 * @return The number of ticket remaining
	 */
	public int obtenirNbBilletRestant(int spectacleId, int representationId);
}
