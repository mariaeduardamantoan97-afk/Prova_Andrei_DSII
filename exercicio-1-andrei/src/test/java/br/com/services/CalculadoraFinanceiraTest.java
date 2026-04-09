package br.com.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CalculadoraFinanceiraTest {

    CalculadoraFinanceira calc = new CalculadoraFinanceira();

    @Test
    @DisplayName("Testando calcularDesconto")
    void testDesconto() {
        assertEquals(90.0, calc.calcularDesconto(100.0, 10.0));
        assertEquals(100.0, calc.calcularDesconto(100.0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> calc.calcularDesconto(-5, 10));
    }

    @Test
    @DisplayName("Testando calcularJurosSimples")
    void testJuros() {
        assertEquals(200.0, calc.calcularJurosSimples(1000.0, 0.1, 2));
        assertThrows(IllegalArgumentException.class, () -> calc.calcularJurosSimples(0, 0.1, 2));
    }

    @Test
    @DisplayName("Testando calcularMedia")
    void testMedia() {
        double[] valores = {10.0, 8.0, 6.0};
        assertEquals(8.0, calc.calcularMedia(valores));
        assertThrows(IllegalArgumentException.class, () -> calc.calcularMedia(new double[]{}));
        assertThrows(IllegalArgumentException.class, () -> calc.calcularMedia(null));
    }

    @Test
    @DisplayName("Testando ehAprovado")
    void testAprovacao() {
        assertTrue(calc.ehAprovado(6.1));
        assertTrue(calc.ehAprovado(6.0));
        assertFalse(calc.ehAprovado(5.9));
    }
}