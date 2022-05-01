package br.com.dio.conta;

import br.com.dio.cliente.Cliente;
import br.com.dio.conta.customExceptions.ContaBloqueada;
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
    public void depositar(double valor) throws ContaBloqueada {
        if (this.verificaStatus()) this.saldo += valor;
    }


    @Override
    public void sacar(double valor) throws ContaBloqueada, SaldoInsuficiente {
        if (valor <= this.saldo && this.verificaStatus()) this.saldo -= valor;
        else throw new SaldoInsuficiente(this);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) throws SaldoInsuficiente, ContaBloqueada {
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

    public void desativarConta() {
        if (this.saldo > 0) System.out.println("Erro: esta conta não pode ser desativada, pois há saldo de R$" + this.saldo);
        else if (this.saldo < 0) System.out.println("ERRO: esta conta não pode ser desativada, pois há saldo negativado de R$" + this.saldo);
        else this.ativada = false;
    }

    private boolean verificaStatus() throws ContaBloqueada {
        if (this.bloqueado) throw new ContaBloqueada(this);
        else if (!this.ativada) System.out.println("Erro: operação negada. Esta conta se encontra inativa.");
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
