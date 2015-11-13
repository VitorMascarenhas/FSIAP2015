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

    private ArrayList<Parede> paredes;
    private float tempExterior;
    private float tempInterior;

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
            if(parede.getClass().isInstance(Parede.class)) {
                resistenciaTotal+=parede.calculaResistenciaTermicaTotal();
            }
        }
        return resistenciaTotal;
    }

    public float calculaFluxoCalor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    
}
