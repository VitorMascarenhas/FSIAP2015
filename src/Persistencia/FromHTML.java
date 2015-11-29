/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Camada;
import Dominio.Casa;
import Dominio.Componente;
import Dominio.Janela;
import Dominio.Material;
import Dominio.Parede;
import Dominio.Porta;
import Factorys.FabricaComponentes;
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
    public static Casa leExperiencia(File f){
//        File f ;
//        f = new File( fileName+".html" );
        String temperaturaExterior= "";
        String temperaturaInterior= "";
        String temperaturaSolo= "";
        String altura= "";
        String largura= "";
        String comprimento= "";
        
        String vec[];
        
        Casa c1;
        
        try {
            Scanner in = new Scanner( f );
            while ( in.hasNextLine() ){
                String frase = in.nextLine();
                if(frase.contains("Temperaturas")){
                    
                    /*avança para a tempreatura interiror*/
                    for(int i = 0; i < 3; i++){
                        in.nextLine();
                    }
                   
                    frase = in.nextLine();
                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("&");
                    temperaturaInterior = vec[0];
                    System.out.println("TI - " + temperaturaInterior);
                    
                    /*avança para a tempreatura exterior*/
                    for(int i = 0; i < 3; i++){
                        in.nextLine();
                    }
                    frase = in.nextLine();
                    
                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("&");
                    temperaturaExterior = vec[0];
                    System.out.println("TE - " + temperaturaExterior);
                    
                    /*avança para a tempreatura solo*/
                    for(int i = 0; i < 3; i++){
                        in.nextLine();
                    }
                    frase = in.nextLine();
                    
                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("&");
                    temperaturaSolo = vec[0];
                    System.out.println("TS - " + temperaturaSolo);
                    
                }
                /*Importa as dimensões da casa*/
                if(frase.contains("<h2>Dimens&otilde;es da casa</h2>")){
                    /*posiciona na altura*/
                    for(int i = 0; i< 3; i++){
                        in.nextLine();
                    }
                    frase=in.nextLine();
                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("m");
                    altura = vec[0];
                    
                    System.out.println("altura - " + altura);
                    
                    /*posiciona na largura*/
                    for(int i = 0; i< 3; i++){
                        in.nextLine();
                    }
                    
                    frase=in.nextLine();
                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("m");
                    largura = vec[0];
                    
                    System.out.println("largura - " + largura);
                 
                    /*posiciona no comprimento*/
                    for(int i = 0; i< 3; i++){
                        in.nextLine();
                    }
                    
                    frase=in.nextLine();
                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("m");
                    comprimento = vec[0];
                   
                    System.out.println("Comprimento - " + comprimento);
                }
            }
            c1 = new Casa(Float.parseFloat(temperaturaInterior), Float.parseFloat(temperaturaExterior), Float.parseFloat(temperaturaExterior), Float.parseFloat(altura), Float.parseFloat(largura), Float.parseFloat(comprimento));
            leParede(c1, f);
            return c1;
        } catch (FileNotFoundException ex) {
            System.out.println("Não foi possivel abrir o ficheiro");
            return null;
        }
    
    }
    
    
    public static void leParede(Casa c1, File f) throws FileNotFoundException{
        String tipoComponente = "";
        String area= "";
        String nomeMaterial= "";
        String espessura= "";
        String condutividade= "";
        String vec[];
        String alturaComponente;
        String larguraComponente;
        FabricaComponentes fab = new FabricaComponentes();
        
       Scanner in = new Scanner( f );
       int cont = 0;
       Parede p1 = new Parede();
        while ( in.hasNextLine() ){
            String frase = in.nextLine();

            
            /*Importa informações da Parede*/
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
                    vec = vec[0].split("m");
                    area = vec[0];

                    /*para encontrar a espessura*/
                    for(int i = 0; i< 3; i++){
                        in.nextLine();              //avança 3 linhas
                    }
                    frase = in.nextLine();

                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("m");
                    espessura = vec[0];

                    /*para encontrar o nome do material*/
                    for(int i = 0; i< 3; i++){
                        in.nextLine();              //avança 3 linhas
                    }
                    frase = in.nextLine();

                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    nomeMaterial = vec[0];

                    /*para encontrar a altura do componente*/
                    for(int i = 0; i< 3; i++){
                        in.nextLine();              //avança 3 linhas
                    }
                    frase = in.nextLine();

                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("m");
                    alturaComponente = vec[0];

                   /*para encontrar a largura do componente*/
                    for(int i = 0; i< 3; i++){
                        in.nextLine();              //avança 3 linhas
                    }
                    frase = in.nextLine();

                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("m");
                    larguraComponente = vec[0];



                    /*para encontrar a condutividade*/
                    for(int i = 0; i< 3; i++){
                        in.nextLine();              //avança 3 linhas
                    }
                    frase = in.nextLine();

                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("wm");
                    condutividade = vec[0];

                    System.out.println(tipoComponente + " " + area + " "+ espessura + " " + alturaComponente + " "+ larguraComponente + " " +nomeMaterial + " "+ condutividade );

                    /*cria o tipo de componente e adiciona a parede*/

                    if(tipoComponente.equalsIgnoreCase("Camada")){
                        p1.adicionarCamada((Camada) fab.getComponente(tipoComponente, Float.parseFloat(alturaComponente), Float.parseFloat(larguraComponente), Float.parseFloat(espessura), nomeMaterial));
                    }else if(tipoComponente.equalsIgnoreCase("Porta")){
                        p1.adicionarPorta((Porta) fab.getComponente(tipoComponente, Float.parseFloat(alturaComponente), Float.parseFloat(larguraComponente), Float.parseFloat(espessura), nomeMaterial));
                    }else if(tipoComponente.equalsIgnoreCase("Janela")){
                        p1.adicionarJanela((Janela) fab.getComponente(tipoComponente, Float.parseFloat(alturaComponente), Float.parseFloat(larguraComponente), Float.parseFloat(espessura), nomeMaterial));
                    }
                    /*TERMINOU COMPONENTE*/



                    for(int i = 0; i< 6; i++){      /*avança para o componente seguinte*/
                        in.nextLine();              //avança 7 linhas
                    }
                    frase= in.nextLine();

                    if(frase.contains("/table")){           /*entao ja terminou a aparede*/
                        System.out.println("PAREDE");
                        c1.adicionarParede(p1, cont);
                        cont++;
                        for(int i = 0; i< 2; i++){
                            in.nextLine();
                        }
                        frase = in.nextLine();
                    }                        
                }
            }
        }
    }
}
