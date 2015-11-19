/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Repositorios.Materiais;
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
        float altura = (float) 2.5;
        float largura = (float) 4.2;
        Materiais instance = Materiais.getInstance();
        
        instance.inserirMaterial("Madeira", 5.2F);
        Porta porta = new Porta(altura, largura, (float) 1.5, "Madeira");
        double resultado = 10.5;
        assertEquals("CalculaAreaTest", resultado, porta.calculaArea(), 0.0);
    }
    
}
