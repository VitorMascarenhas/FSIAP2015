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
public class Camada implements Componente {
    
    private String tipoMaterial;
    private float altura;
    private float largura;
    private float espessura;
    
    public Camada() {
    }
    
    public Camada(float altura, float largura, float espessura, String material) {
        this.altura = altura;
        this.largura = largura;
        this.espessura = espessura;
        this.tipoMaterial = material;
    }
    //claculo da resistencia termica
    @Override
    public float calculaResistenciaTermica() {
        return this.espessura/(this.calculaArea()*Materiais.getInstance().obterCondutividade(this.tipoMaterial));
    }
    
    @Override
    public float calculaArea() {
        return this.getAltura()*this.getLargura();
    }
    
    public float calcularArea(boolean b, float valor) {
        
        float resistenciaTermica = 0f;
        
        if(b == true) {
            resistenciaTermica = this.altura*this.largura - valor;
        } else {
            resistenciaTermica = this.altura*this.largura;
        }
        return resistenciaTermica;
    }
    
    /**
     * @return the espessura
     */
    public float getEspessura() {
        return espessura;
    }

    /**
     * @return the tipoMaterial
     */
    public String getTipoMaterial() {
        return tipoMaterial;
    }
    
    public String toString(){
        return "Camada - "+tipoMaterial;
    }

    /**
     * @return the altura
     */
    public float getAltura() {
        return altura;
    }

    /**
     * @return the largura
     */
    public float getLargura() {
        return largura;
    }
}