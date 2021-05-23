package com.example.springapi.bootstrap;

import com.example.springapi.domain.Category;
import com.example.springapi.domain.Customer;
import com.example.springapi.repository.CategoryRepository;
import com.example.springapi.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();

        System.out.println(categoryRepository.count());
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dired = new Category();
        dired.setName("Dired");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category nuts = new Category();
        nuts.setName("Nuts");


        categoryRepository.save(fruits);
        categoryRepository.save(dired);
        categoryRepository.save(fresh);
        categoryRepository.save(nuts);

    }

    private void loadCustomers() {
        Customer customer1 = new Customer(1L, "david", "da");
        Customer customer2 = new Customer(2L, "hazem", "davood");
        Customer customer3 = new Customer(3L, "boulder", "dawoud");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
    }
}
