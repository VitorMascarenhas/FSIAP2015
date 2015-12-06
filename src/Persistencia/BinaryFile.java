/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Camada;
import Dominio.Casa;
import Dominio.Material;
import Dominio.Parede;
import Repositorios.Materiais;
import static UI.Main._gui;
import UI.Project;
import UI.StartSimulation;
import java.io.*; 
import java.util.*; 
import javax.swing.JDesktopPane;
/**
 *
 * @author joelalves
 */
public  class BinaryFile {
       public static void readFile(File file) throws IOException, ClassNotFoundException {
           try {
               //ObjectInputStream in = new ObjectInputStream (new FileInputStream("as.bin"));
              FileInputStream fileInput =new FileInputStream(file.getPath());
               ObjectInputStream in = new ObjectInputStream(fileInput);

               System.out.println("I have read:");
               
               ArrayList<Material> materiais = (ArrayList<Material>) in.readObject();
               for (Material m : materiais) {
                   Materiais.getInstance().inserirMaterial(m.getNomeMaterial(), m.obterCondutividade());
               }
               StartSimulation start = new StartSimulation();
               Object obj =  in.readObject();
               in.close();
               fileInput.close();
               if(obj instanceof Casa){
                   Casa c1 = (Casa) obj;
                   System.out.println(file.getName());
                   System.out.println(c1.getAlt());
                   System.out.println(c1.getLar());
                   System.out.println(c1.getAllParedes().size());
                   
                   start.preencheSimulacao(c1);
               }
               
               System.out.println("3");
               JDesktopPane desktop = _gui.getJDesktopPane();
               desktop.add(start);
               desktop.moveToFront(start);
               System.out.println("4");
               

           } catch (IOException io) {
               System.out.println("Error Open");
           } catch (ClassNotFoundException Not) {
               System.out.println("Error Not found file");
           }

        
    }
 
    public static void writeFile(Casa casa, File file) throws IOException {

        try {
            //create a stream chain with object stream at the top.
          FileOutputStream  fileout =  new FileOutputStream(file.getPath()+".bin");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            
            ArrayList<Material> materiais=Materiais.getInstance().getListMateriais();
            out.writeObject(materiais);
            
            
            System.out.println(casa.getAlt());
            System.out.println(casa.getLar());
            System.out.println(casa.getAllParedes().size());
            out.writeObject(casa);
            out.flush();
            out.close();
            fileout.flush();
            fileout.close();

        } catch (IOException io) {
            System.out.println("Error Save");
        }

        System.out.println("I have written:");

    }
    public static Casa ExemploCasa(){
    // ADICIONAR MATERIAIS AO REPOSITORIO
        Materiais.getInstance().inserirMaterial("Tijolo", 0.4f);
        Materiais.getInstance().inserirMaterial("Fibra de vidro", 0.046f);
        Materiais.getInstance().inserirMaterial("Ar", 0.026f);
        Materiais.getInstance().inserirMaterial("Madeira", 0.11f);
        Materiais.getInstance().inserirMaterial("Alumínio", 237f);
//        
//
//        // Tamanho da casa
        float altura = 3f;
        float largura = 8f;
        float comprimento = 12f;
        float temperaturaInterior = 20f;
        float temperaturaExterior = 35f;
        float temperaturaTerra = 15f;

        Parede pA = new Parede(largura, altura, 0.07f, "Tijolo");
        // Camada de tijolo de 7cm de espessura
//        Camada camadaATij = new Camada(largura, altura, 0.07f, "Tijolo");
//        // Camada de ar de 2cm de espessura
//        Camada camadaAAr = new Camada(altura, largura, 0.02f, "Ar");
//        // Camada de madeira de 2cm de espessura
//        Camada camadaAMadeira = new Camada(altura, largura, 0.02f, "Madeira");
//        pA.adicionarCamada(camadaATij);
//        pA.adicionarCamada(camadaAAr);
//        pA.adicionarCamada(camadaAMadeira);
        
        
        // parede b inicia com uma camada de 7cm de espessura
        Parede pB = new Parede(comprimento, altura, 0.07f, "Tijolo");
        // Camada de tijolo de 7cm de espessura
//        Camada camadaBTij = new Camada(largura, altura, 0.07f, "Tijolo");
//        // Camada de ar de 2cm de espessura
//        Camada camadaBAr = new Camada(altura, largura, 0.02f, "Ar");
//        // Camada de madeira de 2cm de espessura
//        Camada camadaBMadeira = new Camada(altura, largura, 0.02f, "Madeira");
//        pB.adicionarCamada(camadaBTij);
//        pB.adicionarCamada(camadaBAr);
//        pB.adicionarCamada(camadaBMadeira);
        
        Parede pC = new Parede();
        // Camada de tijolo de 7cm de espessura
        Camada camadaCTij = new Camada(largura, altura, 0.07f, "Tijolo");
        // Camada de ar de 2cm de espessura
//        Camada camadaCAr = new Camada(altura, largura, 0.02f, "Ar");
//        // Camada de madeira de 2cm de espessura
//        Camada camadaCMadeira = new Camada(altura, largura, 0.02f, "Madeira");
        pC.adicionarCamada(camadaCTij);
//        pC.adicionarCamada(camadaCAr);
//        pC.adicionarCamada(camadaCMadeira);
        
        
        Parede pD = new Parede();
        // Camada de tijolo de 7cm de espessura
        Camada camadaDTij = new Camada(largura, altura, 0.07f, "Tijolo");
        // Camada de ar de 2cm de espessura
//        Camada camadaDAr = new Camada(altura, largura, 0.02f, "Ar");
//        // Camada de madeira de 2cm de espessura
//        Camada camadaDMadeira = new Camada(altura, largura, 0.02f, "Madeira");
        pD.adicionarCamada(camadaDTij);
//        pD.adicionarCamada(camadaDAr);
//        pD.adicionarCamada(camadaDMadeira);
        
        // Teto com camada de 10cm de tijolo
        Parede teto = new Parede(largura, altura, 0.1f, "Tijolo");
        // Camada de fibra de vidro de 2cm de espessura
//        Camada camadaTFibra = new Camada(largura, comprimento, 0.02f, "Fibra de vidro");
//        // camada de madeira de 2cm de espessura
//        Camada camadaTMad = new Camada(largura, comprimento, 0.02f, "Madeira");
//        teto.adicionarCamada(camadaTFibra);
//        teto.adicionarCamada(camadaTMad);
        
        // criação do chão com uma camada de tijolo e uma camada de madeira
        Parede chao = new Parede(largura, comprimento, 0.1f, "Tijolo");
//        Camada camadaChaoMad = new Camada(largura, comprimento, 0.02f, "Madeira");

        Casa c1 = new Casa(15.0f, 30.0f, 15.0f,12f,14f,23f);
//        c1.adicionarParede(pA);
//        c1.adicionarParede(pB);
//        c1.adicionarParede(pC);
//        c1.adicionarParede(pD);
//        c1.adicionarParede(chao);
//        c1.adicionarParede(teto);
       
        return c1;
    }
}
