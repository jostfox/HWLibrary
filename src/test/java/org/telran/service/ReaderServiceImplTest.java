package org.telran.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telran.model.Reader;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReaderServiceImplTest {

    @Autowired
    ReaderService readerService;

    @Test
    void getAll() {
        assertEquals(3, readerService.getAll().size());
    }

    @Test
    void getByLogin() {
        Reader reader = readerService.getByLogin("hanna156");
        assertNotNull(reader);
        assertEquals("Hanna", reader.getFirstName());
        assertEquals("Schmidt", reader.getLastName());
        assertEquals(23, reader.getAge());
    }

}