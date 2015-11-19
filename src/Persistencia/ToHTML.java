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
    /*METDOS PARA EXPORTAR EXPERIENCIA*/
    public static void exportExp(String nomeExperiencia, Casa c1) throws FileNotFoundException{
        try (Formatter fo = new Formatter (new File(nomeExperiencia+".html"))) {
            String html = prologo(nomeExperiencia);
            html+= imprimeTemperaturas(c1);
            html+= center(c1);
            html+= epilogo();
            fo.format(html);
            fo.close();
        }
    }
    
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
    
    public static String epilogo(){
        String epilogo = "<h4>Desenvolvido por:<h4>\n" +
            "<h5>1060708 - Eduardo Silva | 1081320 Jo&atilde;o Sardon | 1100912 - Nuno Lemos | 1101153 - Andr&eacute; Teixeira | 111073 - Joel Alves | 1120035 - V&iacute;tor Mascarenhas<h5>\n" +
            "</body>\n" +
            "</html>";
        return epilogo;
    }
    
    public static String center(Casa c1){
        String inicio="<table>\n" +
            "  <tr>\n" +
            "    <th>Parede</th>\n" +
            "    <th>Camada</th>\n" +
            "  </tr>";
        
        String fim="</table>";
        String center="";
        
        if(c1.getParedes()!=null){
            for(Parede p :c1.getParedes()){
                center+=imprimeParede(p);
            }
        }
  
        return center;
    }
    
    public static String imprimeParede(Parede p1){
        String inicio="<tr>\n" +
            "    <td>1</td>\n" +
            "    <td>\n" +
            "      <table>\n" +
            "        <tr>\n" +
            "          <th>N&ordm;</th>\n" +
            "          <th>Especifica&ccedil;&otilde;es</th>\n" +
            "        </tr>";
        
        String fim="      </table>\n" +
            "    </td>";
        
        String comp="\n";
        for(Componente c : p1.getComponentes()){
            comp+= imprimeComponentes(c);
        }
        return inicio+comp+fim;
    }
    
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
                "                <td>Área:</td>\n" +
                "                <td>"+ c1.calculaArea() +"cm</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Espessura:</td>\n" +
                "                <td>"+ c.getEspessura() +"cm</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Nome Material:</td>\n" +
                "                <td>"+ c.getTipoMaterial() +"cm</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Condutividade:</td>\n" +
                "                <td>"+Materiais.getInstance().obterCondutividade(c.getTipoMaterial())+"</td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "            <!--Fim informações camada camada-->\n" +
                "          </td>\n" +
                "        </tr>";    
        }else if(c1 instanceof Janela){
            Janela c = (Janela) c1;
              html+="        <tr>\n" +
                "          <td>Camada</td>\n" +
                "          <td>\n" +
                "            <!--informações da camada-->\n" +
                "            <table>\n" +
                "              <tr>\n" +
                "                <td>Área:</td>\n" +
                "                <td>"+ c1.calculaArea() +"cm</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Espessura:</td>\n" +
                "                <td>"+ c.getEspessura() +"cm</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Nome Material:</td>\n" +
                "                <td>"+ c.getNomeMaterial() +"cm</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Condutividade:</td>\n" +
                "                <td>"+Materiais.getInstance().obterCondutividade(c.getNomeMaterial())+"</td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "            <!--Fim informações camada camada-->\n" +
                "          </td>\n" +
                "        </tr>"; 
        }else{
            Porta c = (Porta) c1;
              html+="        <tr>\n" +
                "          <td>Camada</td>\n" +
                "          <td>\n" +
                "            <!--informações da camada-->\n" +
                "            <table>\n" +
                "              <tr>\n" +
                "                <td>Área:</td>\n" +
                "                <td>"+ c1.calculaArea() +"cm</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Espessura:</td>\n" +
                "                <td>"+ c.getEspessura() +"cm</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Nome Material:</td>\n" +
                "                <td>"+ c.getTipoMaterial() +"cm</td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td>Condutividade:</td>\n" +
                "                <td>"+Materiais.getInstance().obterCondutividade(c.getTipoMaterial())+"</td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "            <!--Fim informações camada camada-->\n" +
                "          </td>\n" +
                "        </tr>"; 
        }
        return html;
    }
    
    public static String imprimeTemperaturas(Casa c1){
        String html="<table>\n" +
            "  <tr>\n" +
            "    <td>Temperatura Interior:</td>\n" +
            "    <td>"+c1.getTempInterior()+"C</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>Temperatura Exterior:</td>\n" +
            "    <td>"+c1.getTempExterior()+"C</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>Temperatura Solo:</td>\n" +
            "    <td>Não implementado</td>\n" +
            "  </tr>\n" +
            "</table>";
        
        return html;
    }
    
    
    /*METODOS PARA EXPORTAR MATERIAIS*/
    
    public static void exportMat(String nomeFicheiro) throws FileNotFoundException{
        try (Formatter fo = new Formatter (new File(nomeFicheiro+".html"))) {
            String html = imprimeMateriais();
            fo.format(html);
            fo.close();
        }
    }
    
    
    
    public static String imprimeMateriais(){
        String html = "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "<title>Lista Materiais</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h4>Lista de materiais<h4>\n" +
                        "<table>\n" +
                        "  <tr>\n" +
                        "    <td>Nome</td>\n" +
                        "    <td>Condutividade</td>\n" +
                        "  </tr>";
        
        for(Material m: Materiais.getInstance().getListMateriais()){
            html +=  "  <tr>\n" +
                        "    <td>"+ m.getNomeMaterial()+"</td>\n" +
                        "    <td>"+ m.obterCondutividade()+"</td>\n" +
                        "  </tr>";
        }
        
        html+= "</table>\n" +
                    "</body>\n" +
                    "</html>";
        
        return html;
    }
    
    


}
