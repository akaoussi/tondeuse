package com.exemple.service;

import com.exemple.model.Pelouse;
import com.exemple.model.Tondeuse;
import org.springframework.stereotype.Service;


/**
 * Service pour exécuter des instructions sur une Tondeuse dans une Pelouse.
 * Fournit des méthodes pour tourner la tondeuse à gauche, à droite et avancer tout en veillant à ce qu'elle reste dans les limites.
 *
 * @author Abdelghani KAOUSSI
 */

@Service
public class TondeuseService {

    public void executeInstructions(Tondeuse tondeuse, Pelouse pelouse, String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'G':
                    turnLeft(tondeuse);
                    break;
                case 'D':
                    turnRight(tondeuse);
                    break;
                case 'A':
                    moveForward(tondeuse, pelouse);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid instruction: " + instruction);
            }
        }
    }

    private void turnLeft(Tondeuse tondeuse) {
        switch (tondeuse.getOrientation()) {
            case 'N':
                tondeuse.setOrientation('W');
                break;
            case 'W':
                tondeuse.setOrientation('S');
                break;
            case 'S':
                tondeuse.setOrientation('E');
                break;
            case 'E':
                tondeuse.setOrientation('N');
                break;
        }
    }

    private void turnRight(Tondeuse tondeuse) {
        switch (tondeuse.getOrientation()) {
            case 'N':
                tondeuse.setOrientation('E');
                break;
            case 'E':
                tondeuse.setOrientation('S');
                break;
            case 'S':
                tondeuse.setOrientation('W');
                break;
            case 'W':
                tondeuse.setOrientation('N');
                break;
        }
    }

    private void moveForward(Tondeuse tondeuse, Pelouse pelouse) {
        switch (tondeuse.getOrientation()) {
            case 'N':
                if (tondeuse.getY() < pelouse.getHeight()) {
                    tondeuse.setY(tondeuse.getY() + 1);
                }
                break;
            case 'E':
                if (tondeuse.getX() < pelouse.getWidth()) {
                    tondeuse.setX(tondeuse.getX() + 1);
                }
                break;
            case 'S':
                if (tondeuse.getY() > 0) {
                    tondeuse.setY(tondeuse.getY() - 1);
                }
                break;
            case 'W':
                if (tondeuse.getX() > 0) {
                    tondeuse.setX(tondeuse.getX() - 1);
                }
                break;
        }
    }

    public String getFinalPosition(Tondeuse tondeuse) {
        return tondeuse.getX() + " " + tondeuse.getY() + " " + tondeuse.getOrientation();
    }
}
