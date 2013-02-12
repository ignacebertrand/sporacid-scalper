package sporacidscalper.controller.viewcontroller;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.ui.ModelMap;

@Controller 
@RequestMapping("/billets")
public class BilletsController 
{
	@RequestMapping(method = RequestMethod.GET) 
	public void doGet()
	{
		
	}
}
