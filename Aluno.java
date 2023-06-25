public class Aluno extends Pessoa implements Comparable<Aluno> {

    private String matricula;

    Aluno(String nome, String cpf, String mat) {
        super(nome, cpf);
        this.matricula = mat;
    }

    @Override
    public int compareTo(Aluno a2) {
        return (this.getNome().compareTo(a2.getNome()));
    }


    public String getMatricula() {
        return this.matricula;
    }

}
