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
    
    @Override
    public float calculaResistenciaTermica() {
        return altura*largura;
    }
    
    @Override
    public float calculaArea() {
        return this.altura*this.largura;
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
}