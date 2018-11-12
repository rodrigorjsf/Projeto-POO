package Model;

import java.util.ArrayList;

public abstract class Exercicio {
    
    private String nome;
    private String descricao;
    private int series;
    private int repeticoes;
    private Timer timer;
    

    public Exercicio() {
    }
    
    public abstract Exercicio exibir();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        return timer;
    }
    
    

    
    
}
