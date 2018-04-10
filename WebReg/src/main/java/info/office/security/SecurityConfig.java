package info.office.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.toString());
		return encoder;
	}
	
	@Bean
	public UserDetailsManager userDetailsManager() {
	JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
	jdbcUserDetailsManager.setDataSource(securityDataSource);
	return jdbcUserDetailsManager;
	}

	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(securityDataSource).passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, authority from authorities where username=?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/loggedUser").hasRole("USER").antMatchers("/admin/**").hasRole("ADMIN")
				.and().formLogin().loginPage("/login").loginProcessingUrl("/authenticateTheUser").permitAll()
				.defaultSuccessUrl("/loggedUser/", true).and().logout().permitAll().and().exceptionHandling()
				.accessDeniedPage("/access-denied");
		
		
	}

}
