package br.com.priscilasanfer.escola.aluno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {

    @Test
    void naoDeveriaCriarEmailComEnderecoInvalido() {
        assertThrows(IllegalArgumentException.class, ()-> new Email(null));
        assertThrows(IllegalArgumentException.class, ()-> new Email(""));
        assertThrows(IllegalArgumentException.class, ()-> new Email("teste.com"));
    }

    @Test
    void deveCriarEmailCorretamente() {
        Email email = new Email("teste@gmail.com.br");
        assertEquals("teste@gmail.com.br", email.getEndereco());
    }
}