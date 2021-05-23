package com.example.springapi.controller;

import com.example.springapi.domain.Customer;
import com.example.springapi.domain.CustomerList;
import com.example.springapi.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerList> getAllCustomers() {
        return new ResponseEntity<CustomerList>(
                new CustomerList(customerService.getAllCustomers()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCategoryById(@PathVariable String id) {
        return new ResponseEntity<Customer>(customerService.getCustomerById(Long.valueOf(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.createNewCustomer(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> saveCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.saveCustomerById(id, customer), HttpStatus.OK);
    }
}
