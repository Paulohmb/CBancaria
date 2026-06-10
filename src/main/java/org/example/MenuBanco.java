package org.example;

import java.util.Scanner;

public class MenuBanco {

    public void Menu() {
        Scanner teclado = new Scanner(System.in);
        ContaBancaria minhaGrana = new ContaBancaria();

        int opcao;

        do {
            System.out.printf("\nSaldo: R$ %.2f\n", minhaGrana.getSaldo());

            System.out.printf("1 - Depositar");
            System.out.printf("2 - Sacar");
            System.out.printf("0 - Sair");
            System.out.printf("Escolha uma opção: ");

            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.printf("Quanto quer depositar? ");
                    double valorDeposito = teclado.nextDouble();
                    minhaGrana.depositar(valorDeposito);
                    break;

                case 2:
                    System.out.print("Quanto quer sacar? ");
                    double valorSaque = teclado.nextDouble();
                    minhaGrana.sacar(valorSaque);
                    break;

                case 0:
                    System.out.printf("Saindo...");
                    break;

                default:
                    System.out.printf("Opção inválida.");
                    break;
            }

        } while (opcao != 0);
    }
}