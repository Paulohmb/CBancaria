package org.example;

import java.util.Scanner;

/*
 * Classe principal da aplicacao.
 *
 * Sua unica responsabilidade e criar os objetos necessarios
 * e iniciar o menu do banco.
 */
public class Main {

    /*
     * O metodo main e o ponto de entrada do programa.
     *
     * public: a maquina virtual Java precisa conseguir acessar este metodo.
     * static: permite executar o metodo sem criar um objeto da classe Main.
     * void: o metodo inicia o programa, mas nao devolve nenhum valor.
     * String[] args: recebe argumentos informados ao iniciar o programa.
     */
    public static void main(String[] args) {
        // Cria uma conta bancaria que comeca com R$ 1.000,00.
        ContaBancaria conta = new ContaBancaria(1000.0);

        /*
         * O try-with-resources fecha o Scanner automaticamente
         * quando o programa termina.
         */
        try (Scanner teclado = new Scanner(System.in)) {
            // O menu recebe os objetos de que precisa para funcionar.
            MenuBanco menu = new MenuBanco(teclado, conta);

            // Inicia a repeticao do menu.
            menu.executar();
        }
    }
}
