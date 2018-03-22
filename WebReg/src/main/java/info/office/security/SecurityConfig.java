package info.office.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> authenticationManagerBuilderInMemoryUserDetailsManagerConfigurer = auth
				.inMemoryAuthentication();

		// UserBuilder users = User.withDefaultPasswordEncoder();

		authenticationManagerBuilderInMemoryUserDetailsManagerConfigurer.withUser("andrzej").password("andrzej")
				.roles("USER", "ADMIN");

		authenticationManagerBuilderInMemoryUserDetailsManagerConfigurer.withUser("user").password("user")
				.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/loggedUser").hasRole("USER").antMatchers("/admin/**").hasRole("ADMIN")
				.and().formLogin().loginPage("/login").loginProcessingUrl("/authenticateTheUser").permitAll()
				.defaultSuccessUrl("/loggedUser", true).and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
	}

}
