package com.example.Library.dao;

import com.example.Library.models.Book;
import com.example.Library.models.Categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryDAO {

    private List<Book> books;
    private JdbcTemplate jdbcTemplate;
    private Categories categories;

    @Autowired
    public LibraryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBook(Book book) {

        String sql = "INSERT INTO books (book_name, author, description, id_category) VALUES(?,?,?,?)";

        jdbcTemplate.update(sql, book.getBookName(), book.getAuthor(), book.getDescription(), book.getCategory().getId());
    }

    public List<Book> getAllBooks() {

        String sql = "SELECT books.id, books.book_name , books.author , books.description, books.id_category, category.category_name  FROM books JOIN category ON category.id = books.id_category";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    public List<Book> getBooksByName(String name) {

        String sql = "SELECT books.id, books.book_name , books.author , books.description, books.id_category, category.category_name FROM books JOIN category ON category.id = books.id_category WHERE books.book_name LIKE ?";

        return jdbcTemplate.query(sql, new String[]{"%" + name + "%"}, new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getBookById(int id) {

        String sql = "SELECT books.id, books.book_name , books.author , books.description, books.id_category, category.category_name  FROM books JOIN category ON category.id = books.id_category WHERE books.id = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void deleteBook(int id) {

        String sql = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Categories> getAllCategories() {

        String sql = "SELECT * FROM category";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Categories.class));
    }

    public void addCategory(String categoryName) {

        String sql = "INSERT INTO category (category_name)  VALUES(?)";

        jdbcTemplate.update(sql, categoryName);
    }

    public void updateBook(int id, Book book) {

        String sql = "UPDATE books set book_name = ?, author = ?, description = ?, id_category = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getBookName(), book.getAuthor(), book.getDescription(), book.getCategory().getId(), id);
    }
}
