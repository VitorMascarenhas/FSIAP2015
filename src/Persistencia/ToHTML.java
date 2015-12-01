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
    public static String exportExp(String nomeExperiencia){
        String html = prologo(nomeExperiencia);
        html+= imprimeResistenciaTermica();
        html+= imprimeTemperaturas();
        html+= imprimeDimensoes();
        html+= center();
        html+= epilogo();
        
//        try (Formatter fo = new Formatter (new File(nomeExperiencia+".html"))) {
//            fo.format(html);
//            fo.close();
//        }
        return html;
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
    public static String center(){
        String inicio="<h2>Composi&ccedil;&atilde;o da casa</h2>\n" +
                
            "<table>\n" +
            "  <tr>\n" +
            "    <th>Parede</th>\n" +
            "    <th>Componente</th>\n" +
            "  </tr>";
        
        String fim="</table>";
        
        String center="";
        int cont = 1;
        if(Casa.getParedes()!=null){
            for(Parede p : Casa.getParedes()){
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
                "                <td>Altura:</td>\n" +
                "                <td>"+ c.getAltura() +"m</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Largura:</td>\n" +
                "                <td>"+ c.getLargura() +"m</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Condutividade:</td>\n" +
                "                <td>"+Materiais.getInstance().obterCondutividade(c.getTipoMaterial())+"wm<sup>-1</sup>&deg;c<sup>-1</sup></td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "            <!--Fim informações camada camada-->\n" +
                "          </td>\n" +
                "          <td>" + c1.calculaResistenciaTermica() + "w<sup>-1</sup>&deg;c</td>\n" +
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
                "                <td>Altura:</td>\n" +
                "                <td>"+ c.getAltura() +"m</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Largura:</td>\n" +
                "                <td>"+ c.getLargura() +"m</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Condutividade:</td>\n" +
                "                <td>"+Materiais.getInstance().obterCondutividade(c.getNomeMaterial())+"wm<sup>-1</sup>&deg;c<sup>-1</sup></td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "            <!--Fim informações camada camada-->\n" +
                "          </td>\n" +
                "          <td>" + c1.calculaResistenciaTermica() + "w<sup>-1</sup>&deg;c</td>\n" +
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
                "                <td>Altura:</td>\n" +
                "                <td>"+ c.getAltura() +"m</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Largura:</td>\n" +
                "                <td>"+ c.getLargura() +"m</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Condutividade:</td>\n" +
                "                <td>"+Materiais.getInstance().obterCondutividade(c.getTipoMaterial())+"wm<sup>-1</sup>&deg;c<sup>-1</sup></td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "            <!--Fim informações camada camada-->\n" +
                "          </td>\n" +
                "          <td>" + c1.calculaResistenciaTermica() + "w<sup>-1</sup>&deg;c</td>\n" +
                "        </tr>\n"; 
        }
        return html;
    }
    
    /*
    *Metodo para imprimir as temperaturas
    */
    public static String imprimeTemperaturas(){
        String html="<h2>Temperaturas</h2>\n" +
            "<table>\n" +
            "  <tr>\n" +
            "    <td>Temperatura Interior:</td>\n" +
            "    <td>"+Casa.getTempInterior()+"&deg;C</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>Temperatura Exterior:</td>\n" +
            "    <td>"+Casa.getTempExterior()+"&deg;C</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>Temperatura Solo:</td>\n" +
            "    <td>"+Casa.getTempTerra()+"&deg;C</td>\n" +
            "  </tr>\n" +
            "</table>";
        
        return html;
    }
    
    /*
    *Metodo para imprimir as temperaturas
    */
    public static String imprimeDimensoes(){
        String html="<h2>Dimens&otilde;es da casa</h2>\n" +
            "<table>\n" +
            "  <tr>\n" +
            "    <td>Altura</td>\n" +
            "    <td>"+Casa.getAltura()+"m</td>\n" +
            "  </tr>\n" + 
            "  <tr>\n" +
            "    <td>Largura</td>\n" +
            "    <td>"+Casa.getLargura()+"m</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>Comprimento</td>\n" +
            "    <td>"+Casa.getComprimento()+"m</td>\n" +
            "  </tr>\n"+
            "</table>\n";
                
        return html;
    }
    
    /*Metodo para imprimir resistência térmica por parede*/
    public static String imprimeResistenciaTermica(){
        String inicio="<h2>Resultados</h2>\n" +
                "<h3>Fluxo calor</h3>" +
                Casa.calculaFluxoCalor()+"w" +
                "<h3>Resist&ecirc;ncia T&eacute;rmica Total</h3>" +
                Casa.calculaResistenciaTermicaTotal()+"w<sup>-1</sup>&deg;c" +
                "<h3>Resist&ecirc;ncia T&eacute;rmica por Parede</h3>" +
                "<table>\n" +
                "  <tr>\n" +
                "    <th>Parede</th>\n" +
                "    <th>Resist&ecirc;ncia T&eacute;rmica</th>\n" +
                "  </tr>\n";
        
        String html="";
        int cont = 1;
        for(Parede p: Casa.getParedes()){
            html+="  <tr>\n" +
                "    <td>"+cont+"</td>\n" +
                "    <td>"+p.calculaResistenciaTermicaTotal()+"w<sup>-1</sup>&deg;c</td>\n" +
                "  </tr>\n";
            cont++;
        }
                        
        String fim="</table>";

        return inicio+html+fim;
    }
    
    
    
    
    
    /*METODOS PARA EXPORTAR MATERIAIS*/ 
    public static String exportMat(){
        String html = imprimeMateriais();
        return html;
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