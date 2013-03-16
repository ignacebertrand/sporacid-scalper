package sporacidscalper.view.presentation;

import sporacidscalper.model.beans.TransactionBean;

public interface IPresentationPaiement 
{
	/**
	 * Presentation logic for a payment form.
	 * @param transaction The transaction 
	 * @return A html formatted string for the payment form presentation
	 */
	public String presenterFormulairePaiement(TransactionBean transaction);
}
