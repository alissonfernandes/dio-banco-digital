package br.com.dio.conta.customExceptions;

import br.com.dio.conta.Conta;

public class ContaBloqueada extends Exception{

    public ContaBloqueada(Conta conta) {
        super("A conta de n° " + conta.getNumeroConta() + " da agência " + conta.getAgencia() + " pertencente a " + conta.getCliente().getNome() + "(CPF: " + conta.getCliente().getCpf() + ") encontra-se bloqueada ");
    }
}
