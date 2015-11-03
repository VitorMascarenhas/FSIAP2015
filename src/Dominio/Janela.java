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
public class Janela implements Componente {

    private Double altura;
    private Double largura;
    private Double espessura;
    private double coefRes;
    private String nomeMaterial;
    
    public Janela() {
    }
    
    public Janela(double altura, double largura, double espessura, String nomeMaterial) {
        this.altura = altura;
        this.largura = largura;
        this.espessura = espessura;
        this.nomeMaterial = nomeMaterial;
    }
    
    public Janela(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }
    
    public Janela(double altura, double largura, double espessura, double coefRes) {
        this.altura = altura;
        this.largura = largura;
        this.espessura = espessura;
        this.coefRes = coefRes;
    }
    
    @Override
    public double calculaResistenciaTermica() {
        return this.espessura/(this.calculaArea()*this.coefRes);
    }
    
    @Override
    public double calculaArea() {
        return this.altura*this.largura;
    }
    
}