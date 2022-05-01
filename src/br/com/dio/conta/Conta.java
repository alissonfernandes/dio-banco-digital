package br.com.dio.conta;

import br.com.dio.cliente.Cliente;
import br.com.dio.conta.customExceptions.ContaBloqueada;
import br.com.dio.conta.customExceptions.ContaDesativada;
import br.com.dio.conta.customExceptions.ContaNaoPodeSerDesativada;
import br.com.dio.conta.customExceptions.SaldoInsuficiente;

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
    public void depositar(double valor) throws ContaBloqueada, ContaDesativada {
        if (this.verificaStatus()) this.saldo += valor;
    }


    @Override
    public void sacar(double valor) throws ContaBloqueada, SaldoInsuficiente, ContaDesativada {
        if (valor <= this.saldo && this.verificaStatus()) this.saldo -= valor;
        else throw new SaldoInsuficiente(this);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) throws SaldoInsuficiente, ContaBloqueada, ContaDesativada {
        if (valor <= this.saldo && this.verificaStatus()) {
            contaDestino.depositar(valor);
            this.saldo -= valor;
        } else throw new SaldoInsuficiente(this);
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

    public void desativarConta() throws ContaNaoPodeSerDesativada {
        if (this.saldo > 0) throw new ContaNaoPodeSerDesativada(this, "Há saldo em conta");
        else if (this.saldo < 0) throw new ContaNaoPodeSerDesativada(this, "Há saldo negativado em conta");
        else this.ativada = false;
    }

    private boolean verificaStatus() throws ContaBloqueada, ContaDesativada {
        if (this.bloqueado) throw new ContaBloqueada(this);
        else if (!this.ativada) throw new ContaDesativada(this);
        return true;
    }

    public int getNumeroConta() {
        return conta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getAgencia() {
        return agencia;
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
