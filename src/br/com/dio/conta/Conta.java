package br.com.dio.conta;

import br.com.dio.cliente.Cliente;

public abstract class Conta implements Operacoes {

    protected static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int agencia;
    private int conta;
    private double saldo;
    private Cliente cliente;
    private boolean bloqueado;
    private boolean ativada;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente = cliente;
        this.bloqueado = false;
        this.ativada = true;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }


    @Override
    public void sacar(double valor) {
        if (!this.ativada || this.bloqueado) System.out.println("Erro: operação negada. Esta conta se encontra inativa ou bloqueada");
        else {
            if (valor <= this.saldo) this.saldo -= valor;
            else System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {

        if (!this.ativada || this.bloqueado) System.out.println("Erro: operação negada. Esta conta se encontra inativa ou bloqueada");
        else if (contaDestino.isBloqueado() || !contaDestino.isAtivada()) System.out.println("Erro: conta destino encontra-se bloqueada ou desativada");
        else {
            if (valor <= this.saldo) {
                this.saldo -= valor;
                contaDestino.depositar(valor);
            } else {
                System.out.println("Saldo insuficiente");
            }
        }

    }

    protected String getExtratoConta() {
        return  "\n\t" + String.format("Titular: %s", this.cliente.getNome()) +
                "\n\t" + String.format("CPF: %s", this.cliente.getCpf()) +
                "\n\t" + String.format("Agência: %d", this.agencia) +
                "\n\t" + String.format("Conta: %d", this.conta) +
                "\n\t" + String.format("Saldo: R$ %.2f", this.saldo);
    }

    public abstract String getExtrato();

    public double getSaldo() {
        return saldo;
    }

    public void bloquearConta() {
        this.bloqueado = true;
    }

    public void desbloquearConta() {
        this.bloqueado = false;
    }

    public boolean isBloqueado() {
        return this.bloqueado;
    }

    public boolean isAtivada() {
        return this.ativada;
    }

    public void desativarConta() {
        if (this.saldo > 0) System.out.println("Erro: esta conta não pode ser desativada, pois há saldo de R$" + this.saldo);
        else if (this.saldo < 0) System.out.println("ERRO: esta conta não pode ser desativada, pois há saldo negativado de R$" + this.saldo);
        else this.ativada = false;
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
