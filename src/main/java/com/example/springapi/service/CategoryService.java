package com.example.springapi.service;

import com.example.springapi.domain.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    Category getCategoryByName(String name);
}
