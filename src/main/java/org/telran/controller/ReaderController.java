package org.telran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.exceptions.MissingArgument;
import org.telran.exceptions.NoSuchParameterException;
import org.telran.model.Reader;
import org.telran.service.ReaderService;

import java.util.List;

@RestController
@RequestMapping("reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping
    public List<Reader> getAll() {
        return readerService.getAll();
    }

    @GetMapping("/{login}")
    public Reader getByLogin(@PathVariable(name = "login") String login) {
        try {
            return readerService.getByLogin(login);
        } catch (NoSuchParameterException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PostMapping
    public Reader create(@RequestBody Reader reader) {
        try {
            return readerService.create(reader);
        } catch (MissingArgument e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
