package per.tec.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import per.tec.app.schema.core.implement.UsuarioDetailServiceImpl;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioDetailServiceImpl userDetailService;

	@Autowired
	private UsuarioAuthenticationSuccessHandler successHandler;

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder build) throws Exception {

		build.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin().and().sessionManagement().invalidSessionUrl("/login")
				.sessionFixation().newSession().sessionFixation().migrateSession().and().authorizeRequests()
				.antMatchers("/css/**", "/fonts/**", "/img/**", "/js/**", "/api.dir/**").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").permitAll().successHandler(successHandler)
				.failureUrl("/login?error=true").usernameParameter("username").passwordParameter("password").and()
				.csrf().disable();
		/* http.csrf().disable(); */

	}

}
