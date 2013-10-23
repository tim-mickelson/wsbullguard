package eu.mickelson.bg.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody
	public String test(){
		String r = "prova";
		System.out.println("HELLO WORLD");
		return r;
	}
	
}  // end public class TaskController
