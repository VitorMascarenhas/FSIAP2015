/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public class JanelaTest {
    
    public JanelaTest() {
    }

    /**
     * Test of calculaResistenciaTermica method, of class Janela.
     */
    @Test
    public void testCalculaResistenciaTermica() {
        System.out.println("Calcular resistencia terminca da janela:");
        double altura = 3;
        double largura = 2;
        double espessura = 0.006;
        double coefRes = 0.5;
        double resTermica = 0.002;
        Janela j = new Janela(altura, largura, espessura, coefRes);
        double resultadoFinal = j.calculaResistenciaTermica();
        assertEquals(resTermica, resultadoFinal, 0);
    }

    /**
     * Test of calculaArea method, of class Janela.
     */
    @Test
    public void testCalculaArea() {
        System.out.println("Calcula a area da janela:");
        double altura = 2.5;
        double largura = 2.3;
        Janela j = new Janela(altura, largura);
        double resultado = 5.75;
        double resArea = j.calculaArea();
        assertEquals(resultado, resArea, 0);
    }
}