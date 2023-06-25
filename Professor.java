public class Professor extends Pessoa implements Comparable<Professor>{


    public Professor(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public int compareTo(Professor p1){
        return this.getNome().compareTo(p1.getNome());
    }

    @Override
    public String print() {
        return nome + " ";
    }
}
