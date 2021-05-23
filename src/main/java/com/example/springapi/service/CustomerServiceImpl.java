package com.example.springapi.service;

import com.example.springapi.domain.Customer;
import com.example.springapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .peek(customer -> customer.setCustomerUrl("/api/customer/" + customer.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        savedCustomer.setCustomerUrl("/api/customer/" + savedCustomer.getId());
        return savedCustomer;
    }

    @Override
    public Customer saveCustomerById(Long id, Customer customer) {
        customer.setId(id);
        Customer updatedCustomer = customerRepository.save(customer);
        updatedCustomer.setCustomerUrl("/api/customer/" + updatedCustomer.getId());
        return updatedCustomer;
    }

    @Override
    public Customer patchCustomer(Long id, Customer customer) {
        return customerRepository.findById(id).map(mappedCustomer -> {
            if (customer.getFirstname() != null) {
                mappedCustomer.setFirstname(customer.getFirstname());
            }

            if (customer.getLastname() != null) {
                mappedCustomer.setLastname(customer.getLastname());
            }

            return customerRepository.save(mappedCustomer);
        }).orElseThrow(RuntimeException::new);
    }
}
