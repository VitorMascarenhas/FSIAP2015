/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Dominio.Material;
import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author 11011_000
 */
public class Materiais implements Serializable{

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
    //TODO verificar se já exitem o material com o mesmo nome 
    public void inserirMaterial(String nome, float condutividade) {
        materiais.put(nome.toUpperCase(), new Material(nome.toUpperCase(), condutividade));
    }
    
    
    public float obterCondutividade(String nomeMaterial) {
        return materiais.get(nomeMaterial.toUpperCase().trim()).obterCondutividade();
    }
    
    public ArrayList<String> getNomesMateriais() {
        
        ArrayList<String> nomesMateriais = new ArrayList<>();
        for(Material mat : this.getListMateriais()) {
            nomesMateriais.add(mat.getNomeMaterial());
        }
        return nomesMateriais;
    }
    
    public ArrayList<Material> getListMateriais() {
        ArrayList<Material> mat = new ArrayList<Material>(materiais.values());
        return mat;
    }
    
    public String[] getListaDeMateriais(){
        String matList[] =  new String[materiais.size()];
        int cont = 0;
        for (Material m : materiais.values()) {
            String[] s = m.toString().split("-");
            matList[cont]=s[0];
            cont++;
        }
        for (String string : matList) {
            string.trim();
        }
        return matList;
    }
}