/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Controlador.ExperienciaController;
import Dominio.*;
import controlador.*;
import Factorys.FabricaComponentes;
import Repositorios.Materiais;
import static UI.Main._gui;
import UI.StartSimulation;
import controlador.CriarComponenteControlador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author rekgnyz
 */
public class FromHTML {

    /*
     * Metodo que lê os materiais via HTML
     */
    public static void leMateriais(File f) throws FileNotFoundException, IOException {
//        File f ;
//        f = new File( fileName+".html" );
        try {
            Scanner in = new Scanner(f);

            if (f.getCanonicalPath().endsWith(".txt")) {
                while (in.hasNextLine()) {
                    String[] materialData = in.nextLine().split(";");
                    String nomeMaterial = materialData[0].trim().replace("-", " ");
                    String condutividade = materialData[1];
                    Materiais.getInstance().inserirMaterial(nomeMaterial, Float.parseFloat(condutividade));
                }

            } else {
                for (int i = 0; i < 3; i++) {
                    in.nextLine();
                }
                String frase = in.nextLine();
                if (frase.contains("<title>Lista Materiais</title>")) {
                    while (in.hasNextLine()) {
                        frase = in.nextLine();

                        if (frase.contains("<td>")) {
                            String vec[];
                            vec = frase.split("<td>");
                            vec = vec[1].split("</td>");
                            String nomeMaterial = vec[0];

                            frase = in.nextLine();
                            vec = frase.split("<td>");
                            vec = vec[1].split("</td>");
                            String condutividade = vec[0];

                            Materiais.getInstance().inserirMaterial(nomeMaterial, Float.parseFloat(condutividade));

                            System.out.println("Nome " + nomeMaterial + " - " + condutividade);

                        } else {
                            in.nextLine();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, Internacionalizacao.Idioma.BUNDLE.getString("FromHTML.notamaterialfile.text"));
                }
                in.close();
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, Internacionalizacao.Idioma.BUNDLE.getString("FromHTML.impossibletoopen.text"));
        }
    }

    /*
    *Metodo que lê a experiencia via html
     */
    public static void leExperiencia(File f) {
        Casa c1 = new Casa();
//        File f ;
//        f = new File( fileName+".html" );
        ExperienciaController ec = new ExperienciaController();
        String temperaturaExterior = "";
        String temperaturaInterior = "";
        String temperaturaSolo = "";
        String altura = "";
        String largura = "";
        String comprimento = "";

        String vec[];

        try {
            Scanner in = new Scanner(f);

            for (int i = 0; i < 3; i++) {
                in.nextLine();
            }
            String frase = in.nextLine();
            if (frase.contains("<title>Experiencia</title>")) {
                Casa.eliminarParedes();
                while (in.hasNextLine()) {
                    frase = in.nextLine();
                    if (frase.contains("Temperaturas") || frase.contains("Temperatures")) {

                        /*avança para a tempreatura interiror*/
                        for (int i = 0; i < 3; i++) {
                            in.nextLine();
                        }

                        frase = in.nextLine();
                        vec = frase.split("<td>");
                        vec = vec[1].split("</td>");
                        vec = vec[0].split("&");
                        temperaturaInterior = vec[0];
                        System.out.println("TI - " + temperaturaInterior);

                        /*avança para a tempreatura exterior*/
                        for (int i = 0; i < 3; i++) {
                            in.nextLine();
                        }
                        frase = in.nextLine();

                        vec = frase.split("<td>");
                        vec = vec[1].split("</td>");
                        vec = vec[0].split("&");
                        temperaturaExterior = vec[0];
                        System.out.println("TE - " + temperaturaExterior);

                        /*avança para a tempreatura solo*/
                        for (int i = 0; i < 3; i++) {
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
                    if (frase.contains("<h2>Dimens&otilde;es da casa</h2>") || frase.contains("<h2>House Dimensions</h2>")) {
                        /*posiciona na altura*/
                        for (int i = 0; i < 3; i++) {
                            in.nextLine();
                        }
                        frase = in.nextLine();
                        vec = frase.split("<td>");
                        vec = vec[1].split("</td>");
                        vec = vec[0].split("m");
                        altura = vec[0];

                        System.out.println("altura - " + altura);

                        /*posiciona na largura*/
                        for (int i = 0; i < 3; i++) {
                            in.nextLine();
                        }

                        frase = in.nextLine();
                        vec = frase.split("<td>");
                        vec = vec[1].split("</td>");
                        vec = vec[0].split("m");
                        largura = vec[0];

                        System.out.println("largura - " + largura);

                        /*posiciona no comprimento*/
                        for (int i = 0; i < 3; i++) {
                            in.nextLine();
                        }

                        frase = in.nextLine();
                        vec = frase.split("<td>");
                        vec = vec[1].split("</td>");
                        vec = vec[0].split("m");
                        comprimento = vec[0];

                        System.out.println("Comprimento - " + comprimento);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, Internacionalizacao.Idioma.BUNDLE.getString("FromHTML.notasimulationfile.text"));
            }
//            Casa.adicionarDimensoes(Float.parseFloat(altura), Float.parseFloat(largura), Float.parseFloat(comprimento));
//            Casa.adicionarTemperaturas(Float.parseFloat(temperaturaInterior), Float.parseFloat(temperaturaExterior), Float.parseFloat(temperaturaSolo));
            c1 = new Casa(Float.parseFloat(temperaturaInterior), Float.parseFloat(temperaturaExterior), Float.parseFloat(temperaturaExterior), Float.parseFloat(altura), Float.parseFloat(largura), Float.parseFloat(comprimento));
            leParede(f, c1);
               StartSimulation start = new StartSimulation();
               start.preencheSimulacao(c1);
               JDesktopPane desktop = _gui.getJDesktopPane();
               desktop.add(start);
               desktop.moveToFront(start);
            //return c1;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, Internacionalizacao.Idioma.BUNDLE.getString("FromHTML.impossibletoopen.text"));
        }
        //return c1;
    }

    /*
    * Metodo que prmite ler as paredes via html
     */
    public static void leParede(File f, Casa c1) throws FileNotFoundException {
        CriarComponenteControlador ccc = new CriarComponenteControlador();
        CriarParedeControlador cpc = new CriarParedeControlador();
        String tipoComponente = "";
        String area = "";
        String nomeMaterial = "";
        String espessura = "";
        String condutividade = "";
        String vec[];
        String alturaComponente;
        String larguraComponente;
        FabricaComponentes fab = new FabricaComponentes();

        Scanner in = new Scanner(f);
        int cont = 0;
        Parede p1 = new Parede();
        

        while (in.hasNextLine()) {
            String frase = in.nextLine();

            /*Importa informações da Parede*/
            if (frase.contains("<!--Parede-->")) {
                ArrayList<Componente> componentes = new ArrayList();
                System.out.println("PAREDE");
                for (int i = 0; i < 10; i++) {
                    in.nextLine();
                }
                while (!frase.contains("<!--FimParede-->")) {
                    
                    frase = in.nextLine();

                    //verifica se é camada janela ou porta
                    if (frase.contains("Camada") || frase.contains("Layer")) {
                        tipoComponente = "Camada";
                    }
                    if (frase.contains("Janela") || frase.contains("Window")) {
                        tipoComponente = "Janela";
                    }
                    if (frase.contains("Porta") || frase.contains("Door")) {
                        tipoComponente = "Porta";
                    }

                    //encontra a area
                    for (int i = 0; i < 5; i++) {
                        in.nextLine();
                    }
                    frase = in.nextLine();

                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("m");
                    area = vec[0];

                    //encontra a espessura
                    for (int i = 0; i < 3; i++) {
                        in.nextLine();
                    }
                    frase = in.nextLine();

                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("m");
                    espessura = vec[0];

                    //encontra o nome do material
                    for (int i = 0; i < 3; i++) {
                        in.nextLine();
                    }
                    frase = in.nextLine();
                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    nomeMaterial = vec[0];

                    //encontra a altura
                    for (int i = 0; i < 3; i++) {
                        in.nextLine();
                    }
                    frase = in.nextLine();
                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("m");
                    alturaComponente = vec[0];

                    //encontra a largura
                    for (int i = 0; i < 3; i++) {
                        in.nextLine();
                    }
                    frase = in.nextLine();
                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("m");
                    larguraComponente = vec[0];

                    //encontra a condutividade
                    for (int i = 0; i < 3; i++) {
                        in.nextLine();
                    }
                    frase = in.nextLine();
                    vec = frase.split("<td>");
                    vec = vec[1].split("</td>");
                    vec = vec[0].split("wm");
                    condutividade = vec[0];

                    System.out.println(tipoComponente + " " + area + " " + espessura + " " + alturaComponente + " " + larguraComponente + " " + nomeMaterial + " " + condutividade);

                    //cria o material e o componente
                    Materiais.getInstance().inserirMaterial(nomeMaterial, Float.parseFloat(condutividade));
                    componentes.add(ccc.criarComponente(tipoComponente, alturaComponente, larguraComponente, espessura, nomeMaterial));
                    //Terminou o componente
                    for (int i = 0; i < 6; i++) {
                        /*avança para o componente seguinte*/
                        in.nextLine();
                    }
                    frase = in.nextLine();

                    if (frase.contains("</table>")) {
                        /*entao ja terminou a aparede*/
                        System.out.println("FIM PAREDE");

                        p1 = new Parede(Float.parseFloat(alturaComponente), Float.parseFloat(larguraComponente), componentes);
                        cont++;
                        c1.adicionarParede(p1);
                        for (int i = 0; i < 2; i++) {
                            in.nextLine();
                        }
                        frase = in.nextLine();
                    }
                }
            }
        }
    }
}
