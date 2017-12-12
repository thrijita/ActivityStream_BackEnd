package com.stackroute.activitystream.ActivityStreamBackend.Configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

@EnableTransactionManagement
@ComponentScan(basePackages="com.stackroute.activitystream.ActivityStreamBackend")
public class DataBaseConfiguration {
	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	 
	    return dataSource;
	}	
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilderObject = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilderObject.scanPackages("com.stackroute.activitystream.ActivityStreamBackend.Model");
		sessionBuilderObject.setProperty("hibernate.show_sql", "true");
		sessionBuilderObject.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		sessionBuilderObject.setProperty("hibernate.hbm2ddl.auto", "update");
		sessionBuilderObject.setProperty("hibernate.lazy", "false");
		return sessionBuilderObject.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManagerObject=new HibernateTransactionManager(sessionFactory);
		return transactionManagerObject;
	}

}
