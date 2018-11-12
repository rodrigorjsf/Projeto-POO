
package Interface;

import Model.Ficha;
import java.util.ArrayList;

public interface BridgeFicha {
    
    void adicionar(Ficha obj);
    
    void remover(Ficha obj);
    
    Ficha buscar(int id);
    
    ArrayList<Ficha> exibir();
        
    boolean vazio ();
}
