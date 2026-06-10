package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ContaBancaria minhaGrana = new ContaBancaria();
        minhaGrana.depositar(500);
        System.out.println("Tenho R$ " + minhaGrana.getSaldo() );
        minhaGrana.sacar(100);
        System.out.println("Sobrou R$ " + minhaGrana.getSaldo() );
    }
}
