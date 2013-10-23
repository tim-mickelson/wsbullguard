package eu.mickelson.bg.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;

import eu.mickelson.bg.ws.task.business.TaskBO;

/**
 *  @ComponentScan(basePackages = {“eu.mickelson.bg.ws.controller”}), this is the same as 
 *  <context:component-scan base-package=”eu.mickelson.bg.ws.controller”/>
 *  
 * @author vaio
 *
 */
@Configuration
@ComponentScan(basePackages="eu.mickelson.bg.ws.controller", excludeFilters={ @Filter(Configuration.class)} )
public class ComponentConfig {
	
	@Bean
	public TaskBO taskBO(){
		return new TaskBO();
	}
	
}
