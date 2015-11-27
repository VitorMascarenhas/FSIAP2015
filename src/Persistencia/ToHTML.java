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
import Repositorios.Materiais;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author rekgnyz
 */
public class ToHTML {
    /*METoDOS PARA EXPORTAR EXPERIENCIA*/
    public static void exportExp(String nomeExperiencia, Casa c1) throws FileNotFoundException{
        try (Formatter fo = new Formatter (new File(nomeExperiencia+".html"))) {
            String html = prologo(nomeExperiencia);
            html+= imprimeResistenciaTermica(c1);
            html+= imprimeTemperaturas(c1);
            html+= center(c1);
            html+= epilogo();
            fo.format(html);
            fo.close();
        }
    }
    
    
    /*Método com o topo do html*/
    public static String prologo(String nomeExperiencia){
        String prologo = "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<title>"+nomeExperiencia+"</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<img src=\"imgs\\isep.png\"/>";
        
        return prologo;
    }
    
    /*Método com o fim do html*/
    public static String epilogo(){
        String epilogo = "<h3>Desenvolvido por:<h3>\n" +
            "<h4>1060708 - Eduardo Silva | 1081320 Jo&atilde;o Sardon | 1100912 - Nuno Lemos | 1101153 - Andr&eacute; Teixeira | 111073 - Joel Alves | 1120035 - V&iacute;tor Mascarenhas<h4>\n" +
            "</body>\n" +
            "</html>";
        return epilogo;
    }
    
    
    /*Metodo que estrutura o html/tabel para as paredes e componentes*/
    public static String center(Casa c1){
        String inicio="<h2>Composi&ccedil;&atilde;o da casa</h2>\n" +
            "<table>\n" +
            "  <tr>\n" +
            "    <th>Parede</th>\n" +
            "    <th>Componente</th>\n" +
            "  </tr>";
        
        String fim="</table>";
        
        String center="";
        int cont = 1;
        if(c1.getParedes()!=null){
            for(Parede p :c1.getParedes()){
                center+=imprimeParede(p, cont);
                cont++;
            }
        }
  
        return inicio+center+fim;
    }
    
    /*
    *Metodo que imprime as informações contidas em cada parede
    */
    public static String imprimeParede(Parede p1, int indice){
        String inicio="\n<div id = \"Parede\">\n" +    
            "<tr>\n" +
            "    <td>"+indice+"</td>\n" +
            "    <td>\n" +
            "      <table>\n" +
            "        <tr>\n" +
            "          <th>Tipo</th>\n" +
            "          <th>Especifica&ccedil;&otilde;es</th>\n" +
            "          <th>Resist&ecirc;ncia T&eacute;rmica Componente</th>\n" +
            "        </tr>";
        
        String fim="      </table>\n" +
            "    </td>\n"+
            "</tr>\n"+
            "</div>";
        
        String comp="\n";
        for(Componente c : p1.getComponentes()){
            comp+= imprimeComponentes(c);
        }
        return inicio+comp+fim;
    }
    
    
    /*
    *   Metodo que imprime as informações de cada componente, existente na parede
    */
    public static String imprimeComponentes(Componente c1){
        String html="";
        if(c1 instanceof Camada ){
            Camada c = (Camada) c1;
              html+="        <tr>\n" +
                "          <td>Camada</td>\n" +
                "          <td>\n" +
                "            <!--informações da camada-->\n" +
                "            <table>\n" +
                "              <tr>\n" +
                "                <td>&Aacute;rea:</td>\n" +
                "                <td>"+ c1.calculaArea() +"m</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Espessura:</td>\n" +
                "                <td>"+ c.getEspessura() +"m</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Nome Material:</td>\n" +
                "                <td>"+ c.getTipoMaterial() +"</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Condutividade:</td>\n" +
                "                <td>"+Materiais.getInstance().obterCondutividade(c.getTipoMaterial())+"</td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "            <!--Fim informações camada camada-->\n" +
                "          </td>\n" +
                "          <td>" + c1.calculaResistenciaTermica() + "</td>\n" +
                "        </tr>\n";    
        }else if(c1 instanceof Janela){
            Janela c = (Janela) c1;
              html+="        <tr>\n" +
                "          <td>Janela</td>\n" +
                "          <td>\n" +
                "            <!--informações da camada-->\n" +
                "            <table>\n" +
                "              <tr>\n" +
                "                <td>&Aacute;rea:</td>\n" +
                "                <td>"+ c1.calculaArea() +"m</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Espessura:</td>\n" +
                "                <td>"+ c.getEspessura() +"m</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Nome Material:</td>\n" +
                "                <td>"+ c.getNomeMaterial() +"</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Condutividade:</td>\n" +
                "                <td>"+Materiais.getInstance().obterCondutividade(c.getNomeMaterial())+"</td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "            <!--Fim informações camada camada-->\n" +
                "          </td>\n" +
                "          <td>" + c1.calculaResistenciaTermica() + "</td>\n" +
                "        </tr>\n"; 
        }else{
            Porta c = (Porta) c1;
              html+="        <tr>\n" +
                "          <td>Porta</td>\n" +
                "          <td>\n" +
                "            <!--informações da camada-->\n" +
                "            <table>\n" +
                "              <tr>\n" +
                "                <td>&Aacute;rea:</td>\n" +
                "                <td>"+ c1.calculaArea() +"m</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Espessura:</td>\n" +
                "                <td>"+ c.getEspessura() +"m</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Nome Material:</td>\n" +
                "                <td>"+ c.getTipoMaterial() +"</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Condutividade:</td>\n" +
                "                <td>"+Materiais.getInstance().obterCondutividade(c.getTipoMaterial())+"</td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "            <!--Fim informações camada camada-->\n" +
                "          </td>\n" +
                "          <td>" + c1.calculaResistenciaTermica() + "</td>\n" +
                "        </tr>\n"; 
        }
        return html;
    }
    
    /*
    *Metodo para imprimir as temperaturas
    */
    public static String imprimeTemperaturas(Casa c1){
        String html="<h2>Temperaturas</h2>\n" +
            "<table>\n" +
            "  <tr>\n" +
            "    <td>Temperatura Interior:</td>\n" +
            "    <td>"+c1.getTempInterior()+"&deg;C</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>Temperatura Exterior:</td>\n" +
            "    <td>"+c1.getTempExterior()+"&deg;C</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>Temperatura Solo:</td>\n" +
            "    <td>"+c1.getTempTerra()+"&deg;C</td>\n" +
            "  </tr>\n" +
            "</table>";
        
        return html;
    }
    
    /*Metodo para imprimir resistência térmica por parede*/
    public static String imprimeResistenciaTermica(Casa c1){
        String inicio="<h2>Resultados</h2>\n" +
                "<h3>Fluxo</h3>" +
                "<h4>Falta implementar</h4>" +
                "<h3>Resist&ecirc;ncia T&eacute;rmica por Parede</h3>" +
                "<table>\n" +
                "  <tr>\n" +
                "    <th>Parede</th>\n" +
                "    <th>Resist&ecirc;ncia T&eacute;rmica</th>\n" +
                "  </tr>\n";
        
        String html="";
        int cont = 1;
        for(Parede p: c1.getParedes()){
            html+="  <tr>\n" +
                "    <td>"+cont+"</td>\n" +
                "    <td>"+p.calculaResistenciaTermicaTotal()+"</td>\n" +
                "  </tr>\n";
            cont++;
        }
                        
        String fim="</table>";

        return inicio+html+fim;
    }
    
    
    
    
    /*METODOS PARA EXPORTAR MATERIAIS*/ 
    public static void exportMat(String nomeFicheiro) throws FileNotFoundException{
        try (Formatter fo = new Formatter (new File(nomeFicheiro+".html"))) {
            String html = imprimeMateriais();
            fo.format(html);
            fo.close();
        }
    }
    
    
    /*Metodo que cria o html para ser exportado*/
    public static String imprimeMateriais(){
        String html = "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "<title>Lista Materiais</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h2>Lista de materiais</h2>\n<br>\n" +
                        "<table>\n" +
                        "  <tr>\n" +
                        "    <th>Nome</th>\n" +
                        "    <th>Condutividade</th>\n" +
                        "  </tr>\n";
        
        for(Material m: Materiais.getInstance().getListMateriais()){
            html +=  "  <tr>\n" +
                        "    <td>"+ m.getNomeMaterial()+"</td>\n" +
                        "    <td>"+ m.obterCondutividade()+"</td>\n" +
                        "  </tr>\n";
        }
        
        html+= "</table>\n" +
                    "</body>\n" +
                    "</html>";
        
        return html;
    }
    
    


}
