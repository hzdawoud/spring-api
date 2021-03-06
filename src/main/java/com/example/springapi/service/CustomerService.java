package com.example.springapi.service;

import com.example.springapi.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer createNewCustomer(Customer customer);
    Customer saveCustomerById(Long id, Customer customer);
    Customer patchCustomer(Long id, Customer customer);
}
