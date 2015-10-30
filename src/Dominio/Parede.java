/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author 1081320
 */
public class Parede {
    
    private ArrayList<Componente> componentes;
    private double altura;
    private double largura;
    
    public Parede() {
    }
    
    public Parede(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
        this.componentes.add(new Camada(altura, largura, double valResTer));
    }
    
    public double calculaResistenciaTermicaTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}