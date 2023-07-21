package org.telran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.exceptions.MissingArgument;
import org.telran.exceptions.NoSuchParameterException;
import org.telran.model.Reader;
import org.telran.repositories.ReaderRepository;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public List<Reader> getAll() {
        List<Reader> readers = readerRepository.getAll();
        if (readers.isEmpty()) {
            System.out.println("There are no readers");
        }
        return readerRepository.getAll();
    }

    @Override
    public Reader getByLogin(String login) {
        Reader reader = readerRepository.getByLogin(login);
        if (reader == null) {
            throw new NoSuchParameterException("No such login Exception");
        }
        return readerRepository.getByLogin(login);
    }

    @Override
    public Reader create(Reader reader) {
        if (reader.getLogin() == null ||
                reader.getFirstName() == null ||
                reader.getLastName() == null ||
                reader.getAge() == 0) {
            throw new MissingArgument("Missing or wrong argument Exception");
        }
        return readerRepository.create(reader);
    }
}
