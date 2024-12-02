package com.example.sistem.controller;

import com.example.sistem.models.entity.Estado;
import com.example.sistem.repositorys.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class EstadoController {
    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping("/cadastro")
    public ModelAndView cadastrar(Estado estado) {
        ModelAndView mv = new ModelAndView("administrativo/estado/cadastro");
        mv.addObject("estado", estado);
        return mv;
    }

    @GetMapping("/listaEstado")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("administrativo/estado/list");
        mv.addObject("listaEstado", estadoRepository.findAll());
        return mv;
    }

    @GetMapping("/editarEstado/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        return cadastrar(estado.get());
    }

    @GetMapping("/excluirEstado/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        estadoRepository.delete(estado.get());
        return listar();
    }

    @PostMapping("/salvarEstado")
    public ModelAndView salvar(Estado estado, BindingResult result){
        if(result.hasErrors()){
            return cadastrar(estado);
        }
        estadoRepository.saveAndFlush(estado);
        return cadastrar(new Estado());
    }


}
