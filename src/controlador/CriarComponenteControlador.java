/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Dominio.*;
import java.util.*;
import Factorys.*;
import Repositorios.Materiais;

/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public class CriarComponenteControlador {
    
    public CriarComponenteControlador() {
    }
    
    public Componente criarComponente(String nomeComponente, String altura, String largura, String espessura, String tipoMaterial) {
        float altCmp = Float.parseFloat(altura);
        float larCmp = Float.parseFloat(largura);
        float espCmp = Float.parseFloat(espessura);
        
        FabricaComponentes fab = new FabricaComponentes();
        
        return fab.getComponente(nomeComponente, altCmp, larCmp, espCmp, tipoMaterial);
    }
}