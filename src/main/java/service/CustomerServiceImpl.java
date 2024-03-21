package service;

import dao.CustomerRepository;
import entities.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> search = customerRepository.findById(id);
        Customer customer = null;
        if (search.isPresent()) {
            customer = search.get();
        } else {
            throw new RuntimeException("Transação " + id + " não encontrada");
        }
        return customer;
    }

}
