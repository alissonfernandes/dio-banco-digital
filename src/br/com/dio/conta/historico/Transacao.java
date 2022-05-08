package br.com.dio.conta.historico;

import br.com.dio.conta.Conta;
import br.com.dio.enums.TipoOperacao;

import java.util.Date;

public class Transacao {

    private Date data;
    private Conta origem;
    private Conta destino;
    private TipoOperacao tipoOperacao;
    private double valor;

    public Transacao( TipoOperacao tipoOperacao, Conta origem, Conta destino, double valor) {
        this.data = new Date();
        this.tipoOperacao = tipoOperacao;
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    public Date getData() {
        return this.data;
    }

    public Conta getOrigem() {
        return origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public double getValor() {
        return valor;
    }
}
