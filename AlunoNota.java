public class AlunoNota implements Comparable<AlunoNota  >{
    public Aluno aluno;
    public double nota;

    @Override
    public int compareTo(AlunoNota o) {
        if(this.nota < o.nota) return -1;
        else if(this.nota > o.nota) return 1;
        else return 0;
    }
    
}
