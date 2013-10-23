package eu.mickelson.bg.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import eu.mickelson.bg.ws.task.business.TaskBO;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	TaskBO taskBO;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody
	public String test(){
		logger.debug("start");
		String r = taskBO.test();
		logger.debug("end");
		return r;
	}
	
}  // end public class TaskController
