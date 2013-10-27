package eu.mickelson.bg.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.socialpainkiller.entities.cubenotes.Task;

import eu.mickelson.bg.ws.beans.TaskBean;
import eu.mickelson.bg.ws.task.business.TaskBO;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	TaskBO taskBO;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody
	public TaskBean test(){
		logger.debug("start");
		Task r = taskBO.test();
		TaskBean bean = new TaskBean();
		bean.setContent(r.getContent());
		logger.debug("end");
		return bean;
	}
	
}  // end public class TaskController
