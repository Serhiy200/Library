package com.example.Library.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Categories {

    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 50, message = "Name should be between 3 and 50 characters")
    private String categoryName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Categories() {
    }

    public Categories(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
}
