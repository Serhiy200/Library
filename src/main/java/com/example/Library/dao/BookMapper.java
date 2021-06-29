package com.example.Library.dao;

import com.example.Library.models.Book;
import com.example.Library.models.Categories;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    //    @Select("SELECT books.id, books.book_name , books.author , books.description, books.id_category, category.category_name FROM books JOIN category ON category.id = books.id_category")
    List<Book> findAll();

    Book findBookById(int id);
//    List<Book> selectAllBooks();

    List<Categories> getAllCategories();

    void addCategory(String categoryName);

    void addBook(Book book);

    void deleteBook(int id);

    void updateBook(Book book);
}
