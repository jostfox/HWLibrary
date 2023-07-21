package org.telran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.exceptions.MissingArgument;
import org.telran.exceptions.NoSuchParameterException;
import org.telran.model.Book;
import org.telran.repositories.BookRepository;

import java.util.List;

@Service
public class BookserviceImpl implements Bookservice {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        List<Book> books = bookRepository.getAll();
        if (books.isEmpty()) {
            System.out.println("There are no books");
        }
        return bookRepository.getAll();
    }

    @Override
    public Book findOne(long isbn) {
        Book book = bookRepository.findOne(isbn);
        if (book == null) {
            throw new NoSuchParameterException("No such ISBN Exception");
        }
        return bookRepository.findOne(isbn);
    }

    @Override
    public Book borrowFromLibrary(long isbn) {
        Book book = bookRepository.findOne(isbn);
        if (book == null) {
            throw new NoSuchParameterException("No such ISBN Exception");
        }
        return bookRepository.borrowFromLibrary(isbn);
    }

    @Override
    public boolean returnToLibrary(Book book) {
        if (book.getName() == null ||
                book.getIsbn() == 0L ||
                book.getAuthor() == null ||
                book.getYear() == 0) {
            throw new MissingArgument("Missing or wrong argument Exception");
        }
        return bookRepository.returnToLibrary(book);
    }
}
