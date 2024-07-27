package com.exemple.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.batch.item.Chunk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TondeuseFileWriterTest {

    @InjectMocks
    private TondeuseFileWriter tondeuseFileWriter;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        Files.deleteIfExists(Paths.get("output.txt"));
    }

    @AfterEach
    public void tearDown() throws Exception {
        Files.deleteIfExists(Paths.get("output.txt"));
    }

    @Test
    public void testWriterFunctionality() throws Exception {
        List<String> items = Arrays.asList("line1", "line2", "line3");
        Chunk<String> chunk = new Chunk<>(items);
        tondeuseFileWriter.write(chunk);

        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            assertThat(reader.readLine()).isEqualTo("line1");
            assertThat(reader.readLine()).isEqualTo("line2");
            assertThat(reader.readLine()).isEqualTo("line3");
            assertThat(reader.readLine()).isNull();
        }
    }
}
