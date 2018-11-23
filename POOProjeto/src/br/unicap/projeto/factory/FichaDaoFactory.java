package br.unicap.projeto.factory;

import static br.unicap.projeto.config.arquivoDeConfiguracao.Configuracao.getProp;

import java.io.IOException;
import java.util.Properties;

import br.unicap.projeto.dao.FichaDao;

public class FichaDaoFactory { // <<<<<<<<<<<<<<<<<FALTA ARRUMAR, POR PARA LER OS PARAMETROS POR ARQUIVO 
    
    public static FichaDao CriarFichaDao () throws IOException{
        
        Properties prop = null;
        String tipo;
        
        try {
            prop = getProp();
        } catch (IOException ex) {
            System.err.println("Erro");
        }
        tipo = prop.getProperty("prop.DaoFicha");
             
        if("1".equals(tipo)){
            return FichaDao.getInstancia(); //<<<<<<<<<<<<<<<<<<<<singleton
        }else if ("2".equals(tipo)){            
            System.out.println("na teoria vai retornar um dao de arquivo, mas o mesmo nao estas implementado");
            System.exit(1);
        } else {
            System.out.println("configuracao invalida");
            System.exit(1);
        }
        
        return null;   
    }
}
