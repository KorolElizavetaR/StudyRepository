package koroler.spring.SpringMVCApp.config;


import java.util.Objects;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@ComponentScan ("koroler.spring.SpringMVCApp")
@PropertySource ("classpath:hibernate.properties")
@EnableTransactionManagement
@EnableWebMvc
@EnableJpaRepositories("koroler.spring.SpringMVCApp.repos")
public class ConfigClass implements WebMvcConfigurer {
	private final ApplicationContext context;
	private final Environment environment;
	
	@Autowired
	public ConfigClass (ApplicationContext context, Environment environment)
	{
		this.context = context;
		this.environment = environment;
	}
	
	@Bean
	public SpringResourceTemplateResolver templateResolver()
	{
		SpringResourceTemplateResolver template = new SpringResourceTemplateResolver();
		template.setApplicationContext(context);
		template.setPrefix("/WEB-INF/views/");
		template.setSuffix(".html");
		template.setCharacterEncoding("UTF-8");
		return template;
	}
	
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter()
	{
		return new HiddenHttpMethodFilter();
	}
	
	@Bean
	public SpringTemplateEngine templateEngine()
	{
		SpringTemplateEngine template = new SpringTemplateEngine();
		template.setTemplateResolver(templateResolver());
		template.setEnableSpringELCompiler(true);
		return template;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry reg)
	{
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		reg.viewResolver(resolver);
	}

	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource datasrc = new DriverManagerDataSource();
		datasrc.setDriverClassName(Objects.requireNonNull(environment.getProperty("hibernate.connection.driver_class")));
		datasrc.setUrl(Objects.requireNonNull(environment.getProperty("hibernate.connection.url")));
		datasrc.setUsername(Objects.requireNonNull(environment.getProperty("hibernate.connection.username")));
		datasrc.setPassword(Objects.requireNonNull(environment.getProperty("hibernate.connection.password")));
		return datasrc;
	}
	
	private Properties hibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", Objects.requireNonNull(environment.getProperty("hibernate.show_sql")));
		return properties;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager()
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() 
	{
		final LocalContainerEntityManagerFactoryBean entManager = new LocalContainerEntityManagerFactoryBean();
		entManager.setDataSource(dataSource());
		entManager.setPackagesToScan("koroler.spring.SpringMVCApp.models");
		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entManager.setJpaVendorAdapter(vendorAdapter);
		entManager.setJpaProperties(hibernateProperties());
		return entManager;
	}
}
