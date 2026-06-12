package org.example;

/*
 * Representa uma conta bancaria.
 *
 * Esta classe guarda o saldo e possui as regras de deposito e saque.
 * Isso e um exemplo de encapsulamento: o saldo e privado e somente
 * pode ser alterado pelos metodos da propria classe.
 */
public class ContaBancaria {

    /*
     * private: somente a propria ContaBancaria pode acessar o saldo diretamente.
     * Isso protege o valor contra alteracoes que nao passem pelas regras
     * dos metodos depositar e sacar.
     *
     * double: o saldo pode possuir casas decimais, como 100,50.
     */
    private double saldo;

    /*
     * Construtor usado para criar uma conta com um saldo inicial.
     *
     * public: outras classes, como Main, precisam criar objetos ContaBancaria.
     * O construtor nao possui tipo de retorno, nem mesmo void, porque sua
     * funcao e construir e inicializar um objeto.
     * saldoInicial: valor que a conta tera quando for criada.
     */

    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }

    /*
     * Adiciona um valor ao saldo da conta.
     *
     * public: o menu precisa solicitar um deposito.
     * void: o metodo altera o saldo, mas nao precisa devolver um resultado.
     * valor: quantia que sera depositada.
     */
    public void depositar(double valor) {
        validarValorPositivo(valor);
        saldo += valor;
    }

    /*
     * Retira um valor do saldo, desde que exista dinheiro suficiente.
     *
     * public: o menu precisa solicitar um saque.
     * void: o metodo altera o saldo, mas nao devolve nenhum valor.
     * Se houver um problema, ele lanca uma excecao com a explicacao.
     * valor: quantia que sera sacada.
     */
    public void sacar(double valor) {
        validarValorPositivo(valor);

        // O saque nao pode ser maior do que o saldo disponivel.
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

        saldo -= valor;
    }

    /*
     * Permite consultar o saldo sem permitir sua alteracao direta.
     *
     * public: outras classes precisam consultar o saldo.
     * double: diferente de void, indica que o metodo devolve um numero decimal.
     * O valor devolvido e o saldo atual da conta.
     */
    public double getSaldo() {

        return saldo;
    }

    /*
     * Centraliza uma validacao usada tanto no deposito quanto no saque.
     *
     * private: somente a ContaBancaria precisa usar esta validacao.
     * Ela nao faz parte das operacoes que o usuario pode solicitar.
     *
     * void: o metodo nao precisa devolver um valor. Se o valor for valido,
     * ele simplesmente termina; se for invalido, lanca uma excecao.
     */
    private void validarValorPositivo(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser positivo.");
        }
    }
}
