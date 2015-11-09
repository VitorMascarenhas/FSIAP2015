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
import Dominio.Parede;
import Dominio.Porta;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author rekgnyz
 */
public class ToHTML {
    
    public static void export(String nomeExperiencia, Casa c1) throws FileNotFoundException{
        try (Formatter fo = new Formatter (new File(nomeExperiencia))) {
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
        "<img src=\"isep.png\"/>";
        
        return prologo;
    }
    
    public static String epilogo(){
        String epilogo = "<h4>Desenvolvido por:<h4>\n" +
            "<h5>Aluno1, Aluno2, Aluno3, ALuno4, Aluno5<h5>\n" +
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
        
        for(Parede p :c1.getParedes()){
            center+=imprimeParede(p);
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
                "                <td>Nao apresenta dados</td>\n" +
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
                "                <td>Nao apresenta dados</td>\n" +
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
                "                <td>Nao apresenta dados</td>\n" +
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
            "    <td>Temperatura interior:</td>\n" +
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

}
