package br.com.dio.conta.customExceptions;

import br.com.dio.conta.Conta;

public class ContaNaoPodeSerDesativada extends Exception{

    public ContaNaoPodeSerDesativada(Conta conta, String motivo) {
        super("A conta de nº " + conta.getNumeroConta() + " da agência " + conta.getAgencia() + " não pode ser desativada. Motivo: " + motivo);
    }
}
