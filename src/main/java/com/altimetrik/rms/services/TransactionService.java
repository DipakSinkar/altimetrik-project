package com.altimetrik.rms.services;

import com.altimetrik.rms.entity.Beneficiary;
import com.altimetrik.rms.entity.Remitter;
import com.altimetrik.rms.entity.Transaction;
import com.altimetrik.rms.repository.IBeneficiaryRepository;
import com.altimetrik.rms.repository.IRemitterRepository;
import com.altimetrik.rms.repository.ITransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class TransactionService {
    private final ITransactionRepository iTransactionRepository;
    private final IBeneficiaryRepository iBeneficiaryRepository;
    private final IRemitterRepository iRemitterRepository;

    @Autowired
    public TransactionService(
            ITransactionRepository iTransactionRepository,
            IBeneficiaryRepository iBeneficiaryRepository,
            IRemitterRepository iRemitterRepository
    ) {
        this.iTransactionRepository = iTransactionRepository;
        this.iBeneficiaryRepository = iBeneficiaryRepository;
        this.iRemitterRepository = iRemitterRepository;
    }

    @Transactional
    public Transaction saveTransaction(Transaction transaction) {
        Beneficiary beneficiary = iBeneficiaryRepository.findById(transaction.getBeneficiary().getBeneficiaryAccountNumber()).orElse(null);
        Remitter remitter = iRemitterRepository.findById(transaction.getRemitter().getRemitterAccountNumber()).orElse(null);

        if (beneficiary != null && remitter != null) {
            float transactionAmount = Float.parseFloat(transaction.getTransactionAmount());
            float remitterBalance = remitter.getRemitterBalance();

            if (remitterBalance >= transactionAmount) {
                // Deduct the transaction amount from the remitter's balance
                remitter.setRemitterBalance(remitterBalance - transactionAmount);
                iRemitterRepository.save(remitter);

                // Update the beneficiary's balance
                float beneficiaryBalance = beneficiary.getCurrentBalance();
                beneficiary.setCurrentBalance(beneficiaryBalance + transactionAmount);
                iBeneficiaryRepository.save(beneficiary);

                // Set the Beneficiary and Remitter for the Transaction
                transaction.setBeneficiary(beneficiary);
                transaction.setRemitter(remitter);
                transaction.setTransactionStatus("Completed");
                transaction.setTransactionDate(Timestamp.from(Instant.now()));
                return iTransactionRepository.save(transaction);
            } else {
                System.out.println("Insufficient balance");
                // Handle insufficient balance error
            }
        } else {
            throw new EntityNotFoundException("Beneficiary or Remitter not found.");
        }
        return transaction;
    }

    // ...
}