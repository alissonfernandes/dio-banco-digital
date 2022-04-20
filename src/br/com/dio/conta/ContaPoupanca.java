package br.com.dio.conta;

import br.com.dio.cliente.Cliente;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String getExtrato() {
        return "==== EXTRATO CONTA POUPANÇA ====" +
                this.getExtratoConta() +
                "\n================================\n";
    }
}
