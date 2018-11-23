
package br.unicap.projeto.dao;

import br.unicap.projeto.designPatterns.BridgeFicha;
import br.unicap.projeto.model.Ficha;

import java.util.ArrayList;

public class FichaDao implements BridgeFicha { // <<<<<<<<<<<<<<<<<<<<< singletom 
    
    private static FichaDao instancia;
    private static ArrayList<Ficha> listaFicha = new ArrayList<>();
    
    private static FichaDao criarInstancia() { // <<<<<<<<<<<<<< alterei aqui , ver se ta tudo certo 
        instancia = new FichaDao();
        return instancia;
    }

    public static FichaDao getInstancia() {
        if(instancia == null){
            instancia = new FichaDao();
        }
        return instancia;
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
    public  ArrayList<Ficha> exibir() {
        return listaFicha;
    }

    @Override
    public boolean vazio() {
        return listaFicha.isEmpty();
    }
    
    
}
