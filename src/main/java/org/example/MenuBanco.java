package org.example;

import java.util.Scanner;

/*
 * Cuida da interacao entre o usuario e a conta bancaria.
 *
 * Esta classe mostra o menu, le os dados digitados e chama
 * os metodos da ContaBancaria.
 */
public class MenuBanco {

    /*
     * Constantes dao nomes claros aos numeros das opcoes.
     *
     * private: somente o MenuBanco precisa conhecer essas constantes.
     * static: existe uma unica copia de cada constante para toda a classe.
     * final: o valor nao pode ser modificado depois de definido.
     * int: as opcoes do menu sao numeros inteiros.
     */
    private static final int OPCAO_SAIR = 0;
    private static final int OPCAO_DEPOSITAR = 1;
    private static final int OPCAO_SACAR = 2;

    /*
     * private: esses objetos sao detalhes internos do MenuBanco.
     * final: as referencias nao serao trocadas depois do construtor.
     * Isso nao impede que os objetos sejam usados ou que a conta mude seu saldo.
     */
    private final Scanner teclado;
    private final ContaBancaria conta;

    /*
     * Recebe as dependencias que o menu precisa para trabalhar.
     *
     * public: a classe Main precisa criar um MenuBanco.
     * Assim como todo construtor, ele nao possui tipo de retorno.
     * teclado: objeto usado para ler o que o usuario digita.
     * conta: conta bancaria que sera movimentada.
     */
    public MenuBanco(Scanner teclado, ContaBancaria conta) {
        this.teclado = teclado;
        this.conta = conta;
    }

    /*
     * Executa o menu ate o usuario escolher a opcao de sair.
     *
     * public: Main precisa chamar este metodo para iniciar o menu.
     * void: o metodo controla o fluxo, mas nao devolve nenhum valor.
     */
    public void executar() {
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != OPCAO_SAIR);
    }

    /*
     * Exibe o saldo atual e as opcoes disponiveis.
     *
     * private: somente o proprio MenuBanco precisa exibir seu menu.
     * void: o metodo apenas imprime informacoes e nao devolve resultado.
     */
    private void exibirMenu() {
        System.out.printf("%nSaldo: R$ %.2f%n", conta.getSaldo());
        System.out.println("Escolha uma opcao:");
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("0 - Sair");
    }

    /*
     * Le uma opcao inteira.
     *
     * O while continua pedindo a opcao enquanto o usuario
     * nao digitar um numero inteiro valido.
     *
     * private: a leitura da opcao e um detalhe interno do menu.
     * int: o metodo precisa devolver a opcao inteira que foi digitada.
     */
    private int lerOpcao() {
        while (true) {
            try {
                return Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                // Esta excecao acontece quando o texto nao pode virar um int.
                System.out.println("Digite uma opcao numerica valida.");
            }
        }
    }

    /*
     * Decide qual acao executar de acordo com a opcao escolhida.
     *
     * private: somente o MenuBanco processa suas proprias opcoes.
     * void: ele chama a acao escolhida, mas nao devolve nenhum valor.
     */
    private void processarOpcao(int opcao) {
        // A sintaxe com -> evita a necessidade de usar break em cada caso.
        switch (opcao) {
            case OPCAO_DEPOSITAR -> realizarDeposito();
            case OPCAO_SACAR -> realizarSaque();
            case OPCAO_SAIR -> System.out.println("Saindo...");
            default -> System.out.println("Opcao invalida.");
        }
    }

    /*
     * Le o valor e solicita o deposito para a conta bancaria.
     *
     * private: esta acao so deve ser chamada pelo fluxo interno do menu.
     * void: o metodo executa o deposito, mas nao devolve um resultado.
     */
    private void realizarDeposito() {
        double valor = lerValor("Quanto quer depositar?");
        executarOperacao(() -> conta.depositar(valor), "Deposito realizado.");
    }

    /*
     * Le o valor e solicita o saque para a conta bancaria.
     *
     * private: esta acao so deve ser chamada pelo fluxo interno do menu.
     * void: o metodo executa o saque, mas nao devolve um resultado.
     */
    private void realizarSaque() {
        double valor = lerValor("Quanto quer sacar?");
        executarOperacao(() -> conta.sacar(valor), "Saque realizado.");
    }

    /*
     * Le um numero decimal digitado pelo usuario.
     *
     * O replace permite aceitar tanto 10.50 quanto 10,50.
     * private: somente o menu precisa desta forma de leitura.
     * double: o metodo devolve o valor decimal digitado.
     */
    private double lerValor(String mensagem) {
        while (true) {
            System.out.println(mensagem);

            try {
                String entrada = teclado.nextLine().trim().replace(',', '.');
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numerico valido.");
            }
        }
    }

    /*
     * Executa um deposito ou saque e trata possiveis erros.
     *
     * Runnable representa uma acao que pode ser executada.
     * A expressao () -> ... usada acima e chamada de lambda.
     *
     * private: este tratamento e uma ferramenta interna do menu.
     * void: o metodo executa a acao e mostra uma mensagem, sem devolver valor.
     */
    private void executarOperacao(Runnable operacao, String mensagemSucesso) {
        try {
            operacao.run();
            System.out.println(mensagemSucesso);
        } catch (IllegalArgumentException e) {
            // Mostra ao usuario a mensagem da validacao que falhou.
            System.out.println(e.getMessage());
        }
    }
}
