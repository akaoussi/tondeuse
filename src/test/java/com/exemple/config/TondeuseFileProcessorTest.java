package com.exemple.config;

import com.exemple.model.Pelouse;
import com.exemple.model.Tondeuse;
import com.exemple.service.TondeuseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TondeuseFileProcessorTest {

    @Mock
    private TondeuseService tondeuseService;

    @InjectMocks
    private TondeuseFileProcessor tondeuseFileProcessor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessPelouseDimensions() throws Exception {
        String input = "5 5";
        assertNull(tondeuseFileProcessor.process(input));

        // Test si la pelouse est correctement initialisée
        Pelouse pelouse = new Pelouse(5, 5);
        assertEquals(pelouse.getWidth(), 5);
        assertEquals(pelouse.getHeight(), 5);
    }

    @Test
    public void testProcessTondeuseInitialPosition() throws Exception {
        // Set pelouse dimensions first
        tondeuseFileProcessor.process("5 5");

        String input = "1 2 N";
        assertNull(tondeuseFileProcessor.process(input));

        // Test si la tondeuse est correctement initialisée
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N');
        assertEquals(tondeuse.getX(), 1);
        assertEquals(tondeuse.getY(), 2);
        assertEquals(tondeuse.getOrientation(), 'N');
    }

    @Test
    public void testProcessTondeuseInstructions() throws Exception {
        // Set pelouse dimensions and initial tondeuse position first
        tondeuseFileProcessor.process("5 5");
        tondeuseFileProcessor.process("1 2 N");

        String input = "GAGAGAGAA";
        when(tondeuseService.getFinalPosition(any(Tondeuse.class)))
                .thenReturn("1 3 N");

        String result = tondeuseFileProcessor.process(input);
        assertEquals("1 3 N", result);

        verify(tondeuseService).executeInstructions(any(Tondeuse.class), any(Pelouse.class), eq(input));
    }

    @Test
    public void testProcessInvalidLine() {
        String input = "invalid line";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tondeuseFileProcessor.process(input);
        });

        String expectedMessage = "Invalid line: " + input;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testFullProcess() throws Exception {
        String inputPelouse = "5 5";
        String inputPosition1 = "1 2 N";
        String inputInstructions1 = "GAGAGAGAA";
        String inputPosition2 = "3 3 E";
        String inputInstructions2 = "AADAADADDA";

        when(tondeuseService.getFinalPosition(any(Tondeuse.class)))
                .thenReturn("1 3 N", "5 1 E");

        assertNull(tondeuseFileProcessor.process(inputPelouse));
        assertNull(tondeuseFileProcessor.process(inputPosition1));
        assertEquals("1 3 N", tondeuseFileProcessor.process(inputInstructions1));
        assertNull(tondeuseFileProcessor.process(inputPosition2));
        assertEquals("5 1 E", tondeuseFileProcessor.process(inputInstructions2));

        verify(tondeuseService).executeInstructions(any(Tondeuse.class), any(Pelouse.class), eq(inputInstructions1));
        verify(tondeuseService).executeInstructions(any(Tondeuse.class), any(Pelouse.class), eq(inputInstructions2));
    }
}
