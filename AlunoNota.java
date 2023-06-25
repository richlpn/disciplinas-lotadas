public class AlunoNota implements Comparable<AlunoNota  >{
    public Aluno aluno;
    public double nota;


    public AlunoNota(Aluno aluno, double nota) {
        this.aluno = aluno;
        this.nota = nota;
    }

    @Override
    public int compareTo(AlunoNota o) {
        if(this.nota < o.nota) return -1;
        else if(this.nota > o.nota) return 1;
        else return 0;
    }


    @Override
    public String toString() {
        return "- " + aluno.print() + ": "+ nota;
    }
}
