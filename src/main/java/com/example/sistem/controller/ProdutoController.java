package com.example.sistem.controller;

import com.example.sistem.models.entity.Produto;
import com.example.sistem.repositorys.PratileiraRespository;
import com.example.sistem.repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PratileiraRespository pratileiraRespository;

    @GetMapping("/cadastrarProduto")
    public ModelAndView cadastro(Produto produto){
        ModelAndView mv = new ModelAndView("administrativo/produto/cadastro");
        mv.addObject("produto", produto);
        mv.addObject("listaPratileira", pratileiraRespository.findAll());
        return mv;
    }

    @GetMapping("/listaProduto")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("administrativo/produto/list");
        mv.addObject("listaProduto", produtoRepository.findAll());
        return mv;
    }

    @GetMapping("/editarProduto/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return cadastro(produto.get());
    }

    @GetMapping("/excluirProduto/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        produtoRepository.delete(produto.get());
        return listar();
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
