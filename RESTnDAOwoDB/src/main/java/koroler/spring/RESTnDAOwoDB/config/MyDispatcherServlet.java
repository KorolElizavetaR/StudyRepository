package  koroler.spring.RESTnDAOwoDB.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class MyDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer{
	    
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ConfigClass.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
