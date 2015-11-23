/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorys;

import Dominio.Camada;
import Dominio.Componente;
import Dominio.Janela;
import Dominio.Porta;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author 11011_000
 */
public class FabricaComponentesTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Testa criacao de portas
     */
    @Test
    public void testGetComponentePorta() {
        System.out.println("Fabrica de Componentes Porta");
        float altura = 1.33f;
        float largura = 2.80f;
        float espessura = 0.5f;
        String componente = "porta";
        FabricaComponentes instance = new FabricaComponentes();
        Componente result = instance.getComponente(componente, altura, largura, espessura, componente);
        assertTrue(result instanceof Porta);
    }

    /**
     * Testa criacao de janelas
     */
    @Test
    public void testGetComponenteJanela() {
        System.out.println("Fabrica de Componentes Janela");
        float altura = 1.33f;
        float largura = 2.80f;
        float espessura = 0.5f;
        String componente = "JANELA";
        FabricaComponentes instance = new FabricaComponentes();
        Componente result = instance.getComponente(componente, altura, largura, espessura, componente);
        assertTrue(result instanceof Janela);
    }

    /**
     * Testa criacao de camadas
     */
    @Test
    public void testGetComponenteCamada() {
        System.out.println("Fabrica de Componentes Camada");
        float altura = 1.33f;
        float largura = 2.80f;
        float espessura = 0.5f;
        String componente = "camada";
        FabricaComponentes instance = new FabricaComponentes();
        Componente result = instance.getComponente(componente, altura, largura, espessura, componente);
        assertTrue(result instanceof Camada);
    }

    /**
     * Testa criacao de nulls
     */
    @Test
    public void testGetComponenteDesconhecido() {
        System.out.println("Fabrica de Componentes desconhecidos");
        float altura = 1.33f;
        float largura = 2.80f;
        float espessura = 0.5f;
        String componente = "cammad";
        FabricaComponentes instance = new FabricaComponentes();
        Componente result = instance.getComponente(componente, altura, largura, espessura, componente);
        Componente expResult = null;
        assertEquals(expResult, result);

    }

    /**
     * Test of getComponente method, of class FabricaComponentes.
     */
    @Test
    public void testGetComponente() {
    }

}
