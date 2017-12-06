/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nyckos.recebimento.servic;

import com.nyckos.recebimento.modelo.Titulo;
import com.nyckos.recebimento.repositorios.TitulosRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class RecebimentoServic {

    @Autowired
    TitulosRep titulos;

    public void salvar(Titulo titulo) {
        try {
            titulos.save(titulo);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Formato de data inválido");
        }
    }

    public void excluir(Long codigo) {
        titulos.delete(codigo);
    }
}
