import java.util.ArrayList;
import java.util.List;

public class Turma implements Comparable<Turma> {
    private String nomeDisciplina;
    private int ano;
    private int semestre;
    private Professor profResp; //Professor resposanvel;
    private List<AlunoNota> alunosNotas;

    public Turma(String nomeDisciplina, int ano, int semestre, Professor profResp) {
        this.nomeDisciplina = nomeDisciplina;
        this.ano = ano;
        this.semestre = semestre;
        this.profResp = profResp;
        this.alunosNotas = new ArrayList<>();
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public int getAno() {
        return ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public Professor getProfessor() {
        return profResp;
    }

    public List<AlunoNota> getAlunosNotas() {
        return alunosNotas;
    }

    public void adicionarAlunoNota(AlunoNota alunoNota) {
        alunosNotas.add(alunoNota);
    }

    @Override
    public int compareTo(Turma outraTurma) {
        // Comparação com base no ano e semestre da turma
        if (this.ano != outraTurma.ano) return Integer.compare(this.ano, outraTurma.ano);
        if (this.semestre != outraTurma.semestre) return Integer.compare(this.semestre, outraTurma.semestre);

        // Comparação com base no nome da disciplina (ordem alfabética)
        int comparacaoDisciplina = this.nomeDisciplina.compareTo(outraTurma.nomeDisciplina);
        if (comparacaoDisciplina != 0) return comparacaoDisciplina;

        // Comparação com base no professor responsável
        return this.profResp.compareTo(outraTurma.profResp);
    }
}
