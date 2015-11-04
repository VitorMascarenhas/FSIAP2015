/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author rekgnyz
 */
public class ToHTML {
    public String prologo(){
        String prologo = "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<title>Page Title</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<img src=\"isep.png\"/>";
        
        return prologo;
    }
    
    public String epilogo(){
        String epilogo = "<h4>Desenvolvido por:<h4>\n" +
            "<h5>Aluno1, Aluno2, Aluno3, ALuno4, Aluno5<h5>\n" +
            "</body>\n" +
            "</html>";
        return epilogo;
    }
}
