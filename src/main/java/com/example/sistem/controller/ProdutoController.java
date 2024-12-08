package com.example.sistem.controller;

import com.example.sistem.models.entity.Produto;
import com.example.sistem.repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/cadastrarProduto")
    public ModelAndView cadastro(Produto produto){
        ModelAndView mv = new ModelAndView("administrativo/produto/cadastro");
        mv.addObject("produto", produto);
        return mv;
    }

    @PostMapping("/salvarProduto")
    public ModelAndView salvar(Produto produto, BindingResult result){
        if (result.hasErrors()){
            return cadastro(produto);
        }
        produtoRepository.saveAndFlush(produto);
        return cadastro(new Produto());
    }
}
