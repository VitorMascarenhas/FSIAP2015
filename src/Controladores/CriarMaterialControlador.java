/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Dominio.Material;

/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public class CriarMaterialControlador {
    
    public CriarMaterialControlador() {
    }
    
    public void criarMaterial(String nomeMaterial, double valorCondutividade) {
        Material material = new Material();
        material.inserirMaterial(nomeMaterial, valorCondutividade);
    }
}