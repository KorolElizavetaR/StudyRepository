package koroler.spring.project1.config;

import java.util.EnumSet;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class DispatcherServletConf extends AbstractAnnotationConfigDispatcherServletInitializer{

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
	
	 private void registerHiddenFieldFilter(ServletContext aContext) {
	        aContext.addFilter("hiddenHttpMethodFilter",
	                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
	    }
	
	 @Override
	    public void onStartup(ServletContext aServletContext) throws ServletException {
	        super.onStartup(aServletContext);
	        registerCharacterEncodingFilter(aServletContext);
	        registerHiddenFieldFilter(aServletContext);
	    }
	 
	 private void registerCharacterEncodingFilter(ServletContext aContext) {
	        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);

	        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	        characterEncodingFilter.setEncoding("UTF-8");
	        characterEncodingFilter.setForceEncoding(true);

	        FilterRegistration.Dynamic characterEncoding = aContext.addFilter("characterEncoding", characterEncodingFilter);
	        characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
	    }

}
