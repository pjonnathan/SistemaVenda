package com.example.sistem.controller;

import com.example.sistem.models.entity.Cidade;
import com.example.sistem.models.entity.Estado;
import com.example.sistem.repositorys.CidadeRepository;
import com.example.sistem.repositorys.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping("/cadastrarCidade")
    public ModelAndView cadastrar(Cidade cidade){
        ModelAndView mv = new ModelAndView("administrativo/cidade/cadastro");
        mv.addObject("cidade", cidade);
        mv.addObject("listaEstado", estadoRepository.findAll());
        return mv;
    }

    @GetMapping("/listaCidade")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("administrativo/cidade/list");
        mv.addObject("listaCidade", cidadeRepository.findAll());
        return mv;
    }

    @GetMapping("/editarCidade/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        return cadastrar(cidade.get());
    }

    @GetMapping("/excluirCidade/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id){
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        cidadeRepository.delete(cidade.get());
        return listar();
    }

    @PostMapping("/salvarCidade")
    public ModelAndView salvar(@Validated Cidade cidade, BindingResult result) {
        if (result.hasErrors()) {
            return cadastrar(cidade);
        }

        if (cidade.getEstado() == null || cidade.getEstado().getId() == null) {
            throw new IllegalArgumentException("Estado não foi selecionado!");
        }

        // Garante que o estado existe no banco antes de salvar
        Estado estado = estadoRepository.findById(cidade.getEstado().getId())
                .orElseThrow(() -> new IllegalArgumentException("Estado inválido!"));

        cidade.setEstado(estado); // Vincula o estado corretamente
        cidadeRepository.saveAndFlush(cidade);

        return cadastrar(new Cidade());
    }
}
