package br.com.dio.conta;

import br.com.dio.cliente.Cliente;

public class ContaCorrente extends Conta {


    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String getExtrato() {
        return "==== EXTRATO CONTA CORRENTE ====" +
                this.getExtratoConta() +
                "\n================================\n";
    }

}
