
package Dao;

import Interface.BridgeFicha;
import Model.Ficha;
import java.util.ArrayList;

public class FichaDao implements BridgeFicha { // <<<<<<<<<<<<<<<<<<<<< singletom 
    
    private static FichaDao INSTANCIA;
    private static ArrayList<Ficha> listaFicha = new ArrayList<>();
    
    private FichaDao INSTANCIA() { // <<<<<<<<<<<<<< alterei aqui , ver se ta tudo certo 
        INSTANCIA = new FichaDao();
        return INSTANCIA;
    }

    public static FichaDao getINSTANCIA() {
        if(INSTANCIA == null){
            INSTANCIA = new FichaDao();
        }
        return INSTANCIA;
    }
    
    @Override
    public void adicionar(Ficha obj) {
        listaFicha.add(obj);
    }

    @Override
    public void remover(Ficha ficha) {
        listaFicha.remove(ficha);
    }

    @Override
    public Ficha buscar(int id) {
        int aux;
      
        aux = listaFicha.size();
        for(int i = 0;i < aux; ++i){
              if(listaFicha.get(i).getAluno().getId() == id){
                 return listaFicha.get(i);
            }
        }
        return null;
    }
    
    @Override
    public ArrayList exibir() {
        return listaFicha;
    }

    @Override
    public boolean vazio() {
        return listaFicha.isEmpty();
    }
    
    
}
