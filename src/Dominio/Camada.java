/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
/**
 *
 * @author 1081320
 */
public class Camada implements Componente, Serializable {
    
    private String tipoMaterial;
    private float altura;
    private float largura;
    private float espessura;
    private float area;
    
    public Camada() {
    }
    
    public Camada(float altura, float largura, float espessura, String material) {
        this.altura = altura;
        this.largura = largura;
        this.espessura = espessura;
        this.tipoMaterial = material;
        this.calculaArea();
    }
    
    //claculo da resistencia termica
    @Override
    public float calculaResistenciaTermica() {
        return Dominio.Termodinamica.CalculaResistenciaTermica(this);
    }
    
    @Override
    public float calculaArea() {
        this.area = this.getAltura()*this.getLargura();
        return this.area;
    }
    
    @Override
    public void atualizarArea(float area) {
        this.area = area;
    }
    
    /**
     * @return the espessura
     */
    @Override
    public float getEspessura() {
        return espessura;
    }

    /**
     * @return the tipoMaterial
     */
    @Override
    public String getTipoMaterial() {
        return tipoMaterial;
    }
    
    public String toString(){
        return "Camada - " + tipoMaterial +" Altura - "+altura+" Lrrgura - "+largura+" Espessura - "+espessura ;
    }
    
    public float getArea() {
        return this.area;
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
