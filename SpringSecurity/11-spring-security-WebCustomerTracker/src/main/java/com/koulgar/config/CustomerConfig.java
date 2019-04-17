package com.koulgar.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.koulgar")
@PropertySource({"classpath:persistence-mysql.properties","classpath:security-persistence-mysql.properties"})
public class CustomerConfig implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    private Logger logger = Logger.getLogger(getClass().getName());

    //Bean for viewResolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //Bean for datasource
    @Bean
    public DataSource dataSource(){
        //connection pool creation
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //jdbc driver setting
        try {
            dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException exc){
            throw new RuntimeException(exc);
        }
        //test print for connection check (to see if it can read props file)
        logger.info("======>>>>jdbc.url= "+environment.getProperty("jdbc.url"));
        logger.info("======>>>>jdbc.user= "+environment.getProperty("jdbc.user"));
        //database connection props
        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        dataSource.setUser(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        //connection pool props
        dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
        return dataSource;
    }

    //Hibernate properties setup
    private Properties getHibernateProperties() {
        // set hibernate properties
        Properties props = new Properties();
        props.setProperty("hibernate.dialect",environment.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
        return props;
    }

    //Hibernate Session Factory based on datasource and config files
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        // create session factories
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        // set the properties
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    // define a bean for security data source
    @Bean
    public DataSource securityDataSource() {

        // create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        // set the jdbc driver class
        try {securityDataSource.setDriverClass(environment.getProperty("security.jdbc.driver"));
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }

        // log the connection props
        logger.info(">>> security.jdbc.url=" + environment.getProperty("security.jdbc.url"));
        logger.info(">>> security.jdbc.user=" + environment.getProperty("security.jdbc.user"));

        // set database connection props
        securityDataSource.setJdbcUrl(environment.getProperty("security.jdbc.url"));
        securityDataSource.setUser(environment.getProperty("security.jdbc.user"));
        securityDataSource.setPassword(environment.getProperty("security.jdbc.password"));

        // set connection pool props
        securityDataSource.setInitialPoolSize(getIntProperty("security.connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("security.connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("security.connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("security.connection.pool.maxIdleTime"));
        return securityDataSource;
    }

    //Hibernate transaction manager
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        // setup transaction manager based on session factory
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    //css,image,js resource handler
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    private int getIntProperty(String propName) {

        String propVal = environment.getProperty(propName);

        // now convert to int
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }

}
