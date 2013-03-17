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
		 
		ApplicationMessages.ajouterMessage("D�lai de 20 minutes expir� pour commander", session);
		 
		this.cancel();
		 
	}
}
