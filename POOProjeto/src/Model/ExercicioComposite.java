package Model;

import java.util.ArrayList;

public class ExercicioComposite extends Exercicio{

	private String nome;
    private String descricao;
    private int series;
    private int repeticoes;
    private Timer timer;
    private ArrayList<Exercicio> listaDeExercicios;

    public ExercicioComposite(String nome, String descricao, int series, int repeticoes,int tempoContracao, int tempoDescontracao, int tempoDescanco) {
        this.nome = nome;
        this.descricao = descricao;
        this.series = series;
        this.repeticoes = repeticoes;
        this.timer = new Timer(tempoContracao,tempoDescontracao,tempoDescanco);
    }

    public static void adicionar(Exercicio exerEome) {
    	this.listaDeExercicios.add(exerEome);
    }
    public void alterar(Exercicio exerEome) {
    	
    }
    public void buscar(String exerEome) {

    }
    public void remover(Exercicio exerEome) {

    }
    
    @Override
    public String toString() {
        return "\nnome=" + nome + "\ndescricao=" + descricao + "\nseries=" + series + "\nrepeticoes=" + repeticoes + "\n";
    }
    
}
