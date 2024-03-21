package service;

import dao.CustomerRepository;
import dao.TransactionRepository;
import entities.Company;
import entities.Customer;
import entities.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private Transaction transaction;
    private CustomerRepository customerRepository;
    private Customer customer;
    private Company company;
    private EmailService emailService;

    @Transactional
    public void deposit(BigDecimal value, Long companyId) {
        customerRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        BigDecimal balance = company.getBalance();
        BigDecimal totalDeposit = value.subtract(transaction.getTransactionTax());
        balance = balance.add(totalDeposit);
        company.setBalance(balance);
        emailService.sendEmail(customer.getEmail(), "Confirmação de depósito", "Seu depósito no valor de: R$ " + value + " foi realizado com sucesso");
    }

    @Transactional
    public void withdraw(BigDecimal value, Long companyId) {
        customerRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        BigDecimal balance = company.getBalance();
        BigDecimal totalWithdraw = value.subtract(transaction.getTransactionTax());
        if (balance.compareTo(totalWithdraw) >= 0) {
        balance = balance.subtract(totalWithdraw);
        company.setBalance(balance);
            emailService.sendEmail(customer.getEmail(), "Confirmação de saque", "Seu saque no valor de: R$ " + value + " foi realizado com sucesso");
        }
        else {
            throw new RuntimeException("Valor Insuficiente");
        }
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findById(Long id) {
        Optional<Transaction> search = transactionRepository.findById(id);
        transaction = null;
        if (search.isPresent()){
            transaction = search.get();
        } else {
            throw new RuntimeException("Transação " + id+ " não encontrada");
        }
        return transaction;
    }

    @Override
    public Transaction findByUserId(Long customerId) {
        Optional<Transaction> search = transactionRepository.findById(customerId);
        transaction = null;
        if (search.isPresent()){
            transaction = search.get();
        } else {
            throw new RuntimeException("Cliente " + customerId+ " não encontrado");
        }
        return transaction;
    }
}

