import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            int numAlunos = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numAlunos; i++) {
                String nome = reader.readLine();
                String cpf = reader.readLine();
                String matricula = reader.readLine();

                Aluno aluno = new Aluno(nome, cpf, matricula);
                alunos.add(aluno);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler Aluno " + e.getMessage());
        }
    }

    public void lerDadosProfessores(String nomeArquivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            int numProfessores = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numProfessores; i++) {
                String nome = reader.readLine();
                String cpf = reader.readLine();

                Professor professor = new Professor(nome, cpf);
                professores.add(professor);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo professor");
        }
    }

    private Aluno buscarAlunoPorMatricula(String matricula) throws AlunoNotFoundException {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        throw new AlunoNotFoundException();
    }

    private Professor buscarProfessorPorCPF(String cpf) throws ProfessorNotFoundException {
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                return professor;
            }
        }
        throw new ProfessorNotFoundException();
    }
    private void lerAlunosTurma(BufferedReader reader, Turma turma) throws IOException{

        int numAlunos = Integer.parseInt(reader.readLine());

        for (int j = 0; j < numAlunos; j++) {
            String matricula = reader.readLine();
            double nota = Double.parseDouble(reader.readLine());

            try {
                Aluno aluno = buscarAlunoPorMatricula(matricula);
                AlunoNota alunoNota = new AlunoNota(aluno, nota);
                turma.adicionarAlunoNota(alunoNota);
            } catch (AlunoNotFoundException e) {
                System.out.println("Aviso: Aluno não encontrado.");
            }
        }
    }
    public void lerDadosTurma(String nomeArquivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));

            // Quantidade de turmas
            int numTurmas = Integer.parseInt(reader.readLine());

            //Passa por cada turma no arquivo e carrega os dados
            //Erro são tratados como pedido na especificação
            for (int i = 0; i < numTurmas; i++) {
                String disciplina = reader.readLine();
                int ano = Integer.parseInt(reader.readLine());
                int semestre = Integer.parseInt(reader.readLine());

                String cpfProfessor = reader.readLine();
                Professor professor;
                Turma turma = null;

                try {
                    professor = buscarProfessorPorCPF(cpfProfessor);
                    turma = new Turma(disciplina, ano, semestre, professor);
                } catch (ProfessorNotFoundException e) {
                    System.out.println("Aviso: Professor nao encontrado");
                    System.exit(1);
                }
                lerAlunosTurma(reader, turma);
                turmas.add(turma);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo " + e.getMessage());
        }
    }


    public void exibirNotas() {

        StringBuilder sb = new StringBuilder();
        for (Turma turma : turmas) {
            sb.append(turma).append("\n");
        }
        // Salvar as informações no arquivo "saida.txt"
        try {
            FileWriter writer = new FileWriter("saida.txt");
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo saida.txt " + e.getMessage());
        }
    }
}
