/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author 1081320
 */
public class Material {
    
    private final String nomeMaterial;
    private final float condutividadeTermica;
       
    public Material(String nomeMaterial, float condutividadeTermica) {
        this.nomeMaterial=nomeMaterial;
        this.condutividadeTermica=condutividadeTermica;
    }
    
    /**
     * Retorna a condutividade de um material
     * 
     * @return a condutividade termica do material
     */
    public float obterCondutividade() {
        //System.out.println("Entrou no material");
        return condutividadeTermica;
    }
    
    @Override
    public String toString(){
        return getNomeMaterial() +" - " +condutividadeTermica;
    }

    /**
     * @return the nomeMaterial
     */
    public String getNomeMaterial() {
        return nomeMaterial;
    }
}