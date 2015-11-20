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
    
    public void criarExperiencia(float tempExt, float tempInt, float tempTerra , float altura, float largura, float comprimento) {
        Casa casa = new Casa(tempExt, tempInt, tempTerra, altura, largura, comprimento);
        
    }
}