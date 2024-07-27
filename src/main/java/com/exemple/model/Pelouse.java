package com.exemple.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Modèle représentant une Pelouse avec ses dimensions.
 *
 * @param width  La largeur de la Pelouse.
 * @param height La hauteur de la Pelouse.
 *
 * @author Abdelghani KAOUSSI
 */


@Getter
@Setter
public class Pelouse {

    private final int width;
    private final int height;

    public Pelouse(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && x <= width && y >= 0 && y <= height;
    }
}