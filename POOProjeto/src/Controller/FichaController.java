
package Controller;

import Factory.FichaDaoFactory;
import Interface.BridgeFicha;
import Model.Ficha;
import java.io.IOException;
import java.util.ArrayList;

public class FichaController {
    
    
    private BridgeFicha banco;
    
    public FichaController() throws IOException {
        //this.banco = new FichaDao();// <<<<<<<< usado anteriormente 
        this.banco = FichaDaoFactory.CriarFichaDao();//>>>>>>>>>>>>> Padrao Factory 
    }
    
    public void adicionar (Ficha obj){
        banco.adicionar(obj);
    }
    
    public void remover (Ficha obj){
        banco.remover(obj);
    }
    
    public ArrayList exibir (){
        return banco.exibir();
    }
    
    public Ficha buscar (int id){
        return banco.buscar(id);
    }
    
    public Ficha alterar (int id){
        return banco.buscar(id);
        
    }
    
    public boolean vazio (){
        return banco.vazio();
    }
}
