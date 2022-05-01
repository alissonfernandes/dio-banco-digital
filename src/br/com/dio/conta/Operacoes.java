package br.com.dio.conta;

import br.com.dio.conta.customExceptions.ContaBloqueada;
import br.com.dio.conta.customExceptions.SaldoInsuficiente;

public interface Operacoes {

    void depositar(double valor) throws ContaBloqueada;

    void sacar(double valor) throws SaldoInsuficiente, ContaBloqueada;

    void transferir(double valor, Conta contaDestino) throws SaldoInsuficiente, ContaBloqueada;
}
