package br.com.dio.conta.customExceptions;

import br.com.dio.conta.Conta;

public class ContaDesativada extends Exception{

    public ContaDesativada(Conta conta) {
        super("A conta de n° " + conta.getNumeroConta() + " da agência " + conta.getAgencia() + " pertencente a " + conta.getCliente().getNome() + "(CPF: " + conta.getCliente().getCpf() + ") encontra-se desativada ");
    }
}
