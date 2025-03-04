package br.com.simoes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class MainTest {

    private static List<String> filtrarMulheres(List<String> nomes) {
        Predicate<String> filtroFeminino = nome -> nome.contains("(F)");
        return nomes.stream().filter(filtroFeminino).collect(Collectors.toList());
    }

    @Test
    void testListaFemininosContemApenasMulheres() {
        List<String> nomes = new ArrayList<>();
        nomes.add("Ana (F)");
        nomes.add("João (M)");
        nomes.add("Maria (F)");
        nomes.add("Carlos (M)");

        List<String> femininos = filtrarMulheres(nomes);

        assertFalse(femininos.isEmpty(), "A lista de mulheres não deve estar vazia.");
        assertTrue(femininos.stream().allMatch(nome -> nome.contains("(F)")), 
            "Todos os nomes na lista de mulheres devem conter '(F)'.");
    }

    @Test
    void testListaSemMulheres() {
        List<String> nomes = List.of("João (M)", "Carlos (M)");

        List<String> femininos = filtrarMulheres(nomes);

        assertTrue(femininos.isEmpty(), "A lista de mulheres deve estar vazia.");
    }

    @Test
    void testListaComApenasMulheres() {
        List<String> nomes = List.of("Ana (F)", "Maria (F)", "Juliana (F)");

        List<String> femininos = filtrarMulheres(nomes);

        assertEquals(nomes, femininos, "A lista filtrada deve ser igual à lista original.");
    }
}
