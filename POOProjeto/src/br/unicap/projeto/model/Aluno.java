package br.unicap.projeto.model;

public class Aluno extends Pessoa {

    private int id;
    private double altura;
    private double peso;
    private String TipoDoTreino;
    private String objetivos;

    public Aluno(int id, double altura, double peso, String TipoDoTreino, String objetivos, String nome, String telefone, String email, String endereco, String cpf, int idade) {
        super(nome, telefone, email, endereco, cpf, idade);
        this.id = id;
        this.altura = altura;
        this.peso = peso;
        this.TipoDoTreino = TipoDoTreino;
        this.objetivos = objetivos;
    }

    /*public static class AlunoBuilder {

        private String nome;
        private String telefone;
        private String email;
        private String endereco;
        private String cpf;
        private String TipoDoTreino;
        private String objetivos;
        private int idade;
        private int id;
        private double altura;
        private double peso;
        private double imc;

        public AlunoBuilder() {

        }

        public AlunoBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public AlunoBuilder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public AlunoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AlunoBuilder endereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public AlunoBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public AlunoBuilder TipoDoTreino(String TipoDoTreino) {
            this.TipoDoTreino = TipoDoTreino;
            return this;
        }

        public AlunoBuilder objetivos(String objetivos) {
            this.objetivos = objetivos;
            return this;
        }

        public AlunoBuilder idade(int idade) {
            this.idade = idade;
            return this;
        }

        public AlunoBuilder id(int id) {
            this.id = id;
            return this;
        }

        public AlunoBuilder altura(double altura) {
            this.altura = altura;
            return this;
        }
        
        public AlunoBuilder peso (double peso){
            this.peso = peso;
            return this;
        }
        
        public AlunoBuilder imc (double imc){
        	double imcTmp;
        	imcTmp = (this.peso) / (this.altura * this.altura);
            this.imc = imcTmp;
            return this.imc;
        }
        
        public Aluno builderAluno (){
            return new Aluno(id, altura, peso, TipoDoTreino, objetivos, nome, telefone, email, endereco, cpf, idade);
        }
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTipoDoTreino() {
        return TipoDoTreino;
    }

    public void setTipoDoTreino(String TipoDoTreino) {
        this.TipoDoTreino = TipoDoTreino;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public double getImc() {
    	double imc;
    	imc = (this.peso) / (this.altura * this.altura);
        return imc;
    }


    @Override
    public String toString() {
        return "\nid = " + id + "\naltura = " + altura + "\npeso = " + peso + "\nimc = " + getImc() + "\nTipoDoTreino = " + TipoDoTreino + "\nobjetivos = " + objetivos + "\n";
    }

}
