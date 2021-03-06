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
public class Janela implements Componente, Serializable{

    private float altura;
    private float largura;
    private float espessura;
    private String nomeMaterial;
    private float area;
    
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
    public void atualizarArea(float area) {
    }
    
    @Override
    public float calculaResistenciaTermica() {
        return Dominio.Termodinamica.CalculaResistenciaTermica(this);
    }
    
    @Override
    public float calculaArea() {
        return this.getAltura()*this.getLargura();
    }
    
    public float getEspessura() {
        return espessura;
    }
    
    @Override
    public String toString(){
        return Internacionalizacao.Idioma.BUNDLE.getString("Janela.window.text") + " - " + nomeMaterial + ": " + Materiais.getInstance().obterCondutividade(nomeMaterial) + " "+ Internacionalizacao.Idioma.BUNDLE.getString("Janela.height.text") +" "+altura+" "+ Internacionalizacao.Idioma.BUNDLE.getString("Janela.width.text") +" "+largura+" "+ Internacionalizacao.Idioma.BUNDLE.getString("Janela.thickness.text") +" "+espessura ;
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
    public String getTipoMaterial() {
        return nomeMaterial;
    }

    @Override
    public float getArea() {
        if(this.area!=0)
            return this.area;
        this.area=this.largura*this.altura;
        return this.area;
    }
}