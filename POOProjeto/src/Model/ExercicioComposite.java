package Model;

import java.util.ArrayList;

public class ExercicioComposite extends Exercicio{

    private ArrayList<ExercicioSimples> listaDeExercicios;

    public ExercicioComposite(String nome, String descricao, int series, int repeticoes,int tempoContracao, int tempoDescontracao, int tempoDescanco) {
        super.setNome(nome);
        super.setDescricao(descricao);
        super.setSeries(series);
        super.setRepeticoes(repeticoes);
        super.setTimer(tempoContracao,tempoDescontracao,tempoDescanco);
  
        //this.timer = new Timer(tempoContracao,tempoDescontracao,tempoDescanco);
    }

     public Exercicio exibir(int n) {
    	return exec;
    }  
    public void adicionar(ExercicioSimples exerEome) {
    	this.listaDeExercicios.add(exerEome);
    }
    public void alterar(Exercicio exerEome) {
    	
    }
    
    public void remover(Exercicio exerEome) {

    }
    
    @Override
    public String toString() {
		return "\nnome=" + super.getNome() + "\ndescricao=" + super.getDescricao() + "\nseries=" + super.getSeries() + "\nrepeticoes=" + super.getRepeticoes() + "\n";
	}
    
}
