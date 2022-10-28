package br.univille.novostalentos.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.novostalentos.entity.Cliente;
import br.univille.novostalentos.entity.Cliente;
import br.univille.novostalentos.repository.ClienteRepository;
import br.univille.novostalentos.service.CidadeService;
import br.univille.novostalentos.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService service;
    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ModelAndView index(){
        var listaClientes = service.getAll();
        return new ModelAndView("cliente/index","listaClientes",listaClientes);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();
        var listaCidades = cidadeService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("cliente", cliente);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("cliente/form", dados);
    } //Nesse caso preciso passar os dois objetos para a tela, (não deve passar lista). Para passar isso devemos usar uma coleção. Nesse caso o HashMap que é um objeto que guarda duas coisas por posição, uma KEY e um Value, a chave nunca pode repetir. 

    @PostMapping(params = "form")
    public ModelAndView save(@Valid Cliente cliente, BindingResult bindingResult){ //essa anotação só permite dados válidos, ela é realizada em conjunto com a anotação @NotBlank na camada Cliente da entidade. 
        if (bindingResult.hasErrors()){ //Aqui informo que se der um erro é para retornar para a tela do cliente, sem salvar no BD. 
            var listaCidades = cidadeService.getAll();
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("cliente", cliente);
            dados.put("listaCidades", listaCidades);
            return new ModelAndView("cliente/form", dados);
        }
        service.save(cliente);
        return new ModelAndView("redirect:/clientes");
    }
    
    @GetMapping("/alterar/{id}")//Aqui o ID está entre chaves porque eu não tenho o número exato dele.
    public ModelAndView alterar(@PathVariable("id") long id){//Aqui estou pedindo para que o numero que for carregado substitua ID.
        var umCliente = service.findById(id);
        var listaCidades = cidadeService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("cliente", umCliente);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("cliente/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/clientes");
    }
}