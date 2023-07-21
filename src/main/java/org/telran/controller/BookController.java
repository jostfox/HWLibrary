package org.telran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.exceptions.MissingArgument;
import org.telran.exceptions.NoSuchParameterException;
import org.telran.model.Book;
import org.telran.service.Bookservice;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private Bookservice bookService;

    @GetMapping
    public List<Book> list() {
        return bookService.getAll();
    }

    @GetMapping("/{isbn}")
    public Book getByIsbn(@PathVariable(name = "isbn") long isbn) {
        try {
            return bookService.findOne(isbn);
        } catch (NoSuchParameterException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PostMapping("/return")
    public void returnBookToLibrary(@RequestBody Book book) {
        try {
            bookService.returnToLibrary(book);
        } catch (MissingArgument e) {
            System.out.println(e.getMessage());
        }
    }

    @PostMapping("/borrow/{isbn}")
    public Book borrowBookFromLibrary(@PathVariable(name = "isbn") long isbn) {
        try {
            return bookService.borrowFromLibrary(isbn);
        } catch (NoSuchParameterException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
