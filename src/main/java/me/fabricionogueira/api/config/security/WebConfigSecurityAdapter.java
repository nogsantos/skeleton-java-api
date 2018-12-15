package me.fabricionogueira.api.config.security;

import me.fabricionogueira.api.modules.user.User;
import me.fabricionogueira.api.modules.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.transaction.Transactional;

@Configuration
@EnableWebSecurity
public class WebConfigSecurityAdapter extends WebSecurityConfigurerAdapter {

	@Bean
	private static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManagerBean();
	}

	@Autowired
	@Transactional
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository)
		throws Exception {
		if (userRepository.count() == 0) {
			User user = new User();
			user.setEmail("admin@mail.com");
			user.setPassword(passwordEncoder().encode("admin"));
			user.setName("admin");
			user.setActive(true);

			userRepository.save(user);
		}

		builder.userDetailsService(userRepository::findOneByEmail).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
			"/v2/api-docs",
			"/configuration/ui",
			"/swagger-resources",
			"/configuration/security",
			"/swagger-ui.html",
			"/webjars/**");
	}

	@Bean
	@SuppressWarnings("unchecked")
	public FilterRegistrationBean corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);

		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return bean;
	}
}
