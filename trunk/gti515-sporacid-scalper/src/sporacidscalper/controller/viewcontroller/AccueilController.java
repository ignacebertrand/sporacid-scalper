package sporacidscalper.controller.viewcontroller;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.ui.ModelMap;

@Controller 
public class AccueilController 
{
	@RequestMapping("/accueil")
	public String getAccueil()
	{
		return "index";
	}
}
