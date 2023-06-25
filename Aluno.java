public class Aluno extends Pessoa implements Comparable<Aluno> {
    
    Aluno(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override 
    public int compareTo(Aluno a2){
        return (this.nome.compareTo(a2.nome));
    }
}
