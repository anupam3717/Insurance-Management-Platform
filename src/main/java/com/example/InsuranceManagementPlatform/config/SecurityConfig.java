package com.example.InsuranceManagementPlatform.config;

import com.example.InsuranceManagementPlatform.exceptions.AccesControlErrorHandler;
import com.example.InsuranceManagementPlatform.exceptions.AuthErrorHandeler;
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
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private AccesControlErrorHandler accessDenied;
    @Autowired
    private AuthErrorHandeler authenticationEntryPoint;
    @Autowired
    private JwtFilter jwtFilter;
    @Autowired
    private UserInfoUserDetailsService userInfoUserDetailsService;
    String[] unsecuredPaths = {"/api/signup", "/api/login"};
    String[] adminPaths={"/api/client/delete","/api/claim/delete","/api/insurance/delete"};
    String[] editorPaths={"/api/client/update","/api/claim/update","/api/insurance/update"};
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
                .requestMatchers(adminPaths).hasRole("admin")
                .requestMatchers(editorPaths).hasAnyRole("editor","admin")
                .anyRequest().authenticated();


        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDenied);
        return http.build();
    }
}
