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
public class Casa {

    private ArrayList<Parede> paredes = new ArrayList();
    private float tempExterior;
    private float tempInterior;
    private float tempTerra;
    private float altura;
    private float largura;
    private float comprimento;
    
    public Casa(float interior, float exterior, float tempTerra, float altura, float largura, float comprimento){
        this.tempInterior=interior;
        this.tempExterior=exterior;
        this.tempTerra = tempTerra;
        this.altura=altura;
        this.largura=largura;
        this.comprimento=comprimento;
    }
    
    /**
     *  Adiciona Parede
     */     
    public void adicionarParede(Parede P) {
        this.paredes.add(P);
    }
    /**
     * @return a resistenciatotalTermica
     */ 
    public float calculaResistenciaTermicaTotal() {
        float resistenciaTotal = 0.0f;
        for(Parede parede : paredes) {
            
            resistenciaTotal+=(1/parede.calculaResistenciaTermicaTotal());
            
        }
        
        return 1/resistenciaTotal;
    }

    public float calculaFluxoCalor() {
        float fluxoCalor;
        fluxoCalor = Math.abs(tempExterior-tempInterior)/this.calculaResistenciaTermicaTotal();
        return fluxoCalor;
    }

    /**
     * @return the paredes
     */
    public ArrayList<Parede> getParedes() {
        return paredes;
    }

    /**
     * @return the tempExterior
     */
    public float getTempExterior() {
        return tempExterior;
    }

    /**
     * @return the tempInterior
     */
    public float getTempInterior() {
        return tempInterior;
    }

    /**
     * @return the tempTerra
     */
    public float getTempTerra() {
        return tempTerra;
    }

    
}
