package eu.mickelson.bg.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @EnableWebMVC, this is the same as <mvc:annotation-driven/>
 * @author vaio
 *
 */
@Configuration
@EnableWebMvc
public class WebConfig {

}  // end public class WebConfig