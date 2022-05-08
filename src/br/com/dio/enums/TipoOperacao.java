package br.com.dio.enums;

public enum TipoOperacao {

    ENTRADA("ENTRADA"),
    SAIDA("SAIDA");
    private final String operacaoTipo;

    TipoOperacao(String tipoOperacao){this.operacaoTipo = tipoOperacao;}
}
