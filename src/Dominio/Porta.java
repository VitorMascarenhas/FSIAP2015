/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Repositorios.Materiais;
import java.io.Serializable;
/**
 *
 * @author 1081320
 */
public class Porta implements Componente, Serializable {

    private String tipoMaterial;
    private float altura;
    private float largura;
    private float espessura;

    public Porta(float altura, float largura, float espessura, String material) {
        this.altura=altura;
        this.largura=largura;
        this.espessura=espessura;
        this.tipoMaterial= material;
    }

    public Porta() {
    }

    @Override
    public float calculaResistenciaTermica() {
        return this.espessura/(this.calculaArea()*Materiais.getInstance().obterCondutividade(this.tipoMaterial));
    }
    
    public void atualizarArea(float area) {
    }
    
    @Override
    public float calculaArea() {
        return this.getAltura() * this.getLargura();
    }
    
    public float getEspessura() {
        return espessura;
    }

    /**
     * @return the tipoMaterial
     */
    public String getTipoMaterial() {
        return tipoMaterial;
    }
    
    @Override
    public String toString(){
        return "Porta - "+ tipoMaterial;
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