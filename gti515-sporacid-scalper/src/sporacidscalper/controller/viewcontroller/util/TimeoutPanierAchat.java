package sporacidscalper.controller.viewcontroller.util;

import java.util.TimerTask;

import javax.servlet.http.HttpSession;

public class TimeoutPanierAchat extends TimerTask{

	private HttpSession session;
	
	public TimeoutPanierAchat(HttpSession session) {
		this.session = session;
	}
	
	public void run() 
	{
		SessionUtil.supprimerPanierAchat(session);
		 
		ApplicationMessages.ajouterMessage("Délai de 20 minutes expiré pour commander", session);
		 
		this.cancel();
		 
	}
}
