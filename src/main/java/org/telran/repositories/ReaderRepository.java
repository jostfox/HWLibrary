package org.telran.repositories;

import org.telran.model.Reader;

import java.util.List;

public interface ReaderRepository {

    List<Reader> getAll();

    Reader getByLogin(String login);

    Reader create(Reader reader);

}
