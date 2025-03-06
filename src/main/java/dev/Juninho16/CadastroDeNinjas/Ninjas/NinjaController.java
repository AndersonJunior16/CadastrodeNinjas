package dev.Juninho16.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem";
    }


    //Adicionar ninjas (CREATE)
    @PostMapping("/adicionar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //Prucurar Ninja ID (READ)
    @GetMapping("/ninjaid")
    public String mostrarNinjaId(){
        return "Mostrar ninja por ID";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosNinjas(){
        return "Mostrar ninjas";
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinja(){
        return "Altera ninja por id";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletaID")
    public String deletarNinja(){
        return "Deleta ninja";
    }

}
