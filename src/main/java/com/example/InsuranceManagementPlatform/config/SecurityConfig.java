package com.example.InsuranceManagementPlatform.config;

import com.example.InsuranceManagementPlatform.exceptions.AccesControlErrorHandler;
import com.example.InsuranceManagementPlatform.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private AccesControlErrorHandler accessDenied;
    @Autowired
    private JwtFilter jwtFilter;
    @Autowired
    private UserInfoUserDetailsService userInfoUserDetailsService;
    String[] unsecuredPaths = {"/api/signup", "/api/login", "/api/client/create","/api/client/get/{id}","/api/insurance/create","/api/claim/create"};
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean
    public DaoAuthenticationProvider loginProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userInfoUserDetailsService);
        return provider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authenticationProvider(loginProvider()).addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
        http.authorizeHttpRequests()
                .requestMatchers(unsecuredPaths).permitAll()
                .requestMatchers("/api/hi").hasRole("admin")
                .anyRequest().authenticated();

        http.exceptionHandling()
                .accessDeniedHandler(accessDenied);
        return http.build();
    }
}
