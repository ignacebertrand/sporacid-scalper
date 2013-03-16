package sporacidscalper.controller.viewcontroller.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class ApplicationMessages 
{
	/**
	 * Private constant for the request attribute key to access the list of application messages.
	 */
	private static final String cCleRequestListeMessage = "ApplicationMessages";
	
	/**
	 * Public static method to add a message to the messages list of a request object.
	 * @param message A message to log
	 * @param request An http request object
	 */
	public static void ajouterMessage(String message, HttpServletRequest request)
	{
		List<String> listeMessages = obtenirMessages(request);
		listeMessages.add(message);
	}
	
	/**
	 * Public static method to obtain the message list from a request object.
	 * @param request An http request object
	 * @return The list of messages for the request object
	 */
	public static List<String> obtenirMessages(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		List<String> listeMessages = (List<String>) session.getAttribute(ApplicationMessages.cCleRequestListeMessage);
		
		if (listeMessages == null)
		{
			listeMessages = new ArrayList<String>();
			session.setAttribute(cCleRequestListeMessage, listeMessages);
		}
		
		return listeMessages;
	}
	
	public static void viderMessages(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.setAttribute(cCleRequestListeMessage, new ArrayList<String>());
		
	}
}
