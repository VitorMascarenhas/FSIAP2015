/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public class PortaTest {
    
    public PortaTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of calculaResistenciaTermica method, of class Porta.
     */
    @Test
    public void testCalculaResistenciaTermica() {
    }

    /**
     * Test of calculaArea method, of class Porta.
     */
    @Test
    public void testCalculaArea() {
        double altura = 2.5;
        double largura = 4.2;
        Porta porta = new Porta(altura, largura, 1.5);
        double resultado = 10.5;
        assertEquals("CalculaAreaTest", resultado, porta.calculaArea(), 0.0);
    }
    
}
