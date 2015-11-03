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
public class MaterialTest {
    
    public MaterialTest() {
    }

    @Test
    public void testSomeMethod() {
    }

    /**
     * Test of inserirMaterial method, of class Material.
     */
    @Test
    public void testInserirMaterial() {
        Material material = Material.getInstance();
        String nome = "Ferro";
        double condutividade = 0.5;
        material.inserirMaterial(nome, condutividade);
        assertEquals(condutividade, material.obterCondutividade(nome));
    }

    /**
     * Test of obterCondutividade method, of class Material.
     */
    @Test
    public void testObterCondutividade() {
        Material material = Material.getInstance();
        String nome = "Ferro";
        double condutividade = 0.5;
        material.inserirMaterial(nome, condutividade);
        double condutividadeEsperada = 0.5;
        assertEquals(condutividadeEsperada, material.obterCondutividade(nome));
    }
}