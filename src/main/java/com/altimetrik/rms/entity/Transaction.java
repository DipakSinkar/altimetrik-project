package com.altimetrik.rms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction_details")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @ManyToOne
    @JoinColumn(name = "beneficiary_account_number")
    private Beneficiary beneficiary;

    @ManyToOne
    @JoinColumn(name = "remitter_account_number")
    private Remitter remitter;

    private String transactionAmount;
    private String transactionStatus;
    private Timestamp transactionDate;
}
