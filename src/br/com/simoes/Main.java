package br.com.simoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> masculinos = new ArrayList<>();
        List<String> femininos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite o nome e o sexo separados por espaço (ou 'sair' para encerrar):");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            String[] partes = entrada.split(" ");
            if (partes.length != 2) {
                System.out.println("Entrada inválida. Certifique-se de digitar o nome e o sexo separados por espaço.");
                continue;
            }

            String nome = partes[0];
            String sexo = partes[1];

            if (sexo.equalsIgnoreCase("m") || sexo.equalsIgnoreCase("masculino")) {
                masculinos.add(nome + " (M)");
            } else if (sexo.equalsIgnoreCase("f") || sexo.equalsIgnoreCase("feminino")) {
                femininos.add(nome + " (F)");
            } else {
                System.out.println("Sexo inválido. Use 'm' ou 'f'.");
            }
        }

        List<String> todosOsNomes = new ArrayList<>();
        todosOsNomes.addAll(masculinos);
        todosOsNomes.addAll(femininos);

        System.out.println("\nLista de todos os nomes:");
        if (todosOsNomes.isEmpty()) {
            System.out.println("Nenhum nome foi inserido.");
        } else {
            System.out.println(String.join(", ", todosOsNomes));
        }

       
        
        Predicate<String> filtroFeminino = nome -> nome.contains("(F)");

        List<String> listaFemininos = todosOsNomes.stream()
                .filter(filtroFeminino)
                .collect(Collectors.toList());

        System.out.println("\nLista de nomes femininos:");
        if (listaFemininos.isEmpty()) {
            System.out.println("Nenhuma mulher foi inserida.");
        } else {
            System.out.println(String.join(", ", listaFemininos));
        }

        scanner.close();
    }
}
