package org.telran.service;

import org.telran.model.Reader;

import java.util.List;

public interface ReaderService {

    List<Reader> getAll();

    Reader getByLogin(String login);

    Reader create(Reader reader);
}
