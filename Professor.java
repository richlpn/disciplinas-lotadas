public class Professor extends Pessoa implements Comparable<Professor>{
    @Override 
    public int compareTo(Professor p1){
        return this.nome.compareTo(p1.nome);
    }
}
