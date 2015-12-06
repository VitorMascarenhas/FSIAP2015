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
    private float area;

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
        return Dominio.Termodinamica.CalculaResistenciaTermica(this);
    }
    
    @Override
    public void atualizarArea(float area) {
    }
    
    @Override
    public float calculaArea() {
        return this.getAltura() * this.getLargura();
    }
    
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
    
    @Override
    public String toString(){
        return Internacionalizacao.Idioma.BUNDLE.getString("Porta.door.text") + " - " + tipoMaterial + ": " + Materiais.getInstance().obterCondutividade(tipoMaterial) + " "+ Internacionalizacao.Idioma.BUNDLE.getString("Porta.height.text") +" "+altura+" "+ Internacionalizacao.Idioma.BUNDLE.getString("Porta.width.text") +" "+largura+" "+ Internacionalizacao.Idioma.BUNDLE.getString("Porta.thickness.text") +" "+espessura ;
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
    
    @Override
    public float getArea() {
        if(this.area!=0)
            return this.area;
        this.area=this.largura*this.altura;
        return this.area;
    }
}