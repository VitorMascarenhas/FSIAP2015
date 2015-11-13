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
import Repositorios.Materiais;
/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public class ParedeTest {
    
    public ParedeTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of calculaResistenciaTermicaTotal method, of class Parede.
     */
    @Test
    public void testCalculaResistenciaTermicaTotal() {
        System.out.println("Calcula resistencia termica total:");
        Parede parede1 = new Parede();
        Materiais.getInstance().inserirMaterial("Ferro", 0.5f);
        Materiais.getInstance().inserirMaterial("Aco", 1.0f);
        
        Camada camada1 = new Camada(3.0f, 4.0f, 0.006f, "Ferro");
        Camada camada2 = new Camada(4.0f, 3.0f, (float)0.0012, "Aco");
        parede1.adicionarCamada(camada1);
        parede1.adicionarCamada(camada2);
        float res = parede1.calculaResistenciaTermicaTotal();
        assertEquals(0.002f, res, 0);
    }

    /**∂
     * Test of adicionarCamada method, of class Parede.
     */
    @Test
    public void testAdicionarCamada() {
    }

    /**
     * Test of adicionarJanela method, of class Parede.
     */
    @Test
    public void testAdicionarJanela() {
    }

    /**
     * Test of adicionaPorta method, of class Parede.
     */
    /*@Test
    public void testAdicionarPorta() {
        Parede parede = new Parede();
        assertTrue("Parede não tem componentes: ", parede.getComponentes().isEmpty());
        Janela janela1 = new Janela();
        Janela janela2 = new Janela();
        Janela janela3 = new Janela();
        
        parede.adicionarJanela(janela1);
        assertTrue("Parede tem 1 componente", parede.getComponentes().size()==1);
        parede.adicionarJanela(janela2);
        assertTrue("Parede tem 2 componente", parede.getComponentes().size()==2);
        parede.adicionarJanela(janela3);
        assertTrue("Parede tem 3 componente", parede.getComponentes().size()==3);
    }*/

    /**
     * Test of getComponentes method, of class Parede.
     */
    @Test
    public void testGetComponentes() {
        /*Materiais.getInstance().inserirMaterial("Ferro", 0.5f);
        Materiais.getInstance().inserirMaterial("Aço", 1.0f);
        
        Parede parede = new Parede();
        Camada camada1 = new Camada(4.0f, 3.0f, 0.006f, "Ferro");
        Camada camada2 = new Camada(4.0f, 3.0f, 0.006f, "Aço");
        parede.adicionarCamada(camada1);
        parede.adicionarCamada(camada2);
        
        float res = parede.calculaResistenciaTermicaTotal();
        float resEsp = 0.0015f;
        assertEquals(resEsp, res, 0);*/
    }
}