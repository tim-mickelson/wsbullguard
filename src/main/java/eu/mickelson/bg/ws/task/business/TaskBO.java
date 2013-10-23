package eu.mickelson.bg.ws.task.business;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.socialpainkiller.entities.cubenotes.Task;

public class TaskBO {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	EntityManager entityManager;	
	@Autowired
	DataSource dataSource;
	
	public String test(){
		logger.debug("start");
		Long id = 14011L;
		Task task = entityManager.find(Task.class, id);
		
		String msg  = "";
		if(task==null)
			msg = "task is null";
		else
			msg = task.getContent();
		logger.debug("end");
		return msg;
	}
	
}
