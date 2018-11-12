package Model;

public class ExercicioSimples extends Exercicio {

	public ExercicioSimples(String nome, String descricao, int series, int repeticoes,int tempoContracao, int tempoDescontracao, int tempoDescanco) {
		super.setNome(nome);
		super.setDescricao(descricao);
		super.setSeries(series);
		super.setRepeticoes(repeticoes);
		super.setTimer(tempoContracao,tempoDescontracao,tempoDescanco);
	}

	public Exercicio exibir(int n) {
		return ExercicioSimples;
	}
	
	@Override
	public String toString() {
		return "\nnome=" + super.getNome() + "\ndescricao=" + super.getDescricao() + "\nseries=" + super.getSeries() + "\nrepeticoes=" + super.getRepeticoes() + "\n";
	}


}
