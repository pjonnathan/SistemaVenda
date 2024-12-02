package com.example.sistem.controller;

import com.example.models.entity.Estado;
import com.example.repositorys.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EstadoController {
    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping("/cadastroEstado")
    private ModelAndView cadastra(Estado estado){
        ModelAndView mv = new ModelAndView("administrativo/estado/cadastro");
        mv.addObject("estado", estado);
        return mv;
    }
}
