package com.example.InsuranceManagementPlatform.exceptions;

import lombok.Getter;

@Getter
public class StatusCodeMyException extends RuntimeException{
    private final int statusCode;
    private final String code;
    public StatusCodeMyException(String code,int statusCode, String message) {
        super(message);
        this.code = code;
       this.statusCode=statusCode;
    }

}
