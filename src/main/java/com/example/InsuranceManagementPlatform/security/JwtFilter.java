package com.example.InsuranceManagementPlatform.security;

import com.example.InsuranceManagementPlatform.config.UserInfoUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    private final UserInfoUserDetailsService userInfo;

    @Autowired
    public JwtFilter(JwtProvider jwtProvider, UserInfoUserDetailsService userInfo) {
        this.jwtProvider = jwtProvider;
        this.userInfo = userInfo;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token=getTokenFromHeader(request);
        if(token!=null && jwtProvider.isTokenValid(token)){
            String userName=jwtProvider.getUserNameFromToken(token);
            UserDetails user=userInfo.loadUserByUsername(userName);
            var authenticationObject = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
            authenticationObject.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationObject);
        }
        filterChain.doFilter(request,response);
    }

    private String getTokenFromHeader(HttpServletRequest request) {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(header!=null && header.startsWith("Bearer ")){
            return header.substring(7);
        }

        return null;
    }
}
