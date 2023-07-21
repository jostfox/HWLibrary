package org.telran.service;

import org.telran.model.Book;

import java.util.List;

public interface Bookservice {
    List<Book> getAll();

    Book findOne(long isbn);

    Book borrowFromLibrary(long isbn);

    boolean returnToLibrary(Book book);
}
