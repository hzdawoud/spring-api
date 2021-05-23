package com.example.springapi.domain;

import java.util.List;

public class CustomerList {
    List<Customer> customers;

    public CustomerList(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
