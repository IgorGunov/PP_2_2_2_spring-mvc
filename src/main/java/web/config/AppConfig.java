package web.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import javax.persistence.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan("web")
public class AppConfig {

    private final Environment en;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    @Autowired
    public AppConfig(Environment en) {
        this.en = en;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        managerFactoryBean.setDataSource(getDataSource());
        managerFactoryBean.setPackagesToScan("web.model");
        managerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        managerFactoryBean.setJpaProperties(getProperties());
        return managerFactoryBean;
    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(en.getRequiredProperty("db.url"));
        ds.setDriverClassName(en.getRequiredProperty("db.driver"));
        ds.setUsername(en.getRequiredProperty("db.username"));
        ds.setPassword(en.getRequiredProperty("db.password"));
        return ds;
    }

    @Bean
    public Properties getProperties() {
        Properties props = new Properties();
        props.put("hibernate.show_sql", en.getProperty("hibernate.show_sql"));
        props.put("hibernate.hbm2ddl.auto", en.getProperty("hibernate.hbm2ddl.auto"));
        return props;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        JpaTransactionManager jpa = new JpaTransactionManager();
        jpa.setEntityManagerFactory(getEntityManagerFactory().getObject());
        return jpa;
    }
}