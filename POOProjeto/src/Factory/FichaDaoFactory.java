package Factory;

import Dao.FichaDao;
import static arquivoDeConfiguracao.Configuracao.getProp;
import java.io.IOException;
import java.util.Properties;

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
            return FichaDao.getINSTANCIA(); //<<<<<<<<<<<<<<<<<<<<singleton
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
