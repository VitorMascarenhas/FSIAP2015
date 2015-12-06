/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Repositorios.Materiais;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 11011_000
 */
public class TermodinamicaTest {
   
    private final Materiais instanciaMaterial = Materiais.getInstance(); 
    private Parede parede;
    private Camada camada1, camada2, camada3;
    private Janela janela;

    
    public TermodinamicaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instanciaMaterial.inserirMaterial("tijolo", 0.81F);
        instanciaMaterial.inserirMaterial("espuma", 0.023F);
        instanciaMaterial.inserirMaterial("fibrocimento", 0.76F);
        instanciaMaterial.inserirMaterial("vidro", 0.79F);
        camada1 = new Camada(5,3,0.1F,"tijolo");
        camada2 = new Camada(5,3,0.04F,"Espuma");
        camada3 = new Camada(5,3,0.08F,"FIBROCIMENTO");
        janela = new Janela(1,2,0.03F,"vidro");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculaResistenciaTermica method, of class Termodinamica.
     */
    @Test
    public void testCalculaResistenciaTermica() {
        System.out.println("Calcula resistencia termica de componentes");
        float expResult = 0.008F;
        float result = Termodinamica.CalculaResistenciaTermica(camada1);
        assertEquals("A resistencia termica da 1ª camada é " + expResult + " W/K", expResult, result, 0.001);
        expResult = 0.115F;
        result = Termodinamica.CalculaResistenciaTermica(camada2);
        assertEquals("A resistencia termica da 2ª camada é " + expResult + " W/K", expResult, result, 0.001);
        expResult = 0.007F;
        result = Termodinamica.CalculaResistenciaTermica(camada3);
        assertEquals("A resistencia termica da 3ª camada é " + expResult + " W/K", expResult, result, 0.001);
        expResult = 0.019F;
        result = Termodinamica.CalculaResistenciaTermica(janela);
        assertEquals("A resistencia termica da janela é " + expResult + " W/K", expResult, result, 0.001);
    }

    /**
     * Test of calculaResistenciaTermicaTotal method, of class Termodinamica.
     */
    @Test
    public void testCalculaResistenciaTermicaTotal() {
        System.out.println("Calcula resistencia termica de uma parede");
        Parede parede = new Parede();
        parede.adicionarCamada(camada1);
        parede.adicionarCamada(camada2);
        parede.adicionarCamada(camada3);
        parede.adicionarJanela(janela);
        float expResult = 0.0175F;
        float result = Termodinamica.CalculaResistenciaTermicaTotal(parede.getComponentes());
        assertEquals("A resistencia termica da parede é " + expResult + " W/K", expResult, result, 0.001);
    }

    /**
     * Test of fluxoCalor method, of class Termodinamica.
     */
    @Test
    public void testFluxoCalor() {
        System.out.println("Calcula fluxo de calor que atravessa a parede");
        Parede parede = new Parede();
        parede.adicionarCamada(camada1);
        parede.adicionarCamada(camada2);
        parede.adicionarCamada(camada3);
        parede.adicionarJanela(janela);
        float tempInterior = 18.0F;
        float tempExterior = 30.0F;
        float expResult = 685.71F;
        float result = Termodinamica.FluxoCalor(parede, tempInterior, tempExterior);
        System.out.println(camada1.getArea());
        assertEquals("O fluxo de calor é de " + expResult + " W", expResult, result, 0.01);
    }
    
}
