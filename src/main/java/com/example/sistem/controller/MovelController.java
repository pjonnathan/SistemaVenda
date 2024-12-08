package com.example.sistem.controller;

import com.example.sistem.models.entity.Movel;
import com.example.sistem.repositorys.MovelRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovelController {

    @Autowired
    private MovelRespository movelRespository;

    @GetMapping("/cadastrarMovel")
    public ModelAndView cadastrar(Movel movel){
        ModelAndView mv = new ModelAndView("administrativo/movel/cadastro");
        mv.addObject("movel", movel);
        return mv;
    }

    @PostMapping("/salvarMovel")
    public ModelAndView salvar(Movel movel, BindingResult result){
        if(result.hasErrors()){
            return cadastrar(movel);
        }
        movelRespository.saveAndFlush(movel);
        return cadastrar(new Movel());
    }
}
