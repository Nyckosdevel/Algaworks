/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nyckos.recebimento.controle;

import com.nyckos.recebimento.modelo.Titulo;
import com.nyckos.recebimento.modelo.enu.StatusTitulo;
import com.nyckos.recebimento.repositorios.TitulosRep;
import com.nyckos.recebimento.servic.RecebimentoServic;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todos")
public class TituloControle {

    @Autowired
    TitulosRep titulos;

    @Autowired
    RecebimentoServic recebimentoServic;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mav = new ModelAndView("Cadastro");
        mav.addObject(new Titulo());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return "Cadastro";
        }
        try {
            recebimentoServic.salvar(titulo);
            ra.addFlashAttribute("mensagem", "Título salvo com sucesso");
            return "redirect:/todos/novo";
        } catch (IllegalArgumentException e) {
            errors.rejectValue("dataVencimento", null, e.getMessage());
            return "Cadastro";
        }
    }

    @RequestMapping()
    public ModelAndView pesquisa() {
        List<Titulo> todosTitulos = this.titulos.findAll();
        ModelAndView mav = new ModelAndView("Busca");
        mav.addObject("titulos", todosTitulos);
        return mav;
    }

    @RequestMapping("{codigo}")
    public ModelAndView editar(@PathVariable("codigo") Titulo tt) {
        ModelAndView mav = new ModelAndView("Cadastro");
        mav.addObject(tt);
        return mav;
    }

    @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable Long codigo, RedirectAttributes ra) {
        recebimentoServic.excluir(codigo);

        ra.addFlashAttribute("mensagem", "Título excluido com sucesso");
        return "redirect:/todos";
    }

    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulo> todosStatusTitulo() {
        return Arrays.asList(StatusTitulo.values());
    }
}
