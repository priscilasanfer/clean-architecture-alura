package br.com.priscilasanfer.escola.aplicacao.aluno.matricula;

import br.com.priscilasanfer.escola.dominio.aluno.Aluno;
import br.com.priscilasanfer.escola.dominio.aluno.Cpf;
import br.com.priscilasanfer.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {
    @Test
    void alunoDeveriaSerPersistido() {
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);

        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano",
                "123.456.789-00",
                "fulano@teste.com");
        useCase.executa(dados);

        Aluno alunoEncontrado = repositorio.buscarPorCpf(new Cpf("123.456.789-00"));

        assertEquals("Fulano", alunoEncontrado.getNome());
        assertEquals("123.456.789-00", alunoEncontrado.getCpf());
        assertEquals("fulano@teste.com", alunoEncontrado.getEmail());

    }
}