/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.*;
import javax.swing.*;
import Dominio.*;
import java.util.*;
/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public class CriarParedeControlador {

    public CriarParedeControlador(float altura, float largura, DefaultListModel<Componente> componentes) {
        
        ArrayList<Componente> compParede = new ArrayList<>();
        
        for(int i = 0;i<componentes.size()-1;i++) {
            compParede.add(componentes.get(i));
        }
        
        Parede parede = new Parede(altura, largura, compParede);
        
    }
    
    
    
}