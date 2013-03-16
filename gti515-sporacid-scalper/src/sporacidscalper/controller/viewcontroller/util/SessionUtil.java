package sporacidscalper.controller.viewcontroller.util;

import javax.servlet.http.HttpSession;

import sporacidscalper.model.beans.PanierAchatBean;

public final class SessionUtil 
{
	/**
	 * Constant for the session key to access the shopping cart.
	 */
	private static final String cCleSessionPanierAchat = "PanierAchat";
	
	/**
	 * Constant for the session key to access the shopping cart item count.
	 */
	public static final String cCleSessionCompteurItemPanierAchat = "CompteurPanierAchat";
	
	/**
	 * Constant for the session key to access the shopping cart total.
	 */
	public static final String cCleSessionTotalPanierAchat = "TotalPanierAchat";
	
	/**
	 * Private method to obtain the shopping cart from a session.
	 * @param session An Http Session object for the client's session
	 * @return The bean for the shopping cart
	 */
	public static PanierAchatBean obtenirPanierAchat(HttpSession session)
	{
		PanierAchatBean panier = (PanierAchatBean) session.getAttribute(cCleSessionPanierAchat);
		
		if(panier == null)
		{
			panier = new PanierAchatBean();
			
			// Save the shopping cart in the session
			session.setAttribute(cCleSessionPanierAchat, panier);
			
			// Update shopping cart associated values
			updateValeursPanierAchat(session);
		}
		
		return panier;
	}
	/**
	 * 
	 * @param session
	 */
	public static void supprimerPanierAchat(HttpSession session)
	{
		// Delete the shopping cart from the session
		session.removeAttribute(cCleSessionPanierAchat);
		
		// Delete shopping cart's associated values from the session
		session.removeAttribute(cCleSessionCompteurItemPanierAchat);
		session.removeAttribute(cCleSessionTotalPanierAchat);
	}
	
	/**
	 * Private method to update the shopping cart associated values for view use
	 * @param session An Http Session object for the client's session
	 */
	public static void updateValeursPanierAchat(HttpSession session)
	{
		PanierAchatBean panier = obtenirPanierAchat(session); 
		
		// Update the shopping cart item count
		session.setAttribute(cCleSessionCompteurItemPanierAchat, panier.getItems().size());
		
		// Update the shopping cart total
		session.setAttribute(cCleSessionTotalPanierAchat, panier.getTotal());
	}
}
