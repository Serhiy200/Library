package com.example.Library.controllers;

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

    @Autowired
    public LibrarianController(LibraryDAO libraryDAO) {
        this.libraryDAO = libraryDAO;
    }


    @GetMapping("/")
    public String getBooks(Model model, Book book) {
        //get list of books from dao
        model.addAttribute("books", libraryDAO.getAllBooks());
        model.addAttribute("categories", libraryDAO.getAllCategories());
        return "librarian-page";
    }

    @GetMapping("/add")
    public String addBookOrCategory(Model model, Book book) {
        //get list of books from dao
        model.addAttribute("books", libraryDAO.getAllBooks());
        model.addAttribute("categories", libraryDAO.getAllCategories());
        return "book-add";
    }


    @PostMapping("/book")
    public String findBookByName(@ModelAttribute("book") Book book, Model model) {

        libraryDAO.getBooksByName(book.getBookName());
        model.addAttribute("books", libraryDAO.getBooksByName(book.getBookName()));
        return "librarian-page";
    }

    @PostMapping("/category")
    public String addCategory(@ModelAttribute("category") Categories category, Model model) {

        libraryDAO.addCategory(category.getCategoryName());
        return "redirect:/librarian/";
    }

    @GetMapping("/book/{id}")
    public String getCustomer(@PathVariable("id") int id, Model model) {

        model.addAttribute("book", libraryDAO.getBookById(id));
        model.addAttribute("categories", libraryDAO.getAllCategories());
        return "book-update";
    }


    @PutMapping("/book/{id}")
    public String updateCustomer(@Valid @ModelAttribute("book") Book book, @PathVariable("id") int id, BindingResult bindingResult) {

        //verification data from html
        if (bindingResult.hasErrors()) {
            return "book-list";
        }

        //update date about book in Database
        libraryDAO.updateBook(id, book);

        return "redirect:/librarian/";
    }

    @DeleteMapping("/book/{id}")
    public String deleteCustomer(@PathVariable(value = "id", required = false) int id) {

        //delete book from Database
        libraryDAO.deleteBook(id);

        return "redirect:/librarian/";
    }


}
