package br.com.simoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                masculinos.add(nome);
            } else if (sexo.equalsIgnoreCase("f") || sexo.equalsIgnoreCase("feminino")) {
                femininos.add(nome);
            } else {
                System.out.println("Sexo inválido. Use 'm' ou 'f'.");
            }
        }


        System.out.println("\nPessoas do sexo masculino:");
        if (masculinos.isEmpty()) {
            System.out.println("Nenhum");
        } else {
            System.out.println(String.join(", ", masculinos));
        }

        System.out.println("\nPessoas do sexo feminino:");
        if (femininos.isEmpty()) {
            System.out.println("Nenhum");
        } else {
            System.out.println(String.join(", ", femininos));
        }

        scanner.close();
    }
}
