package org.telran.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telran.model.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookserviceImplTest {

    @Autowired
    Bookservice bookService;


    @Test
    void getAll() {
        assertEquals(3, bookService.getAll().size());
    }

    @Test
    void findOne() {
        Book book = bookService.findOne(12346l);
        assertNotNull(book);
        assertEquals("Harry Potter II", book.getName());
        assertEquals("Rowling", book.getAuthor().getSurname());
        assertEquals(1996, book.getYear());
    }

    @Test
    void borrowFromLibrary() {
        Book book = bookService.borrowFromLibrary(12346l);
        List<Book> all = bookService.getAll();
        assertEquals(2, all.size());
    }

    @Test
    void returnToLibrary() {
    }
}