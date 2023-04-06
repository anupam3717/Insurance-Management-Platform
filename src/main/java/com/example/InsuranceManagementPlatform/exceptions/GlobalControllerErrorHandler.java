package com.example.InsuranceManagementPlatform.exceptions;

import com.example.InsuranceManagementPlatform.apiErrorDto.ApiError;
import com.example.InsuranceManagementPlatform.properties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.example.InsuranceManagementPlatform.exceptions.ErrorCodes.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalControllerErrorHandler {
    @Autowired
    private AppProperties properties;
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> handleThrowable(Throwable th) {
        ApiError apiError = ApiError.builder()
                .code(INTERNAL_SERVER_ERROR)
                .message(properties.getGenericErrorMessage())
                .serviceName(properties.getServiceName())
                .serviceVersion(properties.getServiceVersion())
                .build();

        return ResponseEntity.status(500).body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return handleThrowable(ex);
    }

    @ExceptionHandler(StatusCodeMyException.class)
    public ResponseEntity<?> handleStatusCodeMyException(StatusCodeMyException ex){
        ApiError apiError = ApiError.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .serviceName(properties.getServiceName())
                .serviceVersion(properties.getServiceVersion())
                .build();

        return ResponseEntity.status(ex.getStatusCode()).body(apiError);
    }
}
