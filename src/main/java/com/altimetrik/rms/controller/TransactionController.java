package com.altimetrik.rms.controller;

import com.altimetrik.rms.entity.Transaction;
import com.altimetrik.rms.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    // Add other endpoints for fetching, updating, or deleting transactions
}
