package br.com.dio.banco;

import br.com.dio.cliente.Cliente;
import br.com.dio.conta.Conta;
import br.com.dio.conta.ContaCorrente;
import br.com.dio.conta.ContaPoupanca;
import br.com.dio.enums.ContaTipo;

public class Banco {

    public Conta criarConta(Cliente cliente, ContaTipo contaTipo) {
        if (contaTipo == ContaTipo.CORENTE) return new ContaCorrente(cliente);
        else return new ContaPoupanca(cliente);
    }

    public void bloquearConta(Conta conta) {
        conta.bloquearConta();
    }

    public void desbloquearConta(Conta conta) {
        conta.desbloquearConta();
    }

    public void desativarConta(Conta conta) {
        conta.desativarConta();
    }
}
