package com.exemple.service;

import com.exemple.model.Pelouse;
import com.exemple.model.Tondeuse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TondeuseServiceTest {

    private final TondeuseService tondeuseService = new TondeuseService();

    @Test
    public void testExecuteInstructions() {
        Pelouse pelouse = new Pelouse(5, 5);
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N');
        String instructions = "GAGAGAGAA";

        tondeuseService.executeInstructions(tondeuse, pelouse, instructions);
        assertEquals("1 3 N", tondeuseService.getFinalPosition(tondeuse), "La position finale devrait être (1, 3, N)");
    }

    @Test
    public void testExecuteInstructionsWithInvalidInstruction() {
        Pelouse pelouse = new Pelouse(5, 5);
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N');
        String instructions = "GAGXAGAGAA";

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                tondeuseService.executeInstructions(tondeuse, pelouse, instructions));
        assertEquals("Invalid instruction: X", exception.getMessage(), "L'instruction invalide devrait lancer une exception avec le message approprié");
    }

    @Test
    public void testTurnLeft() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuseService.executeInstructions(tondeuse, null, "G");
        assertEquals('W', tondeuse.getOrientation(), "L'orientation devrait être Ouest après un tour à gauche depuis le Nord");
    }

    @Test
    public void testTurnRight() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuseService.executeInstructions(tondeuse, null, "D");
        assertEquals('E', tondeuse.getOrientation(), "L'orientation devrait être Est après un tour à droite depuis le Nord");
    }

    @Test
    public void testMoveForward() {
        Pelouse pelouse = new Pelouse(5, 5);
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuseService.executeInstructions(tondeuse, pelouse, "A");
        assertEquals(0, tondeuse.getX(), "La position X devrait être 0 après un avancement vers le Nord");
        assertEquals(1, tondeuse.getY(), "La position Y devrait être 1 après un avancement vers le Nord");
    }

    @Test
    public void testMoveForwardOutOfBounds() {
        Pelouse pelouse = new Pelouse(5, 5);
        Tondeuse tondeuse = new Tondeuse(5, 5, 'N');
        tondeuseService.executeInstructions(tondeuse, pelouse, "A");
        assertEquals(5, tondeuse.getX(), "La position X devrait être 5 après une tentative d'avancement hors des limites vers le Nord");
        assertEquals(5, tondeuse.getY(), "La position Y devrait être 5 après une tentative d'avancement hors des limites vers le Nord");
    }

    @Test
    public void testGetFinalPosition() {
        Tondeuse tondeuse = new Tondeuse(3, 3, 'E');
        String finalPosition = tondeuseService.getFinalPosition(tondeuse);
        assertEquals("3 3 E", finalPosition, "La position finale devrait être (3, 3, E)");
    }
}
