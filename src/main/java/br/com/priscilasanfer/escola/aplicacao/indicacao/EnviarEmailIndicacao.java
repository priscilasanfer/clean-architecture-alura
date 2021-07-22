package br.com.priscilasanfer.escola.aplicacao.indicacao;

import br.com.priscilasanfer.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
    void enviarPara(Aluno indicado);
}
