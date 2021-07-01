package com.example.Library.controllers;

import com.example.Library.dao.BookMapper;
import com.example.Library.models.Book;
import com.example.Library.models.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/librarian")
public class LibrarianController {

    private BookMapper booksMapper;

    @Autowired
    public LibrarianController(BookMapper bookMapper) {
        this.booksMapper = bookMapper;
    }


    @GetMapping("/")
    public String getBooks(Model model, Book book) {
        //get list of books from dao
        model.addAttribute("books", booksMapper.findAll());
        model.addAttribute("categories", booksMapper.getAllCategories());
        return "librarian-page";
    }

    @GetMapping("/add")
    public String addBookOrCategory(Model model, Book book) {
        //get list of books from dao
        model.addAttribute("categories", booksMapper.getAllCategories());
        return "book-add";
    }

    @PostMapping("/add")
    public String addNewBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = LibraryController.getErrors(bindingResult);

            model.addAttribute("categories", booksMapper.getAllCategories());
            model.mergeAttributes(errorsMap);
            return "book-add";
        }

        booksMapper.addBook(book);
        return "redirect:/librarian/";
    }

    @PostMapping("/book")
    public String findBookByName(@ModelAttribute("book") Book book, Model model) {

        List<Book> searchBooks = booksMapper.searchBook(book);
        model.addAttribute("categories", booksMapper.getAllCategories());

        if (searchBooks.size() == 0) {
            model.addAttribute("errorMessage", "We can't find book with these parameters");
            return "librarian-page";
        }
        model.addAttribute("books", searchBooks);
        return "librarian-page";
    }

    @PostMapping("/category")
    public String addCategory(@Valid @ModelAttribute("category") Categories category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = LibraryController.getErrors(bindingResult);

            model.addAttribute("categories", booksMapper.getAllCategories());
            model.mergeAttributes(errorsMap);
            return "book-add";
        }

        booksMapper.addCategory(category.getCategoryName());
        return "redirect:/librarian/";
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable("id") int id, Model model) {

        model.addAttribute("book", booksMapper.findBookById(id));
        model.addAttribute("categories", booksMapper.getAllCategories());
        return "book-update";
    }

    @PostMapping("/book/{id}")
    public String updateCustomer(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = LibraryController.getErrors(bindingResult);

            model.addAttribute("categories", booksMapper.getAllCategories());
            model.mergeAttributes(errorsMap);
            return "book-update";
        }

        //update date about book in Database
        booksMapper.updateBook(book);

        return "redirect:/librarian/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id", required = false) int id) {

        //delete book from Database
        booksMapper.deleteBook(id);

        return "redirect:/librarian/";
    }
}
