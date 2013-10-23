package eu.mickelson.bg.ws.task.business;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskBO {
	Logger logger = LoggerFactory.getLogger(getClass());
//	@Autowired
	EntityManager entityManager;	
	@Autowired
	DataSource dataSource;
	
	public String test(){
		logger.debug("start");
		String msg  = "";
		if(entityManager==null)
			msg = "entityManager is null";
		else
			msg = "entityManager is not null";
		logger.debug("end");
		return msg;
	}
	
}
