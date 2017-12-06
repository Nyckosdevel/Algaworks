/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nyckos.recebimento.repositorios;

import com.nyckos.recebimento.modelo.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JAVAIN
 */
public interface TitulosRep extends JpaRepository<Titulo, Long> {

}
