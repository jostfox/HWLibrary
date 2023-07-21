package org.telran.repositories;

import org.springframework.stereotype.Repository;
import org.telran.model.Reader;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReaderRepositoryImpl implements ReaderRepository {

    private final Map<String, Reader> readerStorage = new HashMap<>();

    @PostConstruct
    private void init() {
        readerStorage.put("alex234", new Reader("alex234", "qqqdddFFF", "Alex",
                "Green", 21));
        readerStorage.put("hanna156", new Reader("hanna156", "ddddggg444", "Hanna",
                "Schmidt", 23));
        readerStorage.put("julia485", new Reader("julia485", "dddhhh5gh", "Julia",
                "Wecker", 20));
    }

    @Override
    public List<Reader> getAll() {
        return new ArrayList<>(readerStorage.values());
    }

    @Override
    public Reader getByLogin(String login) {
        return readerStorage.get(login);
    }

    @Override
    public Reader create(Reader reader) {
        return readerStorage.put(reader.getLogin(), reader);
    }
}
