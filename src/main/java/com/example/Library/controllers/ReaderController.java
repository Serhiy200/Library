package com.example.Library.controllers;

import com.example.Library.dao.BookMapper;
import com.example.Library.dao.LibraryDAO;
import com.example.Library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/reader")
public class ReaderController {


    private LibraryDAO libraryDAO;
    private BookMapper booksMapper;



    @Autowired
    public ReaderController(BookMapper booksMapper) {
//        this.libraryDAO = libraryDAO;
        this.booksMapper = booksMapper;
    }

    @GetMapping("/")
    public String getBooks(Model model, Book book) {

        //get list of book from dao
        model.addAttribute("books",  booksMapper.findAll());

        return "book-list";
    }

    @GetMapping("/book/{id}")
    public String getCustomer(@PathVariable("id") int id, Model model) {

        model.addAttribute("book", booksMapper.findBookById(id));
        return "book-review";
    }

    @PostMapping("/book")
    public String findBookByName(@ModelAttribute("book") Book book, Model model) {

        libraryDAO.getBooksByName(book.getBookName());
        model.addAttribute("books", libraryDAO.getBooksByName(book.getBookName()));
        return "book-list";
    }
}
