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
    public static float calculaResistenciaTermica(Componente componente) {
        return componente.getEspessura()/(componente.calculaArea()*Materiais.getInstance().obterCondutividade(componente.getTipoMaterial()));
    }
    
    
    public static float calculaResistenciaTermicaTotal(ArrayList<Componente> componentes) {
        
        ArrayList<Componente> serie = new ArrayList<>();
        ArrayList<Componente> paralelo = new ArrayList<>();
        
        float resEqSerie = 0.0f;
        float resEqParal = 0.0f;
        float resTotal = 0.0f;
        
        
        for(Componente c : componentes)
            if (c instanceof Camada)
                serie.add(c);
            else
                if(c instanceof Janela || c instanceof Porta)
                    paralelo.add(c);

        for(Componente c: serie)
            resEqSerie+=calculaResistenciaTermica(c);
        
        for(Componente c:paralelo)
            resEqParal += 1/calculaResistenciaTermica(c);
        
        if (resEqSerie!=0.0f && resEqParal!=0.0f) // Tem camadas e janelas
            resTotal = 1/((1/resEqSerie)+resEqParal);
        else
            if(resEqSerie!=0.0f) // Tem só camadas
                resTotal=resEqSerie;
            else    // Tem só janelas ou portas
                resTotal=1/resEqParal;
        
        return resTotal;

    }
    
}

   
