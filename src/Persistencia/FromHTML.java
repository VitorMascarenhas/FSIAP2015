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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rekgnyz
 */
public class FromHTML {
    
    /*Leitura de Materiais via HTML*/
    public static void leMateriais(String fileName) throws FileNotFoundException{
        File f ;
        f = new File( fileName+".html" );
        try{
            Scanner in = new Scanner( f );
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
        } catch (FileNotFoundException ex) {
            System.out.println("Não foi possivel abrir o ficheiro");
        }
    }
    
    /*Lê experiencia*/
    public static void leExperiencia(String fileName){
        File f ;
        f = new File( fileName+".html" );
        String tipoComponente = "";
        String area;
        String nomeMaterial;
        String espessura;
        String condutividade;
        String temperaturaExterior;
        String temperaturaInterior;
        String temperaturaSolo;
        
        String vec[];
        
        
        
        try {
            Scanner in = new Scanner( f );
            while ( in.hasNextLine() ){
                String frase = in.nextLine();
                if(frase.contains("<div id = \"Parede\">")){
                    for(int i=0; i< 10; i++){               //Avança 10 linhas
                        in.nextLine();
                    }
                    while(!frase.contains("</div>")){
                        frase = in.nextLine();
                        /*Se for uma camada*/
                      
                            if(frase.contains("Camada")){tipoComponente = "Camada";}
                            if(frase.contains("Janela")){tipoComponente = "Janela";}
                            if(frase.contains("Porta")){tipoComponente = "Porta";}

                            /*para encontrar a Area*/
                            for(int i = 0; i < 5; i++){
                                in.nextLine();              //avança 5 linhas
                            }
                            frase = in.nextLine();

                            vec = frase.split("<td>");
                            vec = vec[1].split("</td>");
                            area = vec[0];

                            /*para encontrar a espessura*/
                            for(int i = 0; i< 3; i++){
                                in.nextLine();              //avança 3 linhas
                            }
                            frase = in.nextLine();

                            vec = frase.split("<td>");
                            vec = vec[1].split("</td>");
                            espessura = vec[0];

                            /*para encontrar o nome do material*/
                            for(int i = 0; i< 3; i++){
                                in.nextLine();              //avança 3 linhas
                            }
                            frase = in.nextLine();

                            vec = frase.split("<td>");
                            vec = vec[1].split("</td>");
                            nomeMaterial = vec[0];

                            /*para encontrar a condutividade*/
                            for(int i = 0; i< 3; i++){
                                in.nextLine();              //avança 3 linhas
                            }
                            frase = in.nextLine();

                            vec = frase.split("<td>");
                            vec = vec[1].split("</td>");
                            condutividade = vec[0];

                            System.out.println(tipoComponente + " " + area + " "+ espessura + " " +nomeMaterial + " "+ condutividade );


                            for(int i = 0; i< 6; i++){      /*avança para o componente seguinte*/
                                in.nextLine();              //avança 7 linhas
                            }
                            frase= in.nextLine();
                            
                            if(frase.contains("/table")){           /*entao ja terminou a aparede*/
                                for(int i = 0; i< 2; i++){
                                    in.nextLine();
                                }
                                frase = in.nextLine();
                            }
                            
                            
                        

                    }
                }
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Não foi possivel abrir o ficheiro");
        }
    
    }
}
