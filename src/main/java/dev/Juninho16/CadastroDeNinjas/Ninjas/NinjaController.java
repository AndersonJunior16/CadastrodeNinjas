package dev.Juninho16.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem";
    }


    //Adicionar ninjas (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //Prucurar Ninja ID (READ)
    @GetMapping("/listarid")
    public String mostrarNinjaId(){
        return "Mostrar ninja por ID";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosNinjas(){
        return ninjaService.listarNinjas();
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar")
    public String alterarNinja(){
        return "Altera ninja por id";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar")
    public String deletarNinja(){
        return "Deleta ninja";
    }

}
