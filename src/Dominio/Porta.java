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
public class Porta implements Componente {

    private String tipoMaterial;
    private Double altura;
    private Double largura;
    private Double espessura;

    @Override
    public double calculaResistenciaTermica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public double calculaArea(double altura, double largura) {
        return altura*largura;
    }
}