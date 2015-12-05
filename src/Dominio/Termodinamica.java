package Dominio;

import Repositorios.Materiais;

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
    
    
}

    
}
