package per.tec.app.config;

import java.io.File;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PATHS_TO_FILES implements WebMvcConfigurer {

	public final static String DOCS_PATH = "/APP" + File.separator + "DOCUMENTOS";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/DOCUMENTOS/**").addResourceLocations("file:/APP/DOCUMENTOS/");
	}

}
