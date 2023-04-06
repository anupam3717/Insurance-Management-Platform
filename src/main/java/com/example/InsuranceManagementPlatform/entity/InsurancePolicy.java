package com.example.InsuranceManagementPlatform.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "insurance_policies")
public class InsurancePolicy {

    @Id
    private Long id;

    @Column(nullable = false)
    private String policyNumber;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Integer coverageAmount;

    @Column(nullable = false)
    private Integer premium;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonBackReference
    private Client client;

    @OneToMany(mappedBy = "insurancePolicy")
    @JsonManagedReference
    private List<Claim> claim;
}
