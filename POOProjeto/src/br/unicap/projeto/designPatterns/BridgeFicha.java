
package br.unicap.projeto.designPatterns;

import java.util.ArrayList;

import br.unicap.projeto.model.Ficha;

public interface BridgeFicha {
    
    void adicionar(Ficha obj);
    
    void remover(Ficha obj);
    
    Ficha buscar(int id);
    
    ArrayList<Ficha> exibir();
        
    boolean vazio ();
}
