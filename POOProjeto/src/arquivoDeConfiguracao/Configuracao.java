
package arquivoDeConfiguracao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracao {
 
    public static Properties getProp() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\Pedro Oliveira\\Documents\\NetBeansProjects\\POO\\src\\propriedades\\configuracoes.properties");
        props.load(file);
        return props;   
    }
}
