package com.example.userRegistration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.userRegistration.constant.Api;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http
			.cors((cors)->cors.disable())
			.csrf(csrf->csrf.disable())
		.authorizeHttpRequests()
		.requestMatchers(AntPathRequestMatcher.antMatcher("/auth/**")).permitAll();
//		.and().authorizeHttpRequests().requestMatchers(AntPathRequestMatcher.antMatcher("/staff/*")).authenticated();
		return http.build();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
//	 @Bean
//     public CorsConfigurationSource corsConfigurationSource() {
//             CorsConfiguration configuration = new CorsConfiguration();
//             configuration.setAllowedHeaders(Api.HEADERS);
//             configuration.setAllowCredentials(true);
//             configuration.setAllowedMethods(Api.METHODS);
//             configuration.setAllowedOrigins(Api.ORIGINS);
//             UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//             source.registerCorsConfiguration("/**", configuration);
//             return source;
//     }
	

}
