/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dominio.Casa;

/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public class ExperienciaController {
    
    public ExperienciaController() {
    }
    
    public void criarExperiencia(String tempExt, String tempInt, String tempTerra, String altura, String largura, String comprimento) {
        
        float alturaCasa = Float.parseFloat(altura);
        float larguraCasa = Float.parseFloat(altura);
        float comprimentoCasa = Float.parseFloat(comprimento);
        float tempExtCasa = Float.parseFloat(tempExt);
        float tempIntCasa = Float.parseFloat(tempInt);
        float tempTerraCasa = Float.parseFloat(tempTerra);
        Casa casa = new Casa(tempExtCasa, tempIntCasa, tempTerraCasa, alturaCasa, larguraCasa, comprimentoCasa);
    }
}