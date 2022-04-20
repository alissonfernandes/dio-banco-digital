package br.com.dio.enums;

public enum ContaTipo {

    POPUPANCA("POUPANCA"),
    CORENTE("CORRENTE");

    private final String contaTipo;

    ContaTipo(String contaTipo) {
        this.contaTipo = contaTipo;
    }
}
