package org.serratec.backend.tireshop.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class JwtWebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetail userDetail;
	
//	@Autowired
//	private JwtRequestsFilter jwtRequestsFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetail);
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder codificarSenha() {	
	 return NoOpPasswordEncoder.getInstance();
	}
}
