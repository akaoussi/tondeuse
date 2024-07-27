package com.exemple.config;

import com.exemple.model.Pelouse;
import com.exemple.model.Tondeuse;
import com.exemple.service.TondeuseService;
import org.springframework.batch.item.ItemProcessor;


/**
 * Processeur pour lire et traiter les lignes du fichier d'entrée pour les instructions de Tondeuse.
 * Il analyse les dimensions de la pelouse et traite chaque position initiale de la tondeuse et les instructions de mouvement.
 *
 * @param tondeuseService Le service pour gérer les instructions de la Tondeuse.
 *
 * @author Abdelghani KAOUSSI
 */


public class TondeuseFileProcessor implements ItemProcessor<String, String> {

    private final TondeuseService tondeuseService;
    private Pelouse pelouse;
    private Tondeuse tondeuse;

    public TondeuseFileProcessor(TondeuseService tondeuseService) {
        this.tondeuseService = tondeuseService;
    }

    @Override
    public String process(String item) throws Exception {
        if (item.matches("\\d+ \\d+")) {

            String[] pelouseDimensions = item.split(" ");
            pelouse = new Pelouse(Integer.parseInt(pelouseDimensions[0]), Integer.parseInt(pelouseDimensions[1]));
            return null;

        } else if (item.matches("\\d+ \\d+ [NSEW]")) {

            String[] initialPosition = item.split(" ");
            tondeuse = new Tondeuse(Integer.parseInt(initialPosition[0]), Integer.parseInt(initialPosition[1]), initialPosition[2].charAt(0));
            return null;

        } else if (item.matches("[GAD]+")) {

            tondeuseService.executeInstructions(tondeuse, pelouse, item);
            return tondeuseService.getFinalPosition(tondeuse);

        } else {
            throw new IllegalArgumentException("Invalid line: " + item);
        }
    }
}
