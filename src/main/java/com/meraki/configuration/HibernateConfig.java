package com.meraki.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class HibernateConfig {

    private static final String DATABASE_DRIVER = "database.driver";
    private static final String DATABASE_URL = "database.url";
    private static final String DATABASE_USERNAME = "database.username";
    private static final String DATABASE_PASSWORD = "database.password";
    private static final String ENTITY_MANAGER_PACKAGES_TO_SCAN = "packagesToScan";


    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String HIBERNATE_ENABLE_LAZY_LOAD_NO_TRANS = "hibernate.enable_lazy_load_no_trans";

    //===================================== 光 HikariCP Config ========================================
    private static final String HIKARI_CONNECTION_TEST_QUERY = "hikari.ConnectionTestQuery";
    private static final String DATA_SOURCE_CACHE_PREP_STMTS = "dataSource.cachePrepStmts";
    private static final String POOL_NAME = "PoolName";
    private static final String DATA_SOURCE_PREP_STMT_CACHE_SIZE = "dataSource.prepStmtCacheSize";

    @Autowired
    private Environment environment;

    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan(environment.getRequiredProperty(ENTITY_MANAGER_PACKAGES_TO_SCAN));
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        try {
            localSessionFactoryBean.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return localSessionFactoryBean.getObject();
    }


//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(environment.getProperty("database.driver"));
//        dataSource.setUrl(environment.getProperty("database.url"));
//        dataSource.setUsername(environment.getProperty("database.root"));
//        dataSource.setPassword(environment.getProperty("database.password"));
//        return dataSource;
//    }


    //// Hikari CP 光 CONFIG
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(environment.getProperty(DATABASE_DRIVER));
        hikariConfig.setJdbcUrl(environment.getProperty(DATABASE_URL));
        hikariConfig.setUsername(environment.getProperty(DATABASE_USERNAME));
        hikariConfig.setPassword(environment.getProperty(DATABASE_PASSWORD));

        hikariConfig.setMaximumPoolSize(1000);
        hikariConfig.setConnectionTestQuery(environment.getProperty(HIKARI_CONNECTION_TEST_QUERY));
        hikariConfig.setPoolName(environment.getProperty(POOL_NAME));

        hikariConfig.addDataSourceProperty(DATA_SOURCE_CACHE_PREP_STMTS,environment.getRequiredProperty(DATA_SOURCE_CACHE_PREP_STMTS));
        hikariConfig.addDataSourceProperty(DATA_SOURCE_PREP_STMT_CACHE_SIZE,environment.getRequiredProperty(DATA_SOURCE_PREP_STMT_CACHE_SIZE));
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {

        return new HibernateTransactionManager(sessionFactory());
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(HIBERNATE_DIALECT, environment.getProperty(HIBERNATE_DIALECT));
        properties.put(HIBERNATE_HBM2DDL_AUTO, environment.getProperty(HIBERNATE_HBM2DDL_AUTO));
        properties.put(HIBERNATE_SHOW_SQL, environment.getProperty(HIBERNATE_SHOW_SQL));
        properties.put(HIBERNATE_ENABLE_LAZY_LOAD_NO_TRANS, environment.getRequiredProperty(HIBERNATE_ENABLE_LAZY_LOAD_NO_TRANS));
        properties.put("hibernate.hbm2ddl.import_files", "import.sql");
        return properties;
    }
}
