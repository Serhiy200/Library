package com.example.Library.controllers;

import com.example.Library.dao.BookMapper;
import com.example.Library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reader")
public class ReaderController {

       private BookMapper booksMapper;

    @Autowired
    public ReaderController(BookMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @GetMapping("/")
    public String getBooks(Model model, Book book) {

        //get list of book from dao
        model.addAttribute("categories", booksMapper.getAllCategories());
        model.addAttribute("books", booksMapper.findAll());

        return "book-list";
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable("id") int id, Model model) {

        model.addAttribute("book", booksMapper.findBookById(id));
        return "book-review";
    }

    @PostMapping("/book")
    public String findBookByName(@ModelAttribute("book") Book book, Model model) {

        List<Book> searchBooks = booksMapper.searchBook(book);
        model.addAttribute("categories", booksMapper.getAllCategories());
        if (searchBooks.size() == 0) {
            model.addAttribute("errorMessage", "We can't find book with these parameters");
            return "book-list";
        }
        model.addAttribute("books", searchBooks);
        return "book-list";
    }
}
