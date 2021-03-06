package com.example.Library.models;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty(message = "Should not be empty")
    private String bookName;

    @NotEmpty(message = "Should not be empty")
    private String author;

    @NotEmpty(message = "Should not be empty")
    private String description;

    private Categories category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }


    public Book(int id, String bookName, String author, String description, Categories category) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.category = category;
    }

//    public Book(int id, String bookName, String author, String description, int idCategory, String categoryName) {
//        this.id = id;
//        this.bookName = bookName;
//        this.author = author;
//        this.description = description;
//        this.idCategory = idCategory;
//        this.categoryName = categoryName;
//    }

    public Book() {
    }

}
