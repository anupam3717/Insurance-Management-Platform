package com.example.InsuranceManagementPlatform.exceptions;

import com.example.InsuranceManagementPlatform.dto.ApiError;
import com.example.InsuranceManagementPlatform.properties.AppProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class AccesControlErrorHandler implements AccessDeniedHandler {
    private ObjectMapper objectMapper;
    private  AppProperties properties;
    @Autowired
    public AccesControlErrorHandler(ObjectMapper objectMapper, AppProperties properties) {
        this.objectMapper = objectMapper;
        this.properties = properties;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ApiError apiError = ApiError.builder()
                .code("AUTHORIZATION_INVALID")
                .message("Not authorized for this resource")
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


