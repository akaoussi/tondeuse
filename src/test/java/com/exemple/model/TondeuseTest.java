package com.exemple.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TondeuseTest {

    @Test
    public void testAdvanceNorth() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.advance();
        assertEquals(0, tondeuse.getX(), "La position X devrait être 0 après l'avancement vers le Nord");
        assertEquals(1, tondeuse.getY(), "La position Y devrait être 1 après l'avancement vers le Nord");
    }

    @Test
    public void testAdvanceEast() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'E');
        tondeuse.advance();
        assertEquals(1, tondeuse.getX(), "La position X devrait être 1 après l'avancement vers l'Est");
        assertEquals(0, tondeuse.getY(), "La position Y devrait être 0 après l'avancement vers l'Est");
    }

    @Test
    public void testAdvanceSouth() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'S');
        tondeuse.advance();
        assertEquals(0, tondeuse.getX(), "La position X devrait être 0 après l'avancement vers le Sud");
        assertEquals(-1, tondeuse.getY(), "La position Y devrait être -1 après l'avancement vers le Sud");
    }

    @Test
    public void testAdvanceWest() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'W');
        tondeuse.advance();
        assertEquals(-1, tondeuse.getX(), "La position X devrait être -1 après l'avancement vers l'Ouest");
        assertEquals(0, tondeuse.getY(), "La position Y devrait être 0 après l'avancement vers l'Ouest");
    }

    @Test
    public void testTurnLeftFromNorth() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.turnLeft();
        assertEquals('W', tondeuse.getOrientation(), "L'orientation devrait être Ouest après un tour à gauche depuis le Nord");
    }

    @Test
    public void testTurnLeftFromEast() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'E');
        tondeuse.turnLeft();
        assertEquals('N', tondeuse.getOrientation(), "L'orientation devrait être Nord après un tour à gauche depuis l'Est");
    }

    @Test
    public void testTurnLeftFromSouth() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'S');
        tondeuse.turnLeft();
        assertEquals('E', tondeuse.getOrientation(), "L'orientation devrait être Est après un tour à gauche depuis le Sud");
    }

    @Test
    public void testTurnLeftFromWest() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'W');
        tondeuse.turnLeft();
        assertEquals('S', tondeuse.getOrientation(), "L'orientation devrait être Sud après un tour à gauche depuis l'Ouest");
    }

    @Test
    public void testTurnRightFromNorth() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.turnRight();
        assertEquals('E', tondeuse.getOrientation(), "L'orientation devrait être Est après un tour à droite depuis le Nord");
    }

    @Test
    public void testTurnRightFromEast() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'E');
        tondeuse.turnRight();
        assertEquals('S', tondeuse.getOrientation(), "L'orientation devrait être Sud après un tour à droite depuis l'Est");
    }

    @Test
    public void testTurnRightFromSouth() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'S');
        tondeuse.turnRight();
        assertEquals('W', tondeuse.getOrientation(), "L'orientation devrait être Ouest après un tour à droite depuis le Sud");
    }

    @Test
    public void testTurnRightFromWest() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'W');
        tondeuse.turnRight();
        assertEquals('N', tondeuse.getOrientation(), "L'orientation devrait être Nord après un tour à droite depuis l'Ouest");
    }
}
