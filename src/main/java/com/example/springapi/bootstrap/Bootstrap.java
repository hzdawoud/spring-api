package com.example.springapi.bootstrap;

import com.example.springapi.domain.Category;
import com.example.springapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dired = new Category();
        fruits.setName("Dired");

        Category fresh = new Category();
        fruits.setName("Fresh");

        Category nuts = new Category();
        fruits.setName("Nuts");


        categoryRepository.save(fruits);
        categoryRepository.save(dired);
        categoryRepository.save(fresh);
        categoryRepository.save(nuts);

        System.out.println(categoryRepository.count());
    }
}
