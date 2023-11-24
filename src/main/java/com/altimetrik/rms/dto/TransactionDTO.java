package com.altimetrik.rms.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransactionDTO {
    private int beneficiaryAccountNumber;
    private int remitterAccountNumber;
    private int transactionAmount;
    private String transactionStatus;
    private Timestamp transactionDate;
}
