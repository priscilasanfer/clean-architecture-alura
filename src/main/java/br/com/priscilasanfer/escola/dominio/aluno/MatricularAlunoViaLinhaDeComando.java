package br.com.priscilasanfer.escola.dominio.aluno;

import br.com.priscilasanfer.escola.aplicacao.aluno.matricula.MatricularAluno;
import br.com.priscilasanfer.escola.aplicacao.aluno.matricula.MatricularAlunoDto;
import br.com.priscilasanfer.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaLinhaDeComando {

    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "123.456.78900";
        String email = "fulano@email.com";

        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
        matricular.executa(new MatricularAlunoDto(nome, cpf, email));

    }
}

