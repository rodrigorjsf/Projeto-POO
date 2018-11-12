package Model;

import java.util.ArrayList;

public class Exercicio {
    
    private String nome;
    private String descricao;
    private int series;
    private int repeticoes;
    private Timer timer;
    

    public Exercicio() {

    }

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

    public Timer getTimer() {
        return timer;
    }
    
    
    @Override
    public String toString() {
        return "\nnome=" + nome + "\ndescricao=" + descricao + "\nseries=" + series + "\nrepeticoes=" + repeticoes + "\n";
    }
    
    
}
