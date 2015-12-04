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
        float areaPrd = altPrd*larPrd;
        
        ArrayList<Componente> compParede = new ArrayList<>();
        
        // preenche o arraylist com os objetos do JList
        for(int i = 0;i<componentes.size();i++) {
            compParede.add(componentes.get(i));
        }
        System.out.println("Tamanho array " + compParede.size());
        // cria a parede com todos os componentes
        Parede parede = new Parede(altPrd, larPrd, compParede);
        
        float areaSomaPortasJanelas = 0f;
        float areaFinal = 0f;
        
        for(Componente comp : parede.getComponentes()) {
            if(comp instanceof Porta || comp instanceof Janela) {
                areaSomaPortasJanelas+=comp.calculaArea();
                System.out.println("portas janelas " + areaSomaPortasJanelas);
            }
        }
        
        areaFinal = areaPrd - areaSomaPortasJanelas;
        System.out.println("areaFinal " + areaFinal + " areaparede " + areaPrd + " areasomapj " + areaSomaPortasJanelas);
        
        for(int i = 0; i < parede.getTamanho();i++) {
            if(parede.getComponente(i) instanceof Camada) {
                parede.getComponente(i).atualizarArea(areaFinal);
                Camada camada = (Camada)parede.getComponente(i);
                System.out.println("area: " + camada.getArea());
            }
        }
        
        System.out.println("parede " + areaPrd);
        
        Casa.adicionarParede(parede, index);
    }
    
    public void criarParede(String altura, String largura, ArrayList<Componente> componentes, int index) {
        
        System.out.println("Tamanho:" + componentes.size());
        
        // converte as strings dos botões para float
        float altPrd = Float.parseFloat(altura);
        float larPrd = Float.parseFloat(largura);
        float areaPrd = altPrd*larPrd;
        

        System.out.println("Tamanho array " + componentes.size());
        // cria a parede com todos os componentes
        Parede parede = new Parede(altPrd, larPrd, componentes);
        
        float areaSomaPortasJanelas = 0f;
        float areaFinal = 0f;
        
        for(Componente comp : parede.getComponentes()) {
            if(comp instanceof Porta || comp instanceof Janela) {
                areaSomaPortasJanelas+=comp.calculaArea();
                System.out.println("portas janelas " + areaSomaPortasJanelas);
            }
        }
        
        areaFinal = areaPrd - areaSomaPortasJanelas;
        System.out.println("areaFinal " + areaFinal + " areaparede " + areaPrd + " areasomapj " + areaSomaPortasJanelas);
        
        for(int i = 0; i < parede.getTamanho();i++) {
            if(parede.getComponente(i) instanceof Camada) {
                parede.getComponente(i).atualizarArea(areaFinal);
                Camada camada = (Camada)parede.getComponente(i);
                System.out.println("area: " + camada.getArea());
            }
        }
        
        System.out.println("parede " + areaPrd);
        
        Casa casa = new Casa();
        
        casa.adicionarParede(parede, index);
    }
}