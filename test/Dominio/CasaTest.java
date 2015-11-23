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
public class CasaTest {
    public Casa casa2;
    
    public CasaTest() {
    }

    @Before
    public void setUp() throws Exception {
        float altura = 1.33f;
        float largura = 2.80f;
        float comprimento = 6.55f;
        float interior = 18.80f;
        float exterior = 6.55f;
        float tempTerra = 17.1f;
        Casa casa2 = new Casa(interior, exterior, tempTerra, altura, largura, comprimento);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of adicionarParede method, of class Casa.
     */
    @Test
    public void testAdicionarParede() {
    }

    /**
     * Test of calculaResistenciaTermicaTotal method, of class Casa.
     */
    @Test
    public void testCalculaResistenciaTermicaTotal() {
        System.out.println("CalculaResistenciaTermicaTotal");

        float tempExt = 30f;
        float tempInt = 20f;
        float tempSolo = 15;
        float altura = 3f;
        float largura = 9f;
        float comprimento = 12f;
        
        Casa casa1=new Casa(tempExt, tempInt, tempSolo, altura, largura, comprimento);
        
        Materiais instance = Materiais.getInstance();
        instance.inserirMaterial("Ferro", 80.2F);
        instance.inserirMaterial("Cimento", 8.2F);
        instance.inserirMaterial("Tijolo", 10.2F);
        instance.inserirMaterial("Vidro", 15.2F);
        instance.inserirMaterial("Madeira", 5.2F);
        
        Parede parede1 = new Parede();
        Camada camada11 = new Camada(altura, largura, 0.006f, "Ferro");
        Camada camada12 = new Camada(altura, largura, 0.0012f, "Cimento");
        Camada camada13 = new Camada(altura, largura, 0.0012f, "Tijolo");
        parede1.adicionarCamada(camada11);
        parede1.adicionarCamada(camada12);
        parede1.adicionarCamada(camada13);
        
        Parede parede2 = new Parede();
        Camada camada21 = new Camada(altura, largura, 0.006f, "Ferro");
        Camada camada22 = new Camada(altura, largura, 0.0012f, "Cimento");
        Camada camada23 = new Camada(altura, largura, 0.0012f, "Tijolo");
        parede2.adicionarCamada(camada21);
        parede2.adicionarCamada(camada22);
        parede2.adicionarCamada(camada23);
        
        Parede parede3 = new Parede();
        Camada camada31 = new Camada(altura, largura, 0.006f, "Ferro");
        Camada camada32 = new Camada(altura, largura, 0.0012f, "Cimento");
        Camada camada33 = new Camada(altura, largura, 0.0012f, "Tijolo");
        parede3.adicionarCamada(camada31);
        parede3.adicionarCamada(camada32);
        parede3.adicionarCamada(camada33);
        
        Parede parede4 = new Parede();
        Camada camada41 = new Camada(altura, largura, 0.006f, "Ferro");
        Camada camada42 = new Camada(altura, largura, 0.0012f, "Cimento");
        Camada camada43 = new Camada(altura, largura, 0.0012f, "Tijolo");
        Janela janela41 = new Janela(1f, 1.5f, 0.0012f, "Vidro");
        Janela janela42 = new Janela(1f, 1.1f, 0.0012f, "Vidro");
        Porta porta41 =  new Porta(2f, 1f, 0.0012f, "Madeira");
        parede4.adicionarCamada(camada41);
        parede4.adicionarCamada(camada42);
        parede4.adicionarCamada(camada43);
        parede4.adicionarJanela(janela41);
        parede4.adicionarJanela(janela42);
        parede4.adicionarPorta(porta41);
        
        casa1.adicionarParede(parede1);
        casa1.adicionarParede(parede2);
        casa1.adicionarParede(parede3);
        casa1.adicionarParede(parede4);
        
        
        System.out.println(casa1.calculaResistenciaTermicaTotal());
        double resultado = 4.1145317E-6;
        assertEquals("CalculaResistenciaTermicaTotal", resultado, casa1.calculaResistenciaTermicaTotal(), 0.00001);
    }

    /**
     * Test of calculaFluxoCalor method, of class Casa.
     */
    @Test
    public void testCalculaFluxoCalor() {
        System.out.println("CalculaFluxoCalor");
        
        float tempExt = 30f;
        float tempInt = 20f;
        float tempSolo = 15f;
        float altura = 3f;
        float largura = 9f;
        float comprimento = 12f;
        
        Casa casa1=new Casa(tempExt, tempInt, tempSolo, altura, largura, comprimento);
        
        Materiais instance = Materiais.getInstance();
        instance.inserirMaterial("Ferro", 80.2F);
        instance.inserirMaterial("Cimento", 8.2F);
        instance.inserirMaterial("Tijolo", 10.2F);
        instance.inserirMaterial("Vidro", 15.2F);
        instance.inserirMaterial("Madeira", 5.2F);
        
        Parede parede1 = new Parede();
        Camada camada11 = new Camada(altura, largura, 0.006f, "Ferro");
        Camada camada12 = new Camada(altura, largura, 0.0012f, "Cimento");
        Camada camada13 = new Camada(altura, largura, 0.0012f, "Tijolo");
        parede1.adicionarCamada(camada11);
        parede1.adicionarCamada(camada12);
        parede1.adicionarCamada(camada13);
        
        Parede parede2 = new Parede();
        Camada camada21 = new Camada(altura, largura, 0.006f, "Ferro");
        Camada camada22 = new Camada(altura, largura, 0.0012f, "Cimento");
        Camada camada23 = new Camada(altura, largura, 0.0012f, "Tijolo");
        parede2.adicionarCamada(camada21);
        parede2.adicionarCamada(camada22);
        parede2.adicionarCamada(camada23);
        
        Parede parede3 = new Parede();
        Camada camada31 = new Camada(altura, largura, 0.006f, "Ferro");
        Camada camada32 = new Camada(altura, largura, 0.0012f, "Cimento");
        Camada camada33 = new Camada(altura, largura, 0.0012f, "Tijolo");
        parede3.adicionarCamada(camada31);
        parede3.adicionarCamada(camada32);
        parede3.adicionarCamada(camada33);
        
        Parede parede4 = new Parede();
        Camada camada41 = new Camada(altura, largura, 0.006f, "Ferro");
        Camada camada42 = new Camada(altura, largura, 0.0012f, "Cimento");
        Camada camada43 = new Camada(altura, largura, 0.0012f, "Tijolo");
        Janela janela41 = new Janela(1f, 1.5f, 0.0012f, "Vidro");
        Janela janela42 = new Janela(1f, 1.1f, 0.0012f, "Vidro");
        Porta porta41 =  new Porta(2f, 1f, 0.0012f, "Madeira");
        parede4.adicionarCamada(camada41);
        parede4.adicionarCamada(camada42);
        parede4.adicionarCamada(camada43);
        parede4.adicionarJanela(janela41);
        parede4.adicionarJanela(janela42);
        parede4.adicionarPorta(porta41);
        
        casa1.adicionarParede(parede1);
        casa1.adicionarParede(parede2);
        casa1.adicionarParede(parede3);
        casa1.adicionarParede(parede4);
        System.out.println(casa1.calculaFluxoCalor());
        double resultado =2430410.25;
        assertEquals("CalculaFluxoCalor", resultado, casa1.calculaFluxoCalor(), 0);
    }

    /**
     * Test of getParedes method, of class Casa.
     */
    @Test
    public void testGetParedes() {
    }

    /**
     * Test of getTempExterior method, of class Casa.
     */
    @Test
    public void testGetTempExterior() {
    }

    /**
     * Test of getTempInterior method, of class Casa.
     */
    @Test
    public void testGetTempInterior() {
    }
}