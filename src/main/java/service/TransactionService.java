package service;

import entities.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {

    public void deposit(BigDecimal value, Long userId);

    public void withdraw(BigDecimal value, Long userId);

    List<Transaction> findAll();

    Transaction findById(Long id);

    Transaction findByUserId(Long userId);
}
