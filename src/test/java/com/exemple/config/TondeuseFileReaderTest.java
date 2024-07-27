package com.exemple.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.core.io.ClassPathResource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TondeuseFileReaderTest {

    @InjectMocks
    private TondeuseFileReader tondeuseFileReader;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        tondeuseFileReader.setResource(new ClassPathResource("input.txt"));
    }


    @Test
    public void testReadLines() throws Exception {
        // input.txt :
        // 5 5
        // 1 2 N
        // GAGAGAGAA
        // 3 3 E
        // AADAADADDA

        ExecutionContext executionContext = new ExecutionContext();
        tondeuseFileReader.open(executionContext);

        assertEquals("5 5", tondeuseFileReader.read());
        assertEquals("1 2 N", tondeuseFileReader.read());
        assertEquals("GAGAGAGAA", tondeuseFileReader.read());
        assertEquals("3 3 E", tondeuseFileReader.read());
        assertEquals("AADAADADDA", tondeuseFileReader.read());
        assertEquals(null, tondeuseFileReader.read());
    }
}
