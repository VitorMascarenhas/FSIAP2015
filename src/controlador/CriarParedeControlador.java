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
    
    public void criarParede(String altura, String largura, DefaultListModel<Componente> componentes, int index) {
        
        System.out.println("Tamanho:" + componentes.size());
        
        // converte as strings dos botões para float
        float altPrd = Float.parseFloat(altura);
        float larPrd = Float.parseFloat(largura);
        
        ArrayList<Componente> compParede = new ArrayList<>();
        
        // preenche o arraylist com os objetos do JList
        for(int i = 0;i<componentes.size();i++) {
            compParede.add(componentes.get(i));
        }
        System.out.println("Tamanho array " + compParede.size());
        // cria a parede com todos os componentes
        Parede parede = new Parede(altPrd, larPrd, compParede);
        
        float areaPrd = altPrd*larPrd;
        float areaSomaPortasJanelas = 0f;
        
        for(Componente comp : parede.getComponentes()) {
            if(comp instanceof Porta || comp instanceof Janela) {
                areaSomaPortasJanelas+=comp.calculaArea();
                System.out.println("portas janelas " + areaSomaPortasJanelas);
            }
        }
        float areaFinal = areaPrd - areaSomaPortasJanelas;
        
        for(int i = 0; i < parede.getTamanho();i++) {
            if(parede.getComponente(i) instanceof Camada) {
                parede.getComponente(i).atualizarArea(areaFinal);
            }
        }
        
        System.out.println("parede " + areaPrd);
        
        Casa.adicionarParede(parede, index);
    }
}