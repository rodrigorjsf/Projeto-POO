package br.unicap.projeto.model.exercicioComposite;

import br.unicap.projeto.model.Timer;

public abstract class Exercicio {
    
    protected String nome;
    protected String descricao;
    

    public abstract Timer getTimer();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void setDescricao(String descricao);

    
    public abstract void setExercicio(ExercicioSimples exerEome); 
 
    
}