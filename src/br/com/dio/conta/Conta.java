package br.com.dio.conta;

import br.com.dio.cliente.Cliente;

public abstract class Conta implements Operacoes {

    protected static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int agencia;
    private int conta;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void sacar(double valor) {

        if (valor <= this.saldo) this.saldo -= valor;
        else System.out.println("Saldo insuficiente");
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {

        if (valor <= this.saldo) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente");
        }

    }

    protected String getExtratoConta() {
        return  "\n\t" + String.format("Titular: %s", this.cliente.getNome()) +
                "\n\t" + String.format("CPF: %s", this.cliente.getCpf()) +
                "\n\t" + String.format("Agência: %d", this.agencia) +
                "\n\t" + String.format("Conta: %d", this.conta) +
                "\n\t" + String.format("Saldo: %.2f", this.saldo);
    }

    public abstract String getExtrato();

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", conta=" + conta +
                ", saldo=" + saldo +
                '}';
    }
}
