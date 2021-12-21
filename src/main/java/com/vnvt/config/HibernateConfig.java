/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author 18510
 */
@Configuration
@PropertySource("classpath:database.properties")
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean b = new LocalSessionFactoryBean();

        b.setPackagesToScan("com.vnvt.pojo");
        b.setDataSource(dataSource());
        b.setHibernateProperties(hibernateProperties());

        return b;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource d = new DriverManagerDataSource();
        d.setDriverClassName(this.env.getProperty("hibernate.connection.driverClass"));
        d.setUrl(this.env.getProperty("hibernate.connection.url"));
        d.setUsername(this.env.getProperty("hibernate.connection.username"));
        d.setPassword(this.env.getProperty("hibernate.connection.password"));

        return d;
    }

    public Properties hibernateProperties() {
        Properties props = new Properties();
        props.put(AvailableSettings.DIALECT, this.env.getProperty("hibernate.dialect"));
        props.put(AvailableSettings.SHOW_SQL, this.env.getProperty("hibernate.showSql"));

        return props;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager h = new HibernateTransactionManager();

        h.setSessionFactory(this.getSessionFactory().getObject());

        return h;
    }
}
