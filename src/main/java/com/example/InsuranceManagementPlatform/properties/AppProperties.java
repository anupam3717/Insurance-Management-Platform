package com.example.InsuranceManagementPlatform.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Getter
@Setter
@ConfigurationProperties("com.example.insurance-management-platform")
public class AppProperties {
    private String serviceName;

    private String serviceVersion;

    private String genericErrorMessage;
}
