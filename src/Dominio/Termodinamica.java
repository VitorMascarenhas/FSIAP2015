package Dominio;

import Repositorios.Materiais;
import java.util.ArrayList;

/**
 * Classe necessária para calcular a resistência térmica dos componentes e o fluxo de calor das paredes.
 * @author 11011_000
 */
public class Termodinamica {
    
    /* Método de calcular a resistência térmica de um determinado componente
    Resistencia térmica = Largura / (Condutividade material * Área)
    */
    public static float CalculaResistenciaTermica(Componente componente) {
        System.out.println("O componente " + componente.toString() + " tem um área de "+ componente.getArea());
        return componente.getEspessura()/(componente.getArea()*Materiais.getInstance().obterCondutividade(componente.getTipoMaterial()));
    }
    
    
    public static float CalculaResistenciaTermicaTotal(ArrayList<Componente> componentes) {
        
        ArrayList<Componente> serie = new ArrayList<>();
        ArrayList<Componente> paralelo = new ArrayList<>();
        
        float resEqSerie = 0.0f;    //Resistencia equivalente em série
        float resEqParal = 0.0f;    //Resistencia equivalente em paralelo
        float resTotal = 0.0f;      //Resistencia termica total
        
        // Verifica quais os componentes em série e em paralelo
        for(Componente c : componentes)
            if (c instanceof Camada) // Em série se camadas de parede
                serie.add(c);
            else
                if(c instanceof Janela || c instanceof Porta) { // Em paralelo para restantes componentes
                    paralelo.add(c);
                }
        
        // Calcula resistencia termica em serie
        for(Componente c: serie)
            resEqSerie+=CalculaResistenciaTermica(c);
   
        // Calcula resistencia termica em paralelo
        for(Componente c:paralelo)
            resEqParal += 1/CalculaResistenciaTermica(c);
        
        if (resEqSerie!=0.0f && resEqParal!=0.0f) // Tem camadas e janelas
            resTotal = 1/((1/resEqSerie)+resEqParal);
        else
            if(resEqSerie!=0.0f) // Tem só camadas
                resTotal=resEqSerie;
        
        return resTotal;
    }

    public static float FluxoCalor(Parede parede, float tempInterior, float tempExterior) {
        
        /* O fluxo é sempre positivo, mas se devolver fluxo negativo significa perda
        de calor da casa para o exterior, o que será relevante para calcular o fluxo total e 
        determinar a capacidade o AVAC */
        return (tempExterior-tempInterior)/parede.calculaResistenciaTermicaTotal();
    }
    
}

   
