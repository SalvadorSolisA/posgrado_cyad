package com.cyad;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * Esta clase configura la conexion con la base de datos de posgrado
 * @author Salvador Solis Atenco
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "posgradoEntityManagerFactory", transactionManagerRef = "posgradoTransactionManager", basePackages = { "com.cyad.posgrado.repository"})
public class PosgradoBDConfig {
	
	
	@Autowired
	private Environment env;
	
	/*Porpierties tomadas del archivo de configuracion*/
	@Bean(name = "posgradoDataSource")
	public DataSource posgradoDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("posgrado_cyad.datasource.url"));
		dataSource.setUsername(env.getProperty("posgrado_cyad.datasource.username"));
		dataSource.setPassword(env.getProperty("posgrado_cyad.datasource.password"));
		dataSource.setDriverClassName(env.getProperty("posgrado_cyad.datasource.driver-class-name"));
		
		return dataSource;
	}
	
	/*Indica el paquete de clases de las entidades para esta bd*/
	@Bean(name = "posgradoEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(posgradoDataSource());
		em.setPackagesToScan("com.cyad.posgrado.entity");//paquete de entidades
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("posgrado_cyad.jpa.hibernate.ddl-auto"));//esquema de comportamiento
		properties.put("hibernate.show-sql", env.getProperty("posgrado_cyad.jpa.show-sql"));
		properties.put("hibernate.dialect", env.getProperty("posgrado_cyad.jpa.database-platform"));//indica el dialecto
		
		em.setJpaPropertyMap(properties);
		
		return em;
	}
	
	/*Transaccioenes en el repositorio Jpa*/
	@Bean(name = "posgradoTransactionManager")
	public PlatformTransactionManager posgradoTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
}
