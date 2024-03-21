package service;

import entities.Customer;
import entities.Transaction;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);
}
