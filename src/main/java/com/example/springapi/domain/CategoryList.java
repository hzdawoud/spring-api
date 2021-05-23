package com.example.springapi.domain;

import java.util.List;

public class CategoryList {
    List<Category> categories;

    public CategoryList(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
