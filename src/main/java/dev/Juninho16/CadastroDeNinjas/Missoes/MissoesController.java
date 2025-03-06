package dev.Juninho16.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //GET -- Mandar requisição parar listar missões
    @GetMapping("/listar")
    public String listarMissao(){
        return "Listar missões";
    }

    //POST -- Mandar requisição parar criar missões
    @PostMapping("/criar")
    public String criarMissao(){
        return "Cria missão";
    }

    //PUT -- Mandar requisição parar alterar missões
    @PutMapping("/alterar")
    public String aletrarMissao(){
        return "Altera missão";
    }

    //DELETE -- Mandar requisição parar deletar missões
    @DeleteMapping("/deletar")
    public String deletaMissao(){
        return "Deleta missão";
    }


}
