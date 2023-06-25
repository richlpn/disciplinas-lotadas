import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sistema {
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Turma> turmas;

    public Sistema() {
        alunos = new ArrayList<>();
        professores = new ArrayList<>();
        turmas = new ArrayList<>();
    }

    // Métodos para leitura dos dados dos arquivos de entrada

    public void lerDadosAlunos(String nomeArquivo) {
        // Implementação para leitura dos dados dos alunos de um arquivo
        // Adicione os objetos Aluno à lista "alunos"
    }

    public void lerDadosProfessores(String nomeArquivo) {
        // Implementação para leitura dos dados dos professores de um arquivo
        // Adicione os objetos Professor à lista "professores"
    }

    public void lerDadosTurmas(String nomeArquivo) {
        // Implementação para leitura dos dados das turmas de um arquivo
        // Adicione os objetos Turma à lista "turmas"
    }

    // Método para exibir as notas e salvar no arquivo "saida.txt"

    public void exibirNotas() {
        // Ordenar os dados apropriadamente conforme as especificações mencionadas

        // Criar um StringBuilder para armazenar as informações a serem escritas no arquivo
        StringBuilder sb = new StringBuilder();

        for (Turma turma : turmas) {
            sb.append("Disciplina: ").append(turma.getNomeDisciplina()).append("\n");
            sb.append("Período Letivo: ").append(turma.getAno()).append(" - ").append(turma.getSemestre()).append("\n");
            sb.append("Professor Responsável: ").append(turma.getProfessor().getNome()).append("\n\n");

            // Outras informações relacionadas à turma

            // Adicionar as informações de cada aluno e sua nota
            for (AlunoNota alunoNota : turma.getAlunosNotas()) {
                sb.append("Aluno: ").append(alunoNota.getAluno().getNome()).append("\n");
                sb.append("Nota: ").append(alunoNota.getNota()).append("\n\n");
            }

            sb.append("----------------------------------------\n\n");
        }

        // Salvar as informações no arquivo "saida.txt"
        try {
            FileWriter writer = new FileWriter("saida.txt");
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
