package com.example.sistem.controller;

import com.example.sistem.models.entity.Cidade;
import com.example.sistem.repositorys.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("/cadastrarCidade")
    public ModelAndView cadastrar(Cidade cidade){
        ModelAndView mv = new ModelAndView("administrativo/cidade/cadastro");
        mv.addObject("cidade", cidade);
        return mv;
    }

    @PostMapping("/salvarCidade")
    public ModelAndView salvar(Cidade cidade, BindingResult result){
        if (result.hasErrors()){
            return cadastrar(cidade);
        }
        cidadeRepository.saveAndFlush(cidade);
        return cadastrar(new Cidade());
    }
}
