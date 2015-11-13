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
import Repositorios.Materiais;
/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public class JanelaTest {
    
    public JanelaTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of calculaResistenciaTermica method, of class Janela.
     */
    @Test
    public void testCalculaResistenciaTermica() {
        System.out.println("Calcula resistencia termica:");
        Materiais.getInstance().inserirMaterial("Ferro", 0.5f);
        Janela janela = new Janela(3.0f, 4.0f, 0.006f, "Ferro");
        
        float res = janela.calculaResistenciaTermica();
        float resEsp = 0.001f;
        assertEquals(resEsp, res, 0);
    }

    /**
     * Test of calculaArea method, of class Janela.
     */
    @Test
    public void testCalculaArea() {
        Janela janela = new Janela(3.0f, 4.0f);
        float res = janela.calculaArea();
        float resEsp = 12.0f;
        assertEquals(resEsp, res, 0);
        System.out.println("Calcula area:");
    }

    /**
     * Test of getEspessura method, of class Janela.
     */
    @Test
    public void testGetEspessura() {
    }

    /**
     * Test of getNomeMaterial method, of class Janela.
     */
    @Test
    public void testGetNomeMaterial() {
    }
}