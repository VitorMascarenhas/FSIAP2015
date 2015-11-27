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

    public CriarParedeControlador() {
        
        
    }
    
    public Parede criarParede(String altura, String largura, DefaultListModel<Componente> componentes) {
        
        // converte as strings dos botões para float
        float altPrd = Float.parseFloat(altura);
        float larPrd = Float.parseFloat(largura);
        
        ArrayList<Componente> compParede = new ArrayList<>();
        
        // preenche o arraylist com os objetos do JList
        for(int i = 0;i<componentes.size()-1;i++) {
            compParede.add(componentes.get(i));
        }
        
        // cria a parede com todos os componentes
        Parede parede = new Parede(altPrd, larPrd, compParede);
        
        return parede;
    }
    
}