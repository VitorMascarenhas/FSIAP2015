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
public class Camada implements Componente {
    
    private String tipoMaterial;
    private Double altura;
    private Double largura;
    private Double espessura;
    
    public Camada(double altura, double largura, double espessura, double material) {
        this.altura = altura;
        this.largura = largura;
        this.espessura = espessura;
        this.tipoMaterial = tipoMaterial;
    }
    
    @Override
    public double calculaResistenciaTermica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public double calculaArea(double altura, double largura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}