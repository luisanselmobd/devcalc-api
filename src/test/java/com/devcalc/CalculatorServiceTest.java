package com.devcalc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void configurar() {
        calculatorService = new CalculatorService();
    }

    @Test
    void deveSomarDoisNumerosCorretamente() {
        assertEquals(15, calculatorService.add(10, 5));
        assertEquals(-5, calculatorService.add(-10, 5));
        assertEquals(0, calculatorService.add(0, 0));
    }

    @Test
    void deveSubtrairDoisNumerosCorretamente() {
        assertEquals(5, calculatorService.subtract(10, 5));
        assertEquals(-15, calculatorService.subtract(-10, 5));
        assertEquals(0, calculatorService.subtract(0, 0));
    }

    @Test
    void deveMultiplicarDoisNumerosCorretamente() {
        assertEquals(50, calculatorService.multiply(10, 5));
        assertEquals(-50, calculatorService.multiply(-10, 5));
        assertEquals(0, calculatorService.multiply(0, 100));
    }

    @Test
    void deveDividirDoisNumerosCorretamente() {
        assertEquals(2, calculatorService.divide(10, 5));
        assertEquals(-2, calculatorService.divide(-10, 5));
        assertEquals(0, calculatorService.divide(0, 5));
    }

    @Test
    void deveLancarExcecaoAoDividirPorZero() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> calculatorService.divide(10, 0)
        );
        assertEquals("Divisor não pode ser zero", excecao.getMessage());
    }

    @Test
    void deveLancarExcecaoAoDividirNegativoPorZero() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> calculatorService.divide(-10, 0)
        );
        assertEquals("Divisor não pode ser zero", excecao.getMessage());
    }
}
