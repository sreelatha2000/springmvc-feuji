package com.crnt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySources(value = { @PropertySource(value = "classpath:db.properties") })
public class HibernateConfig {

	@Autowired
	private Environment environment;

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("show_sql"));
		properties.put("hibernate.format_sql",
				environment.getRequiredProperty("format_sql"));
		properties.put("hibernate.hbm2ddl.auto",
				environment.getRequiredProperty("hbm2ddl.auto"));
		return properties;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("driver"));
		dataSource.setUrl(environment.getRequiredProperty("url"));
		dataSource.setUsername(environment.getRequiredProperty("username"));
		dataSource.setPassword(environment.getRequiredProperty("password"));
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.school.entity" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(
				sessionFactory().getObject());
		return hibernateTemplate;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

}

