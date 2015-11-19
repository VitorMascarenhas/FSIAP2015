/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import Persistencia.ToHTML;
import Repositorios.Materiais;
import java.io.FileNotFoundException;

/**
 *
 * @author E336170
 */
public class Main {
    
   private static Project _gui = null;
    
    public static void main(String[] args) throws FileNotFoundException {
       _gui = new Project();
       
       Materiais m = Materiais.getInstance();

       m.inserirMaterial("Madeira", (float) 1.25);
       m.inserirMaterial("Vidro", (float) 1.75);
       m.inserirMaterial("Plastico", (float) 1.35);
       
       ToHTML.exportMat("Materiais");
    }
}