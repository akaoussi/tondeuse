package com.exemple.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PelouseTest {

    @Test
    public void testIsInside() {
        Pelouse pelouse = new Pelouse(5, 5);

        assertTrue(pelouse.isInside(0, 0), "Le point (0,0) devrait être à l'intérieur de la pelouse");
        assertTrue(pelouse.isInside(5, 5), "Le point (5,5) devrait être à l'intérieur de la pelouse");
        assertTrue(pelouse.isInside(3, 4), "Le point (3,4) devrait être à l'intérieur de la pelouse");

        assertFalse(pelouse.isInside(-1, 0), "Le point (-1,0) devrait être à l'extérieur de la pelouse");
        assertFalse(pelouse.isInside(0, 6), "Le point (0,6) devrait être à l'extérieur de la pelouse");
        assertFalse(pelouse.isInside(6, 5), "Le point (6,5) devrait être à l'extérieur de la pelouse");
        assertFalse(pelouse.isInside(5, -1), "Le point (5,-1) devrait être à l'extérieur de la pelouse");
    }

    @Test
    public void testPelouseDimensions() {
        Pelouse pelouse = new Pelouse(5, 5);

        assertEquals(5, pelouse.getWidth(), "La largeur devrait être 5");
        assertEquals(5, pelouse.getHeight(), "La hauteur devrait être 5");
    }
}
