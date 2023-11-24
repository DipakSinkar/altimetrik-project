package com.altimetrik.rms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class FundTransfer {
    @Id
    private int transactionId;
    private int beneficiaryAccountNumber;
    private int remitterAccountNumber;
    private float transactionAmount;
    private int transactionStatus;
    private Date transactionDate;

}
