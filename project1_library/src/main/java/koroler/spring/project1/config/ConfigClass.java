package koroler.spring.project1.config;

import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@ComponentScan ("koroler.spring.project1")
@PropertySource ("classpath:database.properties")
@EnableWebMvc
public class ConfigClass implements WebMvcConfigurer{
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
		template.setPrefix("/WEB-INF/views/"); // "/WEB-INF/classes/templates/" just in case
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
		 resolver.setCharacterEncoding("UTF-8");
		reg.viewResolver(resolver);
	}

	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource datasrc = new DriverManagerDataSource();
		datasrc.setDriverClassName(Objects.requireNonNull(environment.getProperty("spring.datasource.driver-class-name")));
		datasrc.setUrl(Objects.requireNonNull(environment.getProperty("spring.datasource.url")));
		datasrc.setUsername(Objects.requireNonNull(environment.getProperty("spring.datasource.username")));
		datasrc.setPassword(Objects.requireNonNull(environment.getProperty("spring.datasource.password")));
		return datasrc;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		return new JdbcTemplate(dataSource());
	}
}
