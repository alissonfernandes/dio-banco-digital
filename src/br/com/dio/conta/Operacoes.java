package br.com.dio.conta;

import br.com.dio.conta.customExceptions.ContaBloqueada;
import br.com.dio.conta.customExceptions.ContaDesativada;
import br.com.dio.conta.customExceptions.SaldoInsuficiente;

public interface Operacoes {

    void depositar(double valor, Conta origem) throws ContaBloqueada, ContaDesativada;

    void sacar(double valor) throws SaldoInsuficiente, ContaBloqueada, ContaDesativada;

    void transferir(double valor, Conta contaDestino) throws SaldoInsuficiente, ContaBloqueada, ContaDesativada;
}
