package Model;

import Interface.Prototype;
import java.io.IOException;

import java.util.ArrayList;

public class Ficha implements Prototype{

    private Professor professor;
    private Aluno aluno;
    private ArrayList<Exercicio> listaDeExercicios;

    public Ficha(Professor professor, Aluno aluno) {
        this.professor = professor;
        this.aluno = aluno;
        listaDeExercicios = new ArrayList<>();
        Exercicio a = new Exercicio("Supino", "Exercicio voltado principalmente para os musculos do peitoral,deltoide e triceps", 2, 2, 2, 2, 5);
        Exercicio b = new Exercicio("Agachamento", "Tambem conhecido com squat,eh um exercicio completo com enfoque nas pernas,costas e barriga", 2, 2, 2, 2, 5);
        Exercicio c = new Exercicio("Puxada alta", "Exercicio focado em trabalhar a grande dorsal ", 2, 2, 2, 2, 5);
        listaDeExercicios.add(a);
        listaDeExercicios.add(b);
        listaDeExercicios.add(c);
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public Professor getProfessor() {
        return professor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public ArrayList<Exercicio> getListaDeExercicios() {
        return listaDeExercicios;
    }

    public boolean listaDeExercicioVazia() {
        return listaDeExercicios.isEmpty();
    }

    public void iniciar() throws IOException {
        int i, aux, repeticoes, series;

        aux = listaDeExercicios.size();
        System.out.println("olá, vamos começar o treino \n");
        for (i = 0; i < aux; i++) {
            System.out.println("exercicio : " + listaDeExercicios.get(i).getNome());
            System.out.println("descricao : " + listaDeExercicios.get(i).getDescricao());
            System.out.println("quantidades de repeticoes : " + listaDeExercicios.get(i).getRepeticoes());
            System.out.println("quantidade de series : " + listaDeExercicios.get(i).getSeries() + "\n");
            System.out.println("digite Enter para continuar");
            System.in.read();
            for (series = 1; series <= listaDeExercicios.get(i).getSeries(); ++series) {
                System.out.println("\nserie : " + series);
                for (repeticoes = 1; repeticoes <= listaDeExercicios.get(i).getRepeticoes(); ++repeticoes) {
                    System.out.println("\nrepeticao : " + repeticoes + "\n");
                    listaDeExercicios.get(i).getTimer().contadorContracao();
                    listaDeExercicios.get(i).getTimer().contadorDescontracao();
                }
                listaDeExercicios.get(i).getTimer().contadorDescanco();
            }
            System.out.printf("\nvoce completou : %.2f do treino\n", this.progresso(i + 1, aux));
        }
        System.out.println("parabens por ter terminado mais um teino");
        System.out.println("ate amanha e tenha um bom descanco");
    }

    public double progresso(int i, int aux) {
        return (double) (((double) i / (double) aux) * 100);
    }

    public boolean adicionarExercicio(Exercicio exercicio) {
        return listaDeExercicios.add(exercicio);
    }

    public boolean removerExercicio(Exercicio exercicio) {
        return listaDeExercicios.remove(exercicio);
    } 

    @Override
    public String toString() {
        String results = "Aluno: " + aluno + "\nProfessor: " + professor + "\n\nExercicios";
        for (Exercicio d : listaDeExercicios) {
            results += d.toString();
        }
        return results;
    }

    @Override
    public Ficha clone() { // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<PROTOTYPE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
        Ficha novo = new Ficha(this.professor,null);//sem o aluno 
        int aux = this.listaDeExercicios.size();
        for(int i=0;i<aux;++i){
            novo.listaDeExercicios.add(this.listaDeExercicios.get(i));
        }
        return novo;
    }

 
    
}
