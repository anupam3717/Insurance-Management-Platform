package com.example.InsuranceManagementPlatform.exceptions;

import com.example.InsuranceManagementPlatform.dto.ApiError;
import com.example.InsuranceManagementPlatform.properties.AppProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class AuthErrorHandeler implements AuthenticationEntryPoint {
    private ObjectMapper objectMapper;
    private AppProperties properties;
    @Autowired
    public AuthErrorHandeler(ObjectMapper objectMapper, AppProperties properties) {
        this.objectMapper = objectMapper;
        this.properties = properties;
    }
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ApiError apiError = ApiError.builder()
                .code(ErrorCodes.AUTHENTICATION_INVALID_DATA)
                .message("Authentication is required")
                .serviceName(properties.getServiceName())
                .serviceVersion(properties.getServiceVersion())
                .build();

        String responseBody = objectMapper.writeValueAsString(apiError);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(responseBody);
    }
}
