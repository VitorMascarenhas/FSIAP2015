/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Repositorios.Materiais;
/**
 *
 * @author 1081320
 */
public class Janela implements Componente {

    private float altura;
    private float largura;
    private float espessura;
    private String nomeMaterial;
    
    public Janela() {
    }
    
    public Janela(float altura, float largura, float espessura, String nomeMaterial) {
        this.altura = altura;
        this.largura = largura;
        this.espessura = espessura;
        this.nomeMaterial = nomeMaterial;
    }
    
    public Janela(float altura, float largura) {
        this.altura = altura;
        this.largura = largura;
    }
    
    @Override
    public float calculaResistenciaTermica() {
        return this.espessura/(this.calculaArea()*Materiais.getInstance().obterCondutividade(this.nomeMaterial));
    }
    
    @Override
    public float calculaArea() {
        return this.altura*this.largura;
    }
    
    public float getEspessura() {
        return espessura;
    }

    /**
     * @return the nomeMaterial
     */
    public String getNomeMaterial() {
        return nomeMaterial;
    }
    
    public String toString(){
        return "Janela - "+nomeMaterial;
    }
}