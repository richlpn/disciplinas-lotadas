public abstract class Pessoa {
    protected String nome;
    protected String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }
    public String print(){
        return nome + " (" + cpf +") " ;
    }
}
