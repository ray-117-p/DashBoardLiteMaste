package per.tec.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Bean
	public BCryptPasswordEncoder bCryptPassword() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @InitBinder public void allowEmptyDateBinding(WebDataBinder binder) { // tell
	 * spring to set empty values as null instead of empty string.
	 * binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	 * SimpleDateFormat simpleDateFormat = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); simpleDateFormat.setLenient(false);
	 * // simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-6"));
	 * binder.registerCustomEditor(Date.class, new
	 * CustomDateEditor(simpleDateFormat, true)); }
	 */

}
