package eu.mickelson.bg.ws.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
//@EnableTransactionManagement
public class DatabaseConfig {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Bean
	public DataSource dataSource() throws IllegalArgumentException, NamingException{
		logger.debug("start");
		JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
		jndi.setJndiName("jdbc/youconnect");
		// true prepends the jndiname with java:comp/env 
		jndi.setResourceRef(true);
		jndi.setExpectedType(DataSource.class);
		// This MUST be set
		jndi.afterPropertiesSet();
		DataSource ds = (DataSource)jndi.getObject();
		logger.debug("end");
		return ds;
	}  // end public function dataSource

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws IllegalArgumentException, NamingException{
		logger.debug("start");
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(new String[] { "com.socialpainkiller.entities" });
		factory.setPersistenceUnitName("JPADB");

        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        factory.setJpaVendorAdapter(va);
 
        Properties ps = new Properties();
        ps.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        ps.put("hibernate.format_sql", "true");
        factory.setJpaProperties(ps);
 
        factory.afterPropertiesSet();

		logger.debug("end");
		return factory;
	}
	
	@Bean 
	public PlatformTransactionManager transactionManager() throws IllegalArgumentException, NamingException{
		logger.debug("start");
		//JpaTransactionManager manager = new JpaTransactionManager ();
		//manager.setEntityManagerFactory(entityManagerFactory().getObject());
		JtaTransactionManager manager = new JtaTransactionManager();
		logger.debug("end");
		return manager;
	} 

	@Bean
	public SharedEntityManagerBean SharedEntityManagerBean() throws IllegalArgumentException, NamingException{
		logger.debug("start");
		SharedEntityManagerBean entityManager = new SharedEntityManagerBean();
		entityManager.setEntityManagerFactory(entityManagerFactory().getObject());
		logger.debug("end");
		return entityManager;
	}
	
	/*	
*/
	
}  // end public class DatabaseConfig