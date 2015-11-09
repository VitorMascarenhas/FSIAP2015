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

    public Porta(Double altura, Double largura, Double espessura) {
        this.altura=altura;
        this.largura=largura;
        this.espessura=espessura;
    }

    public Porta() {
    }

    @Override
    public double calculaResistenciaTermica() {
        return this.espessura/(this.calculaArea()); //Incompleto: A área tem de ser multiplicada pela "condutividade" 
    }

    @Override
    public double calculaArea() {
        return this.altura * this.largura;
    }
    
    public Double getEspessura() {
        return espessura;
    }

    /**
     * @return the tipoMaterial
     */
    public String getTipoMaterial() {
        return tipoMaterial;
    }
}
