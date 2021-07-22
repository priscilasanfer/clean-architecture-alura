package br.com.priscilasanfer.escola.aplicacao.aluno.matricula;

import br.com.priscilasanfer.escola.dominio.aluno.Aluno;
import br.com.priscilasanfer.escola.dominio.aluno.Cpf;
import br.com.priscilasanfer.escola.dominio.aluno.Email;

public class MatricularAlunoDto {
    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;

    public MatricularAlunoDto(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }


    public Aluno criarAluno() {
        return new Aluno(
                new Cpf(cpfAluno),
                nomeAluno,
                new Email(emailAluno));
    }
}
