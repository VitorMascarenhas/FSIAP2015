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
import java.io.Serializable;

/**
 *
 * @author 11011_000
 */
public class FabricaComponentes  implements Serializable{

    public Componente getComponente(String componente, float altura, float largura, float espessura, String nomeMaterial) {

        if (componente.equalsIgnoreCase("Porta") || componente.equalsIgnoreCase("Door")) {
            return new Porta(altura, largura, espessura, nomeMaterial);
        } else if (componente.equalsIgnoreCase("Janela") || componente.equalsIgnoreCase("Window")) {
            return new Janela(altura, largura, espessura, nomeMaterial);
        } else if (componente.equalsIgnoreCase("Camada") || componente.equalsIgnoreCase("Layer")) {
            return new Camada(altura, largura, espessura, nomeMaterial);
        } else {
            return null;
        }
    }
}