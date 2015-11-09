/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Dominio.Material;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author 11011_000
 */
public class Materiais {

    Map<String, Material> materiais = (Map<String, Material>) new HashMap();
    private static Materiais instancia = null;

    
    private Materiais() {
    }
    
    public static Materiais getInstance() {
        if(instancia==null) {
            instancia = new Materiais();
        }
        return instancia;
    }

        /**
     * Inserir um material e respectiva condutividade
     * @param nome
     * @param condutividade     
     */
    public void inserirMaterial(String nome, float condutividade) {
        materiais.put(nome.toUpperCase(), new Material(nome.toUpperCase(), condutividade));
    }
    
    
    public float obterCondutividade(String nomeMaterial) {
        return materiais.get(nomeMaterial.toUpperCase()).obterCondutividade();
    }

}
