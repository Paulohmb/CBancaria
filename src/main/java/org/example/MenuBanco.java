package org.example;

import java.util.Scanner;

public class MenuBanco {


    ContaBancaria minhaGrana = new ContaBancaria();

    /*Agora que você tem a classe ContaBancaria, altere o main para criar um objeto do tipo ContaBancaria,
    e depois ele fica num loop que primeiro mostra o saldo, depois mostra um menu com as opções
    1-Depositar, 2-Sacar, 0-Sair, e fica repetindo até a pessoa pedir pra sair.
    Se pedir pra sacar ou depositar, pede o valor e faz a operação.*/
    int opcao = 0;
    do{


        // criar o treco que digita
        Scanner teclado = new Scanner(System.in);


        System.out.printf("Saldo RS %.2f\n",minhaGrana.getSaldo());

        // digitar um valor pra depositar
        System.out.println("Quanto quer depositar?");
        double valor = teclado.nextDouble(); // puxa um double do teclado
        minhaGrana.depositar(valor);

        // imprime o saldo
        System.out.printf("Saldo: R$ %.2f\n", minhaGrana.getSaldo());


    }while(opcao != 0);
}
