package br.univille.novostalentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.novostalentos.entity.Cidade;
import br.univille.novostalentos.service.CidadeService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired //Ela injeta o código para a criação de um novo objeto
    private CidadeService service;


    @GetMapping
    public ModelAndView index(){
        var listaCidades = service.getAll(); //Pega tudo!
        return new ModelAndView("cidade2/index", "listaCidades", listaCidades); 
    }
    @GetMapping(value="/novo")
    public ModelAndView novo(){
        var cidade = new Cidade();
        return new ModelAndView("cidade2/form", "cidade", cidade);
    }
    @PostMapping(params = "form")
    public ModelAndView save(Cidade cidade){
        service.save(cidade);
        return new ModelAndView("redirect:/cidades");
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar (@PathVariable("id") Long id){
        var umaCidade = service.findById(id);
        return new ModelAndView("cidade2/form", "cidade", umaCidade);
    }
}
    

