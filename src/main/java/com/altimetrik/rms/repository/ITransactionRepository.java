package com.altimetrik.rms.repository;

import com.altimetrik.rms.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
}
