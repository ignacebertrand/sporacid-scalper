package sporacidscalper.view.presentation;

import sporacidscalper.model.beans.TransactionBean;
import sporacidscalper.view.beans.FormulairePaiementSecurise;

public interface IPresentationPaiement 
{
	/**
	 * Presentation logic for a payment form.
	 * @param formulaire A form object
	 * @return A html formatted string for the payment form presentation
	 */
	public String presenterFormulairePaiement(FormulairePaiementSecurise formulaire);
	/**
	 * Presentation logic for a payment confirmation.
	 * @param transaction A transaction object
	 * @return A html formatted string for the payment confirmation presentation
	 */
	public String presenterConfirmationPaiement(TransactionBean transaction);
}
