package dev.Juninho16.CadastroDeNinjas.Missoes;

import dev.Juninho16.CadastroDeNinjas.Ninjas.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET -- Mandar requisição parar listar missões
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao(){
        return missoesService.listarMissoes();
    }

    //GET -- Mandar requisição para listar missão por id
    @GetMapping("/listar/{id}")
    public MissoesModel missao(@PathVariable Long id){
        return missoesService.listarmissaoId(id);
    }

    //POST -- Mandar requisição parar criar missões
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    //PUT -- Mandar requisição parar alterar missões
    @PutMapping("/alterar")
    public MissoesModel aletrarMissao(@PathVariable Long id, @RequestBody MissoesModel missao){
        return missoesService.atualizarMissao(id, missao);
    }

    //DELETE -- Mandar requisição parar deletar missões
    @DeleteMapping("/deletar/{id}")
    public void deletaMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }


}
