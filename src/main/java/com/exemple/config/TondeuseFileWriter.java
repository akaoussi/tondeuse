package com.exemple.config;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.WritableResource;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * ItemWriter personnalisé pour écrire les positions finales des Tondeuses dans un fichier de sortie.
 *
 * @param chunk Le lot d'éléments traités à écrire.
 *
 * @author Abdelghani KAOUSSI
 */

public class TondeuseFileWriter implements ItemWriter<String> {

    private final WritableResource resource = new FileSystemResource("output.txt");

    @Override
    public void write(Chunk<? extends String> chunk) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(resource.getOutputStream(), StandardCharsets.UTF_8))) {
            for (String item : chunk.getItems()) {
                writer.write(item);
                writer.newLine();
            }
        }
    }
}
