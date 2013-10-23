package eu.mickelson.bg.ws.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;

/**
 *  @ComponentScan(basePackages = {“eu.mickelson.bg.ws.controller”}), this is the same as 
 *  <context:component-scan base-package=”eu.mickelson.bg.ws.controller”/>
 *  
 * @author vaio
 *
 */
@Configuration
@ComponentScan(basePackages="eu.mickelson.bg.ws.controller", excludeFilters={ @Filter(Configuration.class)} )
public class ComponentConfig {/* Just annotations for now */}
