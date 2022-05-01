package br.com.dio.conta;

import br.com.dio.conta.customExceptions.SaldoInsuficiente;

public interface Operacoes {

    void depositar(double valor);

    void sacar(double valor) throws SaldoInsuficiente;

    void transferir(double valor, Conta contaDestino) throws SaldoInsuficiente;
}
