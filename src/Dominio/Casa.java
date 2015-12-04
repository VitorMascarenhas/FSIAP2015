/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 1081320
 */
public class Casa implements Serializable{
    
    private static ArrayList<Parede> paredes = new ArrayList();
    private static float tempExterior;
    private static float tempInterior;
    private static float tempTerra;
    private static float altura;
    private static float largura;
    private static float comprimento;
    private Parede chão;
    
    public Casa() {
        this.paredes = new ArrayList<>();
    }
    
    public Casa(float interior, float exterior, float tempTerra, float altura, float largura, float comprimento){
        this.tempInterior=interior;
        this.tempExterior=exterior;
        this.tempTerra = tempTerra;
        this.altura=altura;
        this.largura=largura;
        this.comprimento=comprimento;
    }
    //clone casa
    public Casa(Casa casa){
        this.paredes = new ArrayList<>();
        this.tempInterior=casa.getTemperaturaInterior();
        this.tempExterior=casa.getTemperaturaExterior();
        this.tempTerra = casa.getTemperaturaTerra();
        this.altura=casa.getAlt();
        this.largura=casa.getLar();
        this.comprimento=casa.getCompr();
        
        
    }
    
    /**
     *  Adiciona Parede
     */
    public static void adicionarParede(Parede P, int index) {
        paredes.add(index, P);
    }
    
    public static void eliminarParedes() {
        paredes.clear();
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
    public static float calculaResistenciaTermicaTotal() {
        float resistenciaTotal = 0.0f;
        for(Parede parede : paredes) {
            
            resistenciaTotal+=parede.calculaResistenciaTermicaTotal();
            
        }
        
        return resistenciaTotal;
    }

    public static float calculaFluxoCalor() {
        float fluxoCalor;
        fluxoCalor = Math.abs(tempExterior-tempInterior)/calculaResistenciaTermicaTotal();
        return fluxoCalor;
    }
    
    /**
     * @return the paredes
     */
    public static ArrayList<Parede> getParedes() {
        return paredes;
    }
    
    public  ArrayList<Parede> getAllParedes() {
        return paredes;
    }

    /**
     * @return the tempExterior
     */
    public static float getTempExterior() {
        return tempExterior;
    }
    
    public float getTemperaturaExterior(){
         return tempExterior;
    }

    /**
     * @return the tempInterior
     */
    public static float getTempInterior() {
        return tempInterior;
    }
    
    public  float getTemperaturaInterior() {
        return tempInterior;
    }
    /**
     * @return the tempTerra
     */
    public static float getTempTerra() {
        return tempTerra;
    }
    
    public  float getTemperaturaTerra() {
        return tempTerra;
    }
    /**
     * @return the altura
     */
    public static float getAltura() {
        return altura;
    }
    
    public float getAlt() {
        return altura;
    }
    /**
     * @return the largura
     */
    public static float getLargura() {
        return largura;
    }
    
    public  float getLar() {
        return largura;
    }
    /**
     * @return the comprimento
     */
    public static float getComprimento() {
        return comprimento;
    }
    public  float getCompr() {
        return comprimento;
    }
    
   
    
    public void setTemperaturaInterior(float tempInterior) {
        this.tempInterior = tempInterior;
    }
    
    public void setTemperaturaExterior(float temperaturaExterior) {
        this.tempExterior = temperaturaExterior;
    }
    
    public void setTemperaturaTerra(float temperaturaTerra) {
        this.tempTerra = temperaturaTerra;
    }
    
    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    public void setLargura(float largura) {
        this.largura = largura;
    }
    
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }
    
}