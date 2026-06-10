package org.example;

import java.util.Scanner;

public class MenuBanco {

    public void Menu() {
        Scanner teclado = new Scanner(System.in);
        ContaBancaria minhaGrana = new ContaBancaria();

        int opcao;

        do {
            System.out.printf("\nSaldo: R$ %.2f\n", minhaGrana.getSaldo());

            System.out.printf("Escolha uma opção: \n ");
            System.out.printf("1 - Depositar\n ");
            System.out.printf("2 - Sacar\n ");
            System.out.printf("0 - Sair\n ");


            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.printf("Quanto quer depositar? \n ");
                    double valorDeposito = teclado.nextDouble();
                    if(valorDeposito <= 0){
                        System.out.printf("Deposite valores positivos\n ");
                        continue;
                    }
                    minhaGrana.depositar(valorDeposito);
                    break;

                case 2:
                    System.out.printf("Quanto quer sacar?\n ");
                    double valorSaque = teclado.nextDouble();
                    if(valorSaque <= 0){
                        System.out.printf("Saque valores positivos\n ");
                        continue;
                    }
                    minhaGrana.depositar(valorSaque);
                    break;
                case 3:
                    System.out.printf("Saindo...\n ");
                    break;

                default:
                    System.out.printf("Saindo...\n ");
            }
        } while (opcao != 0);
    }
}

