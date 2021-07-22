package br.com.priscilasanfer.escola.infra.indicacao;

import br.com.priscilasanfer.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.priscilasanfer.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {
    @Override
    public void enviarPara(Aluno indicado) {
        // logica de envio de email com a lib Java Mail
    }
}
