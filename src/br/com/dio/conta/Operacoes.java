package br.com.dio.conta;

import br.com.dio.conta.Conta;

public interface Operacoes {

    void depositar(double valor);

    void sacar(double valor);

    void transferir(double valor, Conta contaDestino);
}
