package com.senac.forumAcademico.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	private static String[] PUBLIC_MATCHERS = {"/h2-console/**"};
	private static String[] ADMIN_MATCHERS = {"/perfis/**"};
	private static String[] TEACHER_MATCHERS = {"/provas","/avaliacoes/**","/perguntas/**"};
	private static String[] STUDENT_MATCHERS = {"/responda/**"};
	
	@Autowired
	private CurrentUserDetailsService userDetailsService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS).permitAll()
		
		// Libera a acesso as endpoints
		.antMatchers(ADMIN_MATCHERS).hasRole("ADMIN")
		.antMatchers(TEACHER_MATCHERS).hasAnyRole("TEACHER","ADMIN")
		.antMatchers(STUDENT_MATCHERS).hasAnyRole("STUDENT","ADMIN")
		
		.anyRequest().authenticated()
		
		.and().formLogin()
		.loginProcessingUrl("/signin")
		.loginPage("/login").permitAll()
		.usernameParameter("txtUsername")
		.passwordParameter("txtPassword")
//		.permitAll()
		
		.defaultSuccessUrl("/dashboard", true)
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		http.headers().frameOptions().sameOrigin();
	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/js/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	 
	
	
	
}
