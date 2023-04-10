package com.example.InsuranceManagementPlatform.exceptions;

public final class ErrorCodes {

    private ErrorCodes() {
    }

    public static final String INTERNAL_SERVER_ERROR = "E1-2000";

    public static final String MANDATORY_PARAMETER_MISSING = "E1-6000";
    public static final String AUTHENTICATION_INVALID_DATA = "E1-2001";

    public static final String AUTHORIZATION_INVALID = "E1-2022";
}
