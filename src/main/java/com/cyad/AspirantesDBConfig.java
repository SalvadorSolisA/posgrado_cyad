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
 * Esta clase configura la conexion con la base de datos de aspirantes
 * @author Salvador Solis Atenco
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "aspirantesEntityManagerFactory", transactionManagerRef = "aspirantesTransactionManager", basePackages = { "com.cyad.aspirantes.repository"})
public class AspirantesDBConfig {
	
/**Esta clase configura los beans para manejar una de las bases de datos*/
	
	@Autowired
	private Environment env;
	
	/*Porpierties tomadas del archivo de configuracion*/
	@Bean(name = "aspirantesDataSource")
	public DataSource posgradoDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("aspirantes_cyad.datasource.url"));
		dataSource.setUsername(env.getProperty("aspirantes_cyad.datasource.username"));
		dataSource.setPassword(env.getProperty("aspirantes_cyad.datasource.password"));
		dataSource.setDriverClassName(env.getProperty("aspirantes_cyad.datasource.driver-class-name"));
		
		return dataSource;
	}
	
	/*Indica el paquete de clases de las entidades para esta bd*/
	@Bean(name = "aspirantesEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(posgradoDataSource());
		em.setPackagesToScan("com.cyad.aspirantes.entity");//paquete de entidades
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("aspirantes_cyad.jpa.hibernate.ddl-auto"));//esquema de comportamiento
		properties.put("hibernate.show-sql", env.getProperty("aspirantes_cyad.jpa.show-sql"));
		properties.put("hibernate.dialect", env.getProperty("aspirantes_cyad.jpa.database-platform"));//indica el dialecto
		
		em.setJpaPropertyMap(properties);
		
		return em;
	}
	
	/*Transaccioenes en el repositorio Jpa*/
	@Bean(name = "aspirantesTransactionManager")
	public PlatformTransactionManager posgradoTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
}
