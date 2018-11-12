package Model;

public class Timer {
    
    private int tempoContracao;
    private int tempoDescontracao;
    private int tempoDescanco;

    public Timer(int tempoContracao, int tempoDescontracao, int tempoDescanco) {
        this.tempoContracao = tempoContracao;
        this.tempoDescontracao = tempoDescontracao;
        this.tempoDescanco = tempoDescanco;
    }

    public int getTempoContracao() {
        return tempoContracao;
    }

    public void setTempoContracao(int tempoContracao) {
        this.tempoContracao = tempoContracao;
    }

    public int getTempoDescontracao() {
        return tempoDescontracao;
    }

    public void setTempoDescontracao(int tempoDescontracao) {
        this.tempoDescontracao = tempoDescontracao;
    }

    public int getTempoDescanco() {
        return tempoDescanco;
    }

    public void setTempoDescanco(int tempoDescanco) {
        this.tempoDescanco = tempoDescanco;
    }
    
    public void contadorContracao (){
        int i;
	for(i = this.tempoContracao; i >= 0; --i){	
            try{
		Thread.sleep(1000);
            } catch (InterruptedException e){	
		System.out.println(e.getMessage());
            }//Mostra a contagem.
            System.out.println("contracao:" + i);
	}
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){	
            System.out.println("ERRO");
        }
    }
    
    public void contadorDescontracao (){
        int i;
	for(i = this.tempoDescontracao; i >= 0; --i){	
            try{
		Thread.sleep(1000);
            } catch (InterruptedException e){	
		System.out.println("ERRO");
            }//Mostra a contagem.
            System.out.println("descontracao:" + i);
	}
        try{
            Thread.sleep(100);
        } catch (InterruptedException e){	
            System.out.println("ERRO");
        }
    }
    
    public void contadorDescanco (){
        int i;
        System.out.println("\ntempo de descanco\n");
	for(i = this.tempoDescanco; i >= 0; --i ){	
            try{
		Thread.sleep(1000);
            } catch (InterruptedException e){	
		System.out.println("ERRO");
            }//Mostra a contagem.
            System.out.println("descanco:" + i);
	}
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){	
            System.out.println("ERRO");
        }
    }
}
