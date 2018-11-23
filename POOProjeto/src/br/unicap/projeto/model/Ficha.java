package br.unicap.projeto.model;

import java.io.IOException;

import java.util.ArrayList;

import br.unicap.projeto.designPatterns.Prototype;
import br.unicap.projeto.model.exercicioComposite.Exercicio;
import br.unicap.projeto.model.exercicioComposite.ExercicioComposite;
import br.unicap.projeto.model.exercicioComposite.ExercicioSimples;

public class Ficha implements Prototype{

    private Professor professor;
    private Aluno aluno;
    private ArrayList<Exercicio> listaDeExercicios;

    public Ficha(Professor professor, Aluno aluno) {
        this.professor = professor;
        this.aluno = aluno;
        listaDeExercicios = new ArrayList<>();
        /*Exercicio a = new ExercicioSimples("Supino", "Exercicio voltado principalmente para os musculos do peitoral,deltoide e triceps", 2, 2, 2, 2, 5);
        Exercicio b = new ExercicioSimples("Agachamento", "Tambem conhecido com squat,eh um exercicio completo com enfoque nas pernas,costas e barriga", 2, 2, 2, 2, 5);
        Exercicio c = new ExercicioSimples("Puxada alta", "Exercicio focado em trabalhar a grande dorsal ", 2, 2, 2, 2, 5);
        listaDeExercicios.add((ExercicioSimples) a);
        listaDeExercicios.add((ExercicioSimples) b);
        listaDeExercicios.add((ExercicioSimples) c);*/
    }
    public Ficha(Professor professor, Aluno aluno, ArrayList<Exercicio> exercicios) {
        this.professor = professor;
        this.aluno = aluno;
        listaDeExercicios = new ArrayList<>();
        listaDeExercicios = exercicios;
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


    public boolean listaDeExercicioVazia() {
        return listaDeExercicios.isEmpty();
    }

    public void iniciar() throws IOException {
        int i, aux, repeticoes, series;
        ExercicioSimples e;
        ExercicioComposite c;
        aux = listaDeExercicios.size();
        System.out.println("olá, vamos começar o treino \n");
        for (i = 0; i < aux; i++) {
        	if(listaDeExercicios.get(i) instanceof ExercicioSimples) {
        		e =  (ExercicioSimples) listaDeExercicios.get(i);
        		System.out.println("exercicio : " + e.getNome());
        		System.out.println("descricao : " + e.getDescricao());
        		System.out.println("quantidades de repeticoes : " + e.getRepeticoes());
        		System.out.println("quantidade de series : " + e.getSeries() + "\n");
        		System.out.println("digite Enter para continuar");
        		System.in.read();
        		for (series = 1; series <= e.getSeries(); ++series) {
        			System.out.println("\nserie : " + series);
        			for (repeticoes = 1; repeticoes <= e.getRepeticoes(); ++repeticoes) {
        				System.out.println("\nrepeticao : " + repeticoes + "\n");
        				e.getTimer().contadorContracao();
        				e.getTimer().contadorDescontracao();
        			}
        			listaDeExercicios.get(i).getTimer().contadorDescanco();
        		}
        		System.out.printf("\nvoce completou : %.2f do treino\n", this.progresso(i + 1, aux));
        	}else {
        		c = (ExercicioComposite) listaDeExercicios.get(i);
        		System.out.println("exercicio : " + c.toString());
        		System.out.println("digite Enter para continuar");
        		System.in.read();
        		/*for (series = 1; series <= c.getSeries(); ++series) {
        			System.out.println("\nserie : " + series);
        			for (repeticoes = 1; repeticoes <= e.getRepeticoes(); ++repeticoes) {
        				System.out.println("\nrepeticao : " + repeticoes + "\n");
        				c.getTimer().contadorContracao();
        				c.getTimer().contadorDescontracao();
        			}
        			//c.listaDeExercicios.get(i).getTimer().contadorDescanco();
        		}*/
        		System.out.printf("\nvoce completou : %.2f do treino\n", this.progresso(i + 1, aux));
        	}
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
