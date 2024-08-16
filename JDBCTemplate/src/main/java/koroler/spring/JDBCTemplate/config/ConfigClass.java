package koroler.spring.JDBCTemplate.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@ComponentScan ("koroler.spring.PreparedStatementSQL")
@PropertySource ("classpath:application.properties")
@EnableWebMvc
public class ConfigClass implements WebMvcConfigurer {
	@Value ("${spring.datasource.driver-class-name}") private String drivers;
	@Value ("${spring.datasource.username}") private String username;
	@Value ("${spring.datasource.password}") private String password;
	@Value ("${spring.datasource.url}") private String URL;
	private final ApplicationContext context;
	
	@Autowired
	public ConfigClass (ApplicationContext context)
	{
		this.context = context;
	}
	
	@Bean
	public SpringResourceTemplateResolver templateResolver()
	{
		SpringResourceTemplateResolver template = new SpringResourceTemplateResolver();
		template.setApplicationContext(context);
		template.setPrefix("/WEB-INF/views/"); // "/WEB-INF/classes/templates/" just in case
		template.setSuffix(".html");
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
		datasrc.setDriverClassName(drivers);
		datasrc.setUrl(URL);
		datasrc.setUsername(username);
		datasrc.setPassword(password);
		return datasrc;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		return new JdbcTemplate(dataSource());
	}
}
