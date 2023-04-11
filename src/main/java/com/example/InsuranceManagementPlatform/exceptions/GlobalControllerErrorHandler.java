package com.example.InsuranceManagementPlatform.exceptions;

import com.example.InsuranceManagementPlatform.dto.ApiError;
import com.example.InsuranceManagementPlatform.properties.AppProperties;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.example.InsuranceManagementPlatform.exceptions.ErrorCodes.*;

@ControllerAdvice
public class GlobalControllerErrorHandler {
    @Autowired
    private AppProperties properties;

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> handleThrowable(HttpServletRequest request, Throwable th) {
        ApiError apiError = ApiError.builder()
                .code(INTERNAL_SERVER_ERROR)
                .message(th.getMessage())
                .serviceName(properties.getServiceName())
                .serviceVersion(properties.getServiceVersion())
                .build();

        return ResponseEntity.status(500).body(apiError);
    }
    @ExceptionHandler(StatusCodeMyException.class)
    public ResponseEntity<?> handleStatusCodeMyException(HttpServletRequest request, StatusCodeMyException ex) {
        ApiError apiError = ApiError.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .serviceName(properties.getServiceName())
                .serviceVersion(properties.getServiceVersion())
                .build();

        return ResponseEntity.status(ex.getStatusCode()).body(apiError);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentialsException(HttpServletRequest request, BadCredentialsException ex) {
        ApiError apiError = ApiError.builder()
                .code("E1-2001")
                .message("Invalid username or password")
                .serviceName(properties.getServiceName())
                .serviceVersion(properties.getServiceVersion())
                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
    }
}
