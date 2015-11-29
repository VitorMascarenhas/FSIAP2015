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
    
    private static ArrayList<Parede> paredes = new ArrayList();
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
    public static void adicionarParede(Parede P, int index) {
        paredes.add(index, P);
    }
    
    public void adicionarParede(Parede P) {
        paredes.add(P);
    }
    
    public static float getResistenciaTotalParede(int index) {
        
        float resistenciaTotal = 0f;
        
        Parede prd = paredes.get(index);
        
        return resistenciaTotal = prd.calculaResistenciaTermicaTotal();
    }
    
    /**
     * @return a resistenciatotalTermica
     */ 
    public float calculaResistenciaTermicaTotal() {
        float resistenciaTotal = 0.0f;
        for(Parede parede : paredes) {
            
            resistenciaTotal+=parede.calculaResistenciaTermicaTotal();
            
        }
        
        return resistenciaTotal;
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

    /**
     * @return the comprimento
     */
    public float getComprimento() {
        return comprimento;
    }

    
}
