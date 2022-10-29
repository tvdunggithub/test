package com.dungtran.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.dungtran.bookstore.filters.JWTTokenGeneratorFilter;
import com.dungtran.bookstore.filters.JWTTokenValidatorFilter;
import com.dungtran.bookstore.filters.UserInformationFilter;

@Configuration
public class SecurityConfig {
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	 @Bean
	 SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		 
		 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		 .and().csrf().ignoringAntMatchers("/register","/login","/gioHang/**","/diaChi/**","/donHang/**","/sach/**").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		 .and().addFilterAfter(new UserInformationFilter(), BasicAuthenticationFilter.class)
		 .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
         .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
         .authorizeHttpRequests()
                 .antMatchers("/gioHang/**","/diaChi/**","donHang/**").hasAnyRole("USER","SELLER")
                 .antMatchers("/sach/edit").hasRole("SELLER")
                 .antMatchers("/register","/sach").permitAll()
         .and().formLogin()
         .and().httpBasic();
		 
		return http.build();	 
	 }
}
