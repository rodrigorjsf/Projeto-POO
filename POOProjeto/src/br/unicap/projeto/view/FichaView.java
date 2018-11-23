package br.unicap.projeto.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import br.unicap.projeto.controller.FichaController;
import br.unicap.projeto.model.Aluno;
import br.unicap.projeto.model.Ficha;
import br.unicap.projeto.model.Professor;
import br.unicap.projeto.model.exercicioComposite.Exercicio;
import br.unicap.projeto.model.exercicioComposite.ExercicioComposite;
import br.unicap.projeto.model.exercicioComposite.ExercicioSimples;

public class FichaView  {

    private FichaController controllerFicha;
	private Scanner scanfs;
	private Scanner scanf;
	private Scanner scanfs2;
	private Scanner scanf2;
	private Scanner scanf3;
	private Scanner scanf4;
	private Scanner scanf5;
	private Scanner scanfs3;
	private Scanner scanf6;
	private Scanner scanfs4;
	private Scanner scanf7;
	private Scanner scanf8;
	private Scanner scanf9;

    public FichaView() throws IOException {
        this.controllerFicha = new FichaController();
    }
    
    public void menuFicha() throws IOException {
        scanf9 = new Scanner(System.in);

        int voto;
        System.out.println("\n\tM E N U \n");
        System.out.println("1 - cadastrar nova ficha");
        System.out.println("2 - remover ficha");
        System.out.println("3 - alterar ficha");
        System.out.println("4 - exibir ficha");
        System.out.println("5 - iniciar treino");
        System.out.println("6 - sair ");
        System.out.print("\ndigite aqui : ");
        voto = scanf9.nextInt();
        while (voto < 1 || voto > 6) {
            System.out.println("opcao invalida");
            System.out.print("digite novamente numero valido : ");
            voto = scanf9.nextInt();
        }
        
        switch(voto){
            case 1:{
                cadastro();
                break;
            } case 2: {
                remover();
                break;
            } case 3 : {
                alterar();
                break;
            } case 4 : {
                exibir ();
                break;
            } case 5 : {
                iniciar();
                break;
            } case 6 : {
              break;
            }
        }
    }

    private void cadastro() {
        scanf8 = new Scanner(System.in);
        ArrayList<Exercicio> exercicios;
        Aluno aluno;
        Professor professor;
        Ficha ficha;
        int id,voto;
        
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> PADRAO PROTOTYPE <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
        
        System.out.print("digite \n\n1 - criar um nova ficha \n2 - copiar uma ficha ja existente \n\ndigite aqui : ");
        voto = scanf8.nextInt();
        while(voto < 1 || voto > 2){
            System.out.print("opcao invalida \ndigite numero valido[1/2] : ");
            voto = scanf8.nextInt();
        }
        if(voto == 2){//coloca uma funcao de lista vazia -> aqui e no dao 
            if(controllerFicha.vazio()){
                System.out.println("nao ha fichas cadastradas para fazer copia");
            } else {
                System.out.print("digite o id da ficha : ");
                id = scanf8.nextInt();
                
                ficha = controllerFicha.buscar(id);
                if(ficha == null){
                    System.out.println("ficha nao existe");
                }else {
                    Ficha novo = ficha.clone();
                    System.out.print("digite o id do aluno : ");
                    id = scanf8.nextInt();
                    ficha = controllerFicha.buscar(id);
                    while(ficha != null){
                        System.out.print("esse id ja esta em uso \ndigite outro id : ");
                        id = scanf8.nextInt();
                        ficha = controllerFicha.buscar(id);
                        System.out.println("");
                    }
                    aluno = criarAluno(id);
                    novo.setAluno(aluno);
                    controllerFicha.adicionar(novo);
                    System.out.println("ficha cadastrada com sucesso");
                }
            }   
        }
        // >>>>>>>>>>>>>>>>>>>>> FIM DO PROTOTYPE <<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
        else {
            System.out.print("digite o ID do Aluno : ");
            id = scanf8.nextInt();
        
            ficha = controllerFicha.buscar(id);
             if(ficha == null){
                aluno = criarAluno(id);
                professor = criarProfessor();
                
                exercicios = new ArrayList<Exercicio>();
                exercicios = menuExercicios();
                ficha = new Ficha(professor, aluno, exercicios);
                controllerFicha.adicionar(ficha);
                System.out.println("ficha cadastrada com sucesso");
            }else {
                 System.out.println("essa ficha ja foi cadastrada");
            }
        }
        
    }
    
    private void remover(){
        scanf7 = new Scanner(System.in);
        int id;
        Ficha ficha;
        
        System.out.print("digite o ID do Aluno : ");
        id = scanf7.nextInt();
        ficha = controllerFicha.buscar(id);
        if(ficha == null){
            System.out.println("essa ficha nao existe");
        } else {
            controllerFicha.remover(ficha);
            System.out.println("ficha removida com sucesso");
        }
    }
    
    private void alterar(){
        scanf2 = new Scanner(System.in);
        int id;
        Ficha ficha;
        
        System.out.print("digite o ID do Aluno : ");
        id = scanf2.nextInt();
        ficha = controllerFicha.buscar(id);
        if(ficha == null){
            System.out.println("essa ficha nao existe");
        } else {
            menuAlterar(ficha);
            System.out.println("ficha alterada com sucesso");
        }
    }
    
    private void exibir(){
        scanf3 = new Scanner(System.in);
        int id;
        Ficha ficha;
        
        System.out.print("digite o ID do Aluno : ");
        id = scanf3.nextInt();
        ficha = controllerFicha.buscar(id);
        if(ficha == null){
            System.out.println("ficha nao cadastrada");
        } else {
            System.out.println(ficha);
        }
    }
    
    private void iniciar() throws IOException{ //5 esse metodo pega o ip do usuario e busca a ficha e usa o metodo da ficha 
        
        scanf4 = new Scanner(System.in);
        int id;
        Ficha ficha;
        
        System.out.print("digite o ID do Aluno : ");
        id = scanf4.nextInt();
        ficha = controllerFicha.buscar(id);
        if(ficha == null){
            System.out.println("ficha nao cadastrada");
        } else {
            ficha.iniciar();
        }
    }
    
    private Aluno criarAluno (int id){
        scanf5 = new Scanner(System.in);
        scanfs3 = new Scanner(System.in);
        String nome,telefone,email,endereco,cpf,TipoDoTreino,objetivo;
        int idade;
        double altura,peso;
        System.out.println("\ndados do aluno \n");
        
        System.out.print("digite o nome : ");
        nome = scanfs3.nextLine();
        System.out.print("digite o telefone : ");
        telefone = scanf5.nextLine();
        System.out.print("digite o email : ");
        email = scanf5.nextLine();
        System.out.print("digite o endereco : ");
        endereco = scanfs3.nextLine();
        System.out.print("digite o cpf : ");
        cpf = scanfs3.nextLine();
        System.out.print("digite o tipo de treino : ");
        TipoDoTreino = scanfs3.nextLine();
        System.out.print("digite o objetivo : ");
        objetivo = scanfs3.nextLine();
        System.out.print("digite a idade : ");
        idade = scanf5.nextInt();
        System.out.print("digite a altura : ");
        altura = scanf5.nextDouble();
        System.out.print("digite o peso : ");
        peso = scanf5.nextDouble();
        Aluno a = new Aluno(id, altura, peso, TipoDoTreino, objetivo, nome, telefone, email, endereco, cpf, idade); //>>>>>>>>>>>> usado antes
        /*Aluno a = new Aluno.AlunoBuilder() // >>>>>>>>>>>>> padrao builder
                .id(id)
                .altura(altura)
                .peso(peso)
                .TipoDoTreino(TipoDoTreino)
                .objetivos(objetivo)
                .nome(nome)
                .telefone(telefone)
                .email(email)
                .endereco(endereco)
                .cpf(cpf)
                .idade(idade)
                .builderAluno();*/
                
        
        return a;
    }
    
    private Professor criarProfessor (){
        scanf6 = new Scanner(System.in);
        scanfs4 = new Scanner(System.in);
        int idade,codigo; 
        String nome,telefone,email,endereco,cpf,turno,especialidade;
        
        System.out.println("\ndados do professor \n");
        
        System.out.print("digite o nome : ");
        nome = scanfs4.nextLine();
        System.out.print("digite o telefone : ");
        telefone = scanf6.nextLine();
        System.out.print("digite o email : ");
        email = scanf6.nextLine();
        System.out.print("digite o endereco : ");
        endereco = scanfs4.nextLine();
        System.out.print("digite o cpf : ");
        cpf = scanfs4.nextLine();
        System.out.print("digite a idade : ");
        idade = scanf6.nextInt();
        System.out.print("digite o turno : ");
        turno = scanfs4.nextLine();
        System.out.print("digite a especialidade : ");
        especialidade = scanfs4.nextLine();
        System.out.print("digite o codigo : ");
        codigo = scanfs4.nextInt();
        //Professor p = new Professor(codigo, turno, especialidade, nome, telefone, email, endereco, cpf, idade); // >>>>>>>>>>> usado anteriormente
        Professor p = new Professor.ProfessorBuilder()// padrao de projeto builder
                .codigo(codigo)
                .turno(turno)
                .especialidade(especialidade)
                .nome(nome)
                .telefone(telefone)
                .email(email)
                .endereco(endereco)
                .cpf(cpf)
                .idade(idade)
                .builderProfessor();
        return p;
    }
    
    private void menuAlterar (Ficha ficha){
        scanf = new Scanner(System.in);
        scanfs2 = new Scanner(System.in);
        int voto=0;
 
        do{
            System.out.println("1 - para alterar o nome do aluno");
            System.out.println("2 - para alterar o telefone do aluno");
            System.out.println("3 - para alterar o email do aluno");
            System.out.println("4 - para alterar o endereco do aluno");
            System.out.println("5 - para alterar o cpf do aluno");
            System.out.println("6 - para alterar o idade do aluno");
            System.out.println("7 - para alterar a altura do aluno");
            System.out.println("8 - para alterar o peso do aluno");
            System.out.println("9 - para alterar o tipo do treino do aluno");
            System.out.println("10 - para alterar o objetivos do aluno");
            
            System.out.println("11 - para alterar o nome do professor");
            System.out.println("12 - para alterar o telefone do professor");
            System.out.println("13 - para alterar o email do professor");
            System.out.println("14 - para alterar o endereco do professor");
            System.out.println("15 - para alterar o cpf do professor");
            System.out.println("16 - para alterar o idade do professor");
            System.out.println("17 - para alterar o turno do professor");
            System.out.println("18 - para alterar a especialida do professor");
            
            //>>>>>>>>>>>>>> PROTOTYPE <<<<<<<<<<<<<<<<<<<<<//
            System.out.println("19 - para alterar os exercicios da sua ficha");
            System.out.println("20 - para copiar a ficha de outro aluno");
            //>>>>>>>>>>>>> PROTOTYPE <<<<<<<<<<<<<<<<<<<<<<//
            System.out.println("21 - para sair");
            System.out.print("\ndigite aqui : ");
            voto = scanf.nextInt();
            while(voto < 1 || voto > 21){
                System.out.println("opcao invalida");
                System.out.println("digite numero dentro da faixa permitida [1-21] : ");
                voto = scanf.nextInt();
            }
            
            switch (voto){
                case 1: {
                    System.out.print("digite o novo nome : ");
                    ficha.getAluno().setNome(scanfs2.nextLine());
                    break;
                } case 2: {
                    System.out.print("digite o novo telefone : ");
                    ficha.getAluno().setTelefone(scanfs2.nextLine());
                    break;
                } case 3: {
                    System.out.print("digite o novo email : ");
                    ficha.getAluno().setEmail(scanfs2.nextLine());
                    break;
                } case 4: {
                    System.out.print("digite o novo endereco : ");
                    ficha.getAluno().setEndereco(scanfs2.nextLine());
                    break;
                } case 5: {
                    System.out.print("digite o novo cpf : ");
                    ficha.getAluno().setCpf(scanfs2.nextLine());
                    break;
                } case 6: {
                    System.out.print("digite a nova idade : ");
                    ficha.getAluno().setIdade(scanf.nextInt());
                    break;
                } case 7: {
                    System.out.print("digite a nova altura : ");
                    ficha.getAluno().setAltura(scanf.nextDouble());
                    break;
                } case 8: {
                    System.out.print("digite o novo peso : ");
                    ficha.getAluno().setPeso(scanf.nextDouble());                  
                    break;
                } case 9: {
                    System.out.print("digite o novo tipo do treino : ");
                    ficha.getAluno().setTipoDoTreino(scanfs2.nextLine());
                    break;
                } case 10: {
                    System.out.print("digite o novo objetivo : ");
                    ficha.getAluno().setObjetivos(scanfs2.nextLine());
                    break;
                } case 11: {
                    System.out.print("digite o novo nome : ");
                    ficha.getProfessor().setNome(scanfs2.nextLine());
                    break;
                } case 12: {
                    System.out.print("digite o novo telefone : ");
                    ficha.getProfessor().setTelefone(scanfs2.nextLine());
                    break;
                } case 13: {
                    System.out.print("digite o novo email : ");
                    ficha.getProfessor().setEmail(scanfs2.nextLine());
                    break;
                } case 14: {
                    System.out.print("digite o novo endereco : ");
                    ficha.getProfessor().setEndereco(scanfs2.nextLine());
                    break;
                } case 15: {
                    System.out.print("digite o novo cpf : ");
                    ficha.getProfessor().setCpf(scanfs2.nextLine());
                    break;
                } case 16: {
                    System.out.print("digite a nova idade : ");
                    ficha.getProfessor().setIdade(scanf.nextInt());
                    break;
                } case 17: {
                    System.out.print("digite o novo turno : ");
                    ficha.getProfessor().setTurno(scanfs2.nextLine());
                    break;
                } case 18: {
                    System.out.print("digite a nova especialidade : ");
                    ficha.getProfessor().setEspecialidade(scanfs2.nextLine());
                    break;
                } 
                case 19 : {
                    System.out.println("OBS : PRESCISA IMPLEMENTAR ESSA PARTE / A PARTE DE FICHAS AINDA NAO ESTA PRONTA");
                    //consiste em perguntar se o usuario quer remover os exercios da ficha dele ou adcionar 
                    //caso for remover : exiba todos os exerciciosos da ficha e pedi para o usuario selecionar qual ele quer tirar
                    //caso foi adicionar : exibir todos os exercicios cadastrados no sistema e pedir para o usuario selecionar o 
                    //                      que ele deseja adicionar 
                }
                case 20 : {
                    if(controllerFicha.vazio()){
                        System.out.println("nao ha fichas cadastradas para fazer copia");
                    } else {
                        int id;
                        System.out.print("digite o id do aluno que vc deseja copiar a ficha : ");
                        id = scanf.nextInt();
                        Ficha aux;
                        aux = controllerFicha.buscar(id);
                        if(aux == null){ // <<<<<<<<<<<<<<<< perguntar se Ã© melhor fazer assim com 'A e P' ou fazer um SOBRECARGA DO METODO CLONE
                            Professor p;
                            Aluno a;
                            a = ficha.getAluno();
                            p = ficha.getProfessor();
                            ficha = aux.clone();
                            ficha.setProfessor(p);
                            ficha.setAluno(a);
                        }
                    }                        
                }
            }
        } while(voto != 21);
    }

    private ArrayList<Exercicio> menuExercicios() {
    	scanfs = new Scanner(System.in);
    	ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
    	int voto=0;
    	System.out.println("--Selecione os Exercicios da Ficha--");
    	do {

    		System.out.println("1 - Supino \n" + "Descricao: Exercicio voltado principalmente para os musculos do peitoral,deltoide e triceps.");
    		System.out.println("2 - Agachamento\n" + "Descricao: Tambem conhecido com squat,eh um exercicio completo com enfoque nas pernas,costas e barriga");
    		System.out.println("3 - Puxada alta" + "Descricao: Exercicio focado em trabalhar a grande dorsal");
    		System.out.println("4 - Rosca Direta");
    		System.out.println("5 - Crucifixo");
    		System.out.println("6 - Mesa Flexora ");
    		System.out.println("7 - Tríceps Coice ");
    		System.out.println("8 - Remada Alta ");
    		System.out.println("9 - Bi-set de Abdomen");
    		System.out.println("10 - Tri-set de Triceps");
    		System.out.println("11 - Sair");
    		voto = scanfs.nextInt();
    		while(voto < 1 || voto > 11){
    			System.out.println("opcao invalida");
    			System.out.println("digite numero dentro da faixa permitida [1-10] : ");
    			voto = scanfs.nextInt();
    		}

    		switch (voto){
    		case 1: {
    			Exercicio a = new ExercicioSimples("Supino", "Exercicio voltado principalmente para os musculos do peitoral,deltoide e triceps", 2, 2, 2, 2, 5);
    			exercicios.add(a);
    			break;
    		} case 2: {
    			Exercicio b = new ExercicioSimples("Agachamento", "Tambem conhecido com squat,eh um exercicio completo com enfoque nas pernas,costas e barriga", 2, 2, 2, 2, 5);
    			exercicios.add(b);
    			break;
    		} case 3: {
    			Exercicio c = new ExercicioSimples("Puxada alta", "Exercicio focado em trabalhar a grande dorsal ", 2, 2, 2, 2, 5);
    			exercicios.add(c);
    			break;
    		} case 4: {
    			Exercicio c = new ExercicioSimples("Rosca Direta", "É o exercício mais comum para os bíceps. Para executar uma rosca básica, \r\n" + 
    					"segure os pesos com as palmas das mãos voltadas para frente, com os cotovelos junto ao corpo.", 2, 2, 2, 2, 5);
    			exercicios.add(c);
    			break;
    		} case 5: {
    			Exercicio c = new ExercicioSimples("Crucifixo", "Deite-se em um banco horizontal. Segure os halteres com os braços estendidos e os cotovelos levemente flexionados.", 2, 2, 2, 2, 5);
    			exercicios.add(c);
    			break;
    		} case 6: {
    			Exercicio c = new ExercicioSimples("Mesa Flexora", "Deite na máquina de barriga para baixo e posicione os calcanhares sob o apoio dos pés.\r\n"
    					, 2, 2, 2, 2, 5);
    			exercicios.add(c);
    			break;
    		} case 7: {
    			Exercicio c = new ExercicioSimples("Tríceps Coice ", "Incline-se para a frente de sua cintura e apoie o peso do corpo sobre o braço que está livre. ", 2, 2, 2, 2, 5);
    			exercicios.add(c);
    			break;
    		} case 8: {
    			Exercicio c = new ExercicioSimples("Remada Alta", "Ajuste a polia na posição mais baixa, prenda a barra reta e no mosquetão. \r\n" + 
    					"Posicione-se a frente dos pesos com a palma de cada mão voltadas para baixo, segurando próximo ao centro da barra.", 2, 2, 2, 2, 5);
    			exercicios.add(c);
    			break;
    		} case 9: {
    			Exercicio c = new ExercicioComposite("Bi-set de Abdomen", "-Tradicional (Frontal) e Oblíquo ");
    			ExercicioSimples a = new ExercicioSimples("Tradicional", "Desc ", 2, 2, 2, 2, 5);
    			ExercicioSimples b = new ExercicioSimples("Obliquo", "Desc ", 2, 2, 2, 2, 5);
    			c.setExercicio(a);
      			c.setExercicio(b);
      			exercicios.add(c);
      			break;
    		} case 10: {
    			Exercicio c = new ExercicioComposite("Tri-set de Triceps", "Exercicio focado em trabalhar a grande dorsal ");
    			ExercicioSimples a = new ExercicioSimples("Pulley", "Desc ", 2, 2, 2, 2, 5);
    			ExercicioSimples b = new ExercicioSimples("Corda", "Desc ", 2, 2, 2, 2, 5);
    			ExercicioSimples d = new ExercicioSimples("Coice - Unilateral", "Desc ", 2, 2, 2, 2, 5);
    			c.setExercicio(a);
    			c.setExercicio(b);
    			c.setExercicio(d);
    			exercicios.add(c);
    			break;
    		} case 11: {

    			break;
    		} 
    		}
    	}while(voto != 11 );
    	return exercicios;
    }
}