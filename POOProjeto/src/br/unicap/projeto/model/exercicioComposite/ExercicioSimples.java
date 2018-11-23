package br.unicap.projeto.model.exercicioComposite;

import br.unicap.projeto.model.Timer;

public class ExercicioSimples extends Exercicio {

	private int series;
    private int repeticoes;
    private Timer timer;
    
	public ExercicioSimples(String nome, String descricao, int series, int repeticoes,int tempoContracao, int tempoDescontracao, int tempoDescanco) {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setSeries(series);
		this.setRepeticoes(repeticoes);
		timer = new Timer(tempoContracao, tempoDescontracao, tempoDescanco);
		//this.setTimer(tempoContracao,tempoDescontracao,tempoDescanco);
	}

	public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public void setTimer(int tempoContracao, int tempoDescontracao, int tempoDescanco) {
        timer.setTempoContracao(tempoContracao);
        timer.setTempoDescontracao(tempoDescontracao);
        timer.setTempoDescanco(tempoDescanco);
    }
    
    public Timer getTimer() {
    	return this.timer;
    }
    @Override
    public String toString() {
		return "\n->Nome = " + super.getNome() + "\n\tDescrição = " + super.getDescricao() + "\n\tSeries = " + this.getSeries() + "\n\tRepetições = " + this.getRepeticoes() + getTimer().toString() +"\n";
	}

	@Override
	public void setExercicio(ExercicioSimples exerEome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDescricao(String descricao) {
		super.descricao = descricao;
		
	}


}