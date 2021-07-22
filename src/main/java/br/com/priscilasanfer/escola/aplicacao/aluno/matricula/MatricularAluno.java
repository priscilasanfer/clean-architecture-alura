package br.com.priscilasanfer.escola.aplicacao.aluno.matricula;

import br.com.priscilasanfer.escola.dominio.aluno.Aluno;
import br.com.priscilasanfer.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
    private final RepositorioDeAlunos repositorio;

    public MatricularAluno(RepositorioDeAlunos repositorio) {
        this.repositorio = repositorio;
    }

    // Command
    public void executa(MatricularAlunoDto dados) {
        Aluno novo = dados.criarAluno();
        repositorio.matricular(novo);
    }
}
