/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nyckos.recebimento.modelo.enu;

public enum StatusTitulo {

//    PENDENTE("Pendente"),
//    RECEBIDO("Recebido");
//
//    private String descricao;
//
//    StatusTitulo(String descricao) {
//        this.descricao = descricao;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
    PENDENTE("Pendente", "label-danger"),
    RECEBIDO("Recebido", "label-success"),
    CANCELADO("Cancelado", "label-default");

    private final String descricao;
    private final String label;

    StatusTitulo(String descricao, String label) {
        this.descricao = descricao;
        this.label = label;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getLabel() {
        return this.label;
    }
}
