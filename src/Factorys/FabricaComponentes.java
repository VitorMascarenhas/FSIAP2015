/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorys;

import Dominio.Camada;
import Dominio.Componente;
import Dominio.Janela;
import Dominio.Porta;

/**
 *
 * @author 11011_000
 */
public class FabricaComponentes {
    
    public Componente getComponente(String componente){
        
        if(componente.equalsIgnoreCase("Porta")) {
            return new Porta();
        } else if (componente.equalsIgnoreCase("Janela")) {
                return new Janela();
            } else if (componente.equalsIgnoreCase("Camada")) {
                return new Camada();
            } else {
                return null;
            }
    }

    
    
}
