package com.exemple.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Modèle représentant une Tondeuse avec sa position et son orientation.
 *
 * @param x           La coordonnée x de la Tondeuse.
 * @param y           La coordonnée y de la Tondeuse.
 * @param orientation L'orientation de la Tondeuse (N, E, S, W).
 *
 * @author Abdelghani KAOUSSI
 */

@Getter
@Setter
public class Tondeuse {
    private int x;
    private int y;
    private char orientation;

    public Tondeuse(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void advance() {
        switch (orientation) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
        }
    }

    public void turnLeft() {
        switch (orientation) {
            case 'N':
                orientation = 'W';
                break;
            case 'E':
                orientation = 'N';
                break;
            case 'S':
                orientation = 'E';
                break;
            case 'W':
                orientation = 'S';
                break;
        }
    }

    public void turnRight() {
        switch (orientation) {
            case 'N':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'N';
                break;
        }
    }
}
