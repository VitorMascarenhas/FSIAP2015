/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Internacionalizacao;

import java.util.ResourceBundle;

/**
 *
 * @author 11011_000
 */
/* Classe para gerir BUNDLE que define idioma da aplicacao */
public class Idioma {
    
    public static ResourceBundle BUNDLE;
    
    public static Integer IDIOMA = 1; // - Idioma portugues por defeito
    
    public static void initBundle() {
        if (IDIOMA == 0) {  //0 - Portugues
            BUNDLE=ResourceBundle.getBundle("Internacionalizacao.Bundle_pt_PT");
        } else if (IDIOMA == 1) {   // 1 - Ingles
            BUNDLE=ResourceBundle.getBundle("Internacionalizacao.Bundle_en_EN");
        }
    }    
    
    public static void initBundle(int IDIOMA) {
        if (IDIOMA == 0) {  //0 - Portugues
            BUNDLE=ResourceBundle.getBundle("Internacionalizacao.Bundle_pt_PT");
        } else if (IDIOMA == 1) {   // 1 - Ingles
            BUNDLE=ResourceBundle.getBundle("Internacionalizacao.Bundle_en_EN");
        }
    }    

}
