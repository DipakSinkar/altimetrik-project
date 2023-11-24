package com.altimetrik.rms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Remitter {

    private String name;
    @Getter
    @Id
    @NotNull
    private int remitterAccountNumber;

    private String remitterEmail;
    private String remitterPassword;
    private float remitterBalance;
    private int accountStatus;
    private String ifscCode;
}
