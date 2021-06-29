package com.example.Library.controllers;

import com.example.Library.dao.BookMapper;
import com.example.Library.dao.LibraryDAO;
import com.example.Library.models.Book;
import com.example.Library.models.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/librarian")
public class LibrarianController {

    private LibraryDAO libraryDAO;

    private BookMapper bookMapper;

    @Autowired
    public LibrarianController(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }


    //    @GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBooks(Model model, Book book) {
        //get list of books from dao
        model.addAttribute("books", bookMapper.findAll());
//        model.addAttribute("categories", bookMapper.getAllCategory());
        return "librarian-page";
    }

    @GetMapping("/add")
    public String addBookOrCategory(Model model, Book book) {
        //get list of books from dao
//        model.addAttribute("books", libraryDAO.getAllBooks());
        model.addAttribute("categories", bookMapper.getAllCategories());
        return "book-add";
    }

    @PostMapping("/add")
    public String addNewBook(@ModelAttribute("book") Book book, Model model) {

        bookMapper.addBook(book);
//        model.addAttribute("books", libraryDAO.getBooksByName(book.getBookName()));
        return "redirect:/librarian/";
    }

    @PostMapping("/book")
    public String findBookByName(@ModelAttribute("book") Book book, Model model) {

        //libraryDAO.getBooksByName(book.getBookName());
        model.addAttribute("books", libraryDAO.getBooksByName(book.getBookName()));
        return "librarian-page";
    }

    @PostMapping("/category")
    public String addCategory(@ModelAttribute("category") Categories category, Model model) {

        bookMapper.addCategory(category.getCategoryName());
        return "redirect:/librarian/";
    }

    @GetMapping("/book/{id}")
    public String getCustomer(@PathVariable("id") int id, Model model) {

        model.addAttribute("book", bookMapper.findBookById(id));
        model.addAttribute("categories", bookMapper.getAllCategories());
        return "book-update";
    }


    //    @PutMapping("/book/{id}")
    @RequestMapping(value = "/book/{id}", method = {RequestMethod.PUT})
    public String updateCustomer(@ModelAttribute("book") Book book, @PathVariable("id") int id, BindingResult bindingResult) {

//        //verification data from html
//        if (bindingResult.hasErrors()) {
//            return "book-list";
//        }

        //update date about book in Database
        bookMapper.updateBook(book);

        return "redirect:/librarian/";
    }

    @DeleteMapping("/book/{id}")
    public String deleteCustomer(@PathVariable(value = "id", required = false) int id) {

        //delete book from Database
        bookMapper.deleteBook(id);

        return "redirect:/librarian/";
    }


}
