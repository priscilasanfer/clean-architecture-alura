package escola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    void naoDeveCriarTelefoneComOsDadosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "98768-0987"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", "98768-098"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", "8768-098"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("122", "98768-0982"));
    }

    @Test
    void deveCriarTelefonecom9Digitos() {
        Telefone telefone = new Telefone("11", "912316165");
        assertEquals("11", telefone.getDdd());
        assertEquals("912316165", telefone.getNumero());
    }
}