/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import Dominio.Casa;
import Dominio.Parede;
import Persistencia.BinaryFile;
import Persistencia.ToHTML;
import Repositorios.Materiais;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author E336170
 */
public class Main {
    
   private static Project _gui = null;
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
       _gui = new Project();
       
    }
}   