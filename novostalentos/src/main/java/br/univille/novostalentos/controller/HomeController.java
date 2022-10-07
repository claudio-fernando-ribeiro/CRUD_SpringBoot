package br.univille.novostalentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller //Essa parte aqui chama o acesso ao localhost de forma automática.
@RequestMapping("/home") //O @ significa uma injeção de dependência, e aviso que ela deve 
//ser chamada por esse nome no meu navegador. Esse é o C(MVC).
public class HomeController {
//Sempre são necessárias duas coisas para.
//Não se deve misturar códigos (java e Html, por exemplo)
// Para que os códigos conversem, deve-se instalar o "Thymeleaf", que tem a mesma função do handlebars no JS. Isso permite a inserção de arquivois HTML dentro do projeto.
    
    private int contador;
    
    @GetMapping //Qual o método deve ser executado na resposta da requisição (GET)
    //@ResponseBody// Aqui digo o que ele deve respoder - No caso o corpo da resposta. 
    public ModelAndView index(){//A assinatura do método "ModelAndView" - Modelo e Tela. 
        contador++;
        return new ModelAndView("home/index", "valor", contador);

    }
    
}
