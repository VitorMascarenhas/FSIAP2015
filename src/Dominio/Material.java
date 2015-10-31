/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.*;

/**
 *
 * @author 1081320
 */
public class Material {
    
    private Map<String, Double> tipoMaterial = new Map<String, Double>();
    
    public Material() {
    }
    
    /**
     * Inserir um material e respectiva condutividade
     * @param nome
     * @param condutividade 
     */
    public void inserirMaterial(String nome, double condutividade) {
        tipoMaterial.put(nome, condutividade);
    }
    
    /**
     * Retorna a condutividade de um material
     * 
     * @param nome
     * @return a condutividade do material inserido por parametro
     */
    public double obterCondutividade(String nome) {
        return tipoMaterial.get(nome);
    }    
}