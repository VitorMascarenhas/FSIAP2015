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
    
    public Parede(double altura, double largura, double espessuraCamada, String tipoMaterial) {
        this.altura = altura;
        this.largura = largura;
        this.componentes.add(new Camada(altura, largura, espessuraCamada, tipoMaterial));
    }

    public void adicionarCamada(Camada c) {
        
        this.componentes.add(c);
    
    }
    
    public void adicionarJanela(Janela j) {
        
        this.componentes.add(j);
    
    }
    
    public void adicionarPorta(Porta p) {
        
        this.componentes.add(p);
        
    }
    
    public double calculaResistenciaTermicaTotal() {
        
        double resistenciaTotal = 0.0;
        
        for(Componente comp : componentes) {
            resistenciaTotal += comp.calculaResistenciaTermica();
        }
        
        return resistenciaTotal;
    }
}