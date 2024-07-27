package com.exemple.config;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.core.io.ClassPathResource;

/**
 * ItemReader personnalisé pour lire les données d'un fichier texte.
 * <p>
 * Cette classe configure un lecteur de fichier plat pour lire les lignes du fichier d'entrée et les transmettre
 * telles quelles pour un traitement ultérieur.
 *
 * @author Abdelghani KAOUSSI
 */

public class TondeuseFileReader extends FlatFileItemReader<String> {

    public TondeuseFileReader() {
        setResource(new ClassPathResource("input.txt"));
        setLineMapper(new PassThroughLineMapper());
    }

    @Override
    public String read() throws Exception {
        return super.read();
    }
}
