package br.com.priscilasanfer.escola.dominio.aluno;

import java.util.List;

public interface RepositorioDeAlunos {

    void matricular(Aluno aluno);

    Aluno buscarPorCpf(Cpf cpf);

    List<Aluno> listarTodosAlunosMatriculados();

}
