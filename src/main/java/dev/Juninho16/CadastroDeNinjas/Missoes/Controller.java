package dev.Juninho16.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/Missoes")
    public String boasVindas(){
            return "Essa é minha primeira mensagem";
        }

}

