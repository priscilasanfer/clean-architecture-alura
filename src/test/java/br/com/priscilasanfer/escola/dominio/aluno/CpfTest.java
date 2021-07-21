package br.com.priscilasanfer.escola.dominio.aluno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CpfTest {

    @Test
    void naoDeveCriarCpfQuandoONumeroNaoForValido() {
        assertThrows(IllegalArgumentException.class, ()-> new Cpf(null));
        assertThrows(IllegalArgumentException.class, ()-> new Cpf(""));
        assertThrows(IllegalArgumentException.class, ()-> new Cpf("12.54.54-843"));
        assertThrows(IllegalArgumentException.class, ()-> new Cpf("123"));
        assertThrows(IllegalArgumentException.class, ()-> new Cpf("12345678910"));
    }

    @Test
    void deveCriarOCpfCorretamente() {
        Cpf cpf = new Cpf("123.456.789-10");
        assertEquals("123.456.789-10", cpf.getNumero());
    }
}