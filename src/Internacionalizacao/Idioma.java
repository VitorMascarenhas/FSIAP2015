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
public class Idioma {

    public static ResourceBundle BUNDLE;
    
    public static Integer LANGUAGE = 0;
    
    public static void initBundle() {
        if (LANGUAGE == 0) {
            BUNDLE=ResourceBundle.getBundle("Internacionalizacao.Bundle_pt_PT");
        } else if (LANGUAGE == 1) {
            BUNDLE=ResourceBundle.getBundle("Internacionalizacao.Bundle_en_US");
        }
    }    

}
