/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;
import javax.swing.JApplet;
import Factorys.FabricaComponentes;

/**
 *
 * @author 1081320
 */
public class Parede {
    
    private ArrayList<Componente> componentes;
    private float altura;
    private float largura;
    private FabricaComponentes fabrica = new FabricaComponentes();
    
    public Parede() {
        this.componentes = new ArrayList<>();
    }
    
    public Parede(float altura, float largura, float espessuraCamada, String tipoMaterial) {
        this.componentes = new ArrayList<>();
        this.altura = altura;
        this.largura = largura;
        this.componentes.add(fabrica.getComponente("Camada", altura, largura, espessuraCamada, tipoMaterial));
    }
    
    public Parede(float altura, float largura, ArrayList<Componente> componentes) {
        this.altura = altura;
        this.largura = largura;
        this.componentes = componentes;
    }
    
    private float calcularAreaParede() {
        return this.altura*this.largura;
    }
    
    public void adicionarCamada(Camada c) {
        //System.out.println("Espessura: "+c.getEspessura());
        this.componentes.add((Componente)c);
    
    }
    
    public void adicionarJanela(Janela j) {
        
        this.componentes.add(j);
    
    }
    
    public void adicionarPorta(Porta p) {
        
        this.componentes.add(p);
        
    }
    
    public float calculaResistenciaTermicaTotal() {
        
        float resistenciaTotal = 0.0f;
        
        if(this.contemJanela() || this.contemPorta()) {
            for(Componente compo : this.componentes) {
                resistenciaTotal+=(1/compo.calculaResistenciaTermica());
            }
            return 1/resistenciaTotal;
        } else {
            for(Componente comp : componentes) {
                resistenciaTotal += comp.calculaResistenciaTermica();
            }
        }
        return resistenciaTotal;
    }
    
    private float calculaSomaAreasPortasJanelas() {
        
        float resultado = 0;
        
        for(Componente comp : componentes) {
            if(comp.getClass().isInstance(Janela.class) || comp.getClass().isInstance(Porta.class)) {
                resultado+=comp.calculaArea();
            }
        }
        return resultado;
    }
    
    private boolean verificaAreasParedeMaior() {
        
        float areaParede = calcularAreaParede();
        float areaPortasJanelas = calculaSomaAreasPortasJanelas();
        
        if(areaPortasJanelas > areaParede) {
            javax.swing.JOptionPane.showMessageDialog(null, "A soma das areas das portas e janelas não pode ser maior do qie a area da parede:");
            return false;
        } else {
            return true;
        }
    }
    
    private boolean contemJanela() {
        
        for(Componente comp : componentes) {
            if(comp.getClass().isInstance(Janela.class)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean contemPorta() {
        
        for(Componente comp : componentes) {
            if(comp.getClass().isInstance(Porta.class)) {
                return true;
            }
        }
        return false;
    }
    
    public void removerComponente(Componente comp) {
        
        for(Componente c : componentes) {
            if(c.equals(comp)) {
                this.componentes.remove(c);
            }
        }
    }
    
    /**
     * @return the componentes
     */
    public ArrayList<Componente> getComponentes() {
        return componentes;
    }
}
