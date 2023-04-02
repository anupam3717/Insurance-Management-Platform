package com.example.InsuranceManagementPlatform.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Client {
    @Id
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String contactInformation;
}
