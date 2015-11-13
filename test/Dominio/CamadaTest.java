/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Repositorios.Materiais;
import java.text.DecimalFormat;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public class CamadaTest {
    
    public CamadaTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of calculaResistenciaTermica method, of class Camada.
     */
    @Test
    public void testCalculaResistenciaTermica() {
        System.out.println("CalculaCamadaResistenciaTermica");
        float altura = (float) 1.5;
        float largura = (float) 8.0;
        Materiais instance = Materiais.getInstance();
        instance.inserirMaterial("Ferro", 80.2F);
        Camada camada = new Camada(altura, largura, (float) 1.5,"ferro");
        System.out.println(camada.calculaResistenciaTermica());
        double resultado = 0.00155;
        assertEquals("CalculaCamadaAreaTest", resultado, camada.calculaResistenciaTermica(), 0.00001);
    }

    /**
     * Test of calculaArea method, of class Camada.
     */
    @Test
    public void testCalculaArea() {
        System.out.println("CalculaCamadaAreaTest");
        float altura = (float) 1.5;
        float largura = (float) 8.0;
        Camada camada = new Camada(altura, largura, (float) 1.5,"cimento");
        double resultado = 12;
        assertEquals("CalculaCamadaAreaTest", resultado, camada.calculaArea(), 0.0);
    }
    
}
