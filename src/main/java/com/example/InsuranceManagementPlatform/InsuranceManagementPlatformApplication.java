package com.example.InsuranceManagementPlatform;

import com.example.InsuranceManagementPlatform.properties.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(AppProperties.class)
@SpringBootApplication
public class InsuranceManagementPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceManagementPlatformApplication.class, args);
	}

}
