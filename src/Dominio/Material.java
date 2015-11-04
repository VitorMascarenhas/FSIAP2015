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
    
    private static Material instancia=new Material();
    
    private Map<String, Double> tipoMaterial = new HashMap<>();
    
    private Material() {
        this.tipoMaterial=null;
    }
    
    private Material(Map<String, Double> tiposMaterial) {
        this.tipoMaterial=tiposMaterial;
    }
    
    public static Material getInstance() {
        if(instancia==null)
            instancia=new Material();
        
        return instancia;
    }
    
    /**
     * Inserir um material e respectiva condutividade
     * @param nome
     * @param condutividade 
     */
    public void inserirMaterial(String nome, double condutividade) {
        this.tipoMaterial.put(nome, condutividade);
    }
    
    /**
     * Retorna a condutividade de um material
     * 
     * @param nome
     * @return a condutividade do material inserido por parametro
     */
    public double obterCondutividade(String nome) {
        
        double condutividade = this.tipoMaterial.get(nome);
        
        return condutividade;
    }    
}