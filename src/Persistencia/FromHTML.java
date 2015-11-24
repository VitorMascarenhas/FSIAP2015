/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Material;
import Repositorios.Materiais;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author rekgnyz
 */
public class FromHTML {
    public static void ReadMateriais(String fileName) throws FileNotFoundException{
        File f ;
        f = new File( fileName+".html" );
        try (Scanner in = new Scanner( f )) {
            while ( in.hasNextLine() ){
                String frase = in.nextLine();
                
                if(frase.contains("<td>")){
                    String vec[];
                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    String nomeMaterial = vec[0];

                    frase = in.nextLine();
                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    String condutividade = vec[0];
                    
                    Materiais.getInstance().inserirMaterial(nomeMaterial, Float.parseFloat(condutividade));

                    System.out.println("Nome " + nomeMaterial + " - " +condutividade);

                }else{
                    in.nextLine();
                }
            }
            in.close();
        }
    }
}
