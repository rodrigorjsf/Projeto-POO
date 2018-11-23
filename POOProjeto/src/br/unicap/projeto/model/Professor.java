package br.unicap.projeto.model;

public class Professor extends Pessoa {

    private int codigo;
    private String turno;
    private String especialidade;

    private Professor(int codigo, String turno, String especialidade, String nome, String telefone, String email, String endereco, String cpf, int idade) {
        super(nome, telefone, email, endereco, cpf, idade);
        this.codigo = codigo;
        this.turno = turno;
        this.especialidade = especialidade;
    }

    public static class ProfessorBuilder { //<<<<<<<<<<<<<<<<< padrao de projeto builder 
        
        private String nome;
        private String telefone;
        private String email;
        private String endereco;
        private String cpf;
        private String turno;
        private String especialidade;
        private int idade;
        private int codigo;

        public ProfessorBuilder() {
            
        }
        
       public ProfessorBuilder nome (String nome){
           this.nome = nome;
           return this;
       }
       
       public ProfessorBuilder telefone (String telefone){
           this.telefone = telefone;
           return this;
       }
       
       public ProfessorBuilder email (String email){
           this.email = email;
           return this;
       }
       
       public ProfessorBuilder endereco (String endereco){
           this.endereco = endereco;
           return this;
       }
       
       public ProfessorBuilder cpf (String cpf){
           this.cpf = cpf;
           return this;
       }
       
       public ProfessorBuilder turno (String turno){
           this.turno = turno;
           return this;
       }
       
       public ProfessorBuilder especialidade (String especialidade){
           this.especialidade = especialidade;
           return this;
       }
       
       public ProfessorBuilder idade (int idade){
           this.idade = idade;
           return this;
       }
       
       public ProfessorBuilder codigo (int codigo){
           this.codigo = codigo;
           return this;
       }
       
       public Professor builderProfessor (){
           return new Professor(codigo, turno, especialidade, nome, telefone, email, endereco, cpf, idade);
       }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "\ncodigo = " + codigo + "\nturno = " + turno + "\nespecialidade = " + especialidade;
    }

}
