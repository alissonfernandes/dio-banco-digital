package br.com.dio.conta.customExceptions;

import br.com.dio.conta.Conta;

public class SaldoInsuficiente extends Exception{

    public SaldoInsuficiente(Conta conta) {
        super("A conta de nº " + conta.getNumeroConta() + " da agência " + conta.getAgencia() + " possui saldo inferior do que foi solicitado para transferência ou saque.");
    }
}
