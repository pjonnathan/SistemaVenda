package com.example.sistem.controller;

import com.example.sistem.models.entity.Pratileira;
import com.example.sistem.repositorys.MovelRespository;
import com.example.sistem.repositorys.PratileiraRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PratileiraController {

    @Autowired
    private PratileiraRespository pratileiraRespository;

    @Autowired
    private MovelRespository movelRespository;


    @GetMapping("/cadastrarPratileira")
    public ModelAndView cadastrar(Pratileira pratileira){
        ModelAndView mv = new ModelAndView("administrativo/pratileira/cadastro");
        mv.addObject("pratileira", pratileira);
        mv.addObject("listaMovel", movelRespository.findAll());
        return mv;
    }

    @GetMapping("/listaPratileira")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("administrativo/pratileira/list");
        mv.addObject("listaPratileira", pratileiraRespository.findAll());
        return mv;
    }

    @PostMapping("/salvarPratileria")
    public ModelAndView salvar(Pratileira pratileira, BindingResult result){
        if (result.hasErrors()){
            return cadastrar(pratileira);
        }
        pratileiraRespository.saveAndFlush(pratileira);
        return cadastrar(new Pratileira());
    }
}
