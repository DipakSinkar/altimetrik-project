package com.altimetrik.rms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Beneficiary {
    @Id
    private int beneficiaryAccountNumber;
    private String beneficiaryName;
    private String emailId;
    private String bankName;
    private float currentBalance;
    private String ifscCode;


}
