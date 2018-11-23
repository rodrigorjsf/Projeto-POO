package br.unicap.projeto.model.exercicioComposite;

import java.util.ArrayList;

import br.unicap.projeto.model.Timer;

public class ExercicioComposite extends Exercicio{

    private ArrayList<ExercicioSimples> listaDeExercicios;

    public ExercicioComposite(String nome, String descricao) {
        this.setNome(nome);
        this.setDescricao(descricao);
        listaDeExercicios = new ArrayList<ExercicioSimples>();
    }
 
    @Override
    public void setExercicio(ExercicioSimples exerEome) {
    	this.listaDeExercicios.add(exerEome);
    }
   
    
    
    @Override
    public String toString() {
    	StringBuilder exercicios = new StringBuilder();
    	String result;	
    	result = "\nNome=" + this.getNome() + "\nDescrição=" + this.getDescricao() + "\n";
        exercicios.append(result);
		for (ExercicioSimples d : listaDeExercicios) {
			result = "-> Nome Exercicio = " + d.getNome() + "\n\tDescrição = " + d.getDescricao()
			+ "\n\tSeries = " + d.getSeries() + "\n\tRepetições = " +  d.getRepeticoes() + d.getTimer().toString() + "\n";
            exercicios.append(result);
        }
		return exercicios.toString();
	}

	@Override
	public void setDescricao(String descricao) {
		super.descricao = descricao;
		
	}

	@Override
	public Timer getTimer() {
		// TODO Auto-generated method stub
		return null;
	}

	
    
}