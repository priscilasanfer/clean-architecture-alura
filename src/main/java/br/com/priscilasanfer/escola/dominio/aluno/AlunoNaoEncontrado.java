package br.com.priscilasanfer.escola.dominio.aluno;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(Cpf cpf) {
        super("Aluno nao encontrado com o CPF: " + cpf.getNumero());
    }
}
