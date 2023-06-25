class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        sistema.lerDadosAlunos("./Exemplos/aluno.txt");
        sistema.lerDadosProfessores("./Exemplos/professor.txt");
        sistema.lerDadosTurma("./Exemplos/turma.txt");
        sistema.exibirNotas();

    }
}