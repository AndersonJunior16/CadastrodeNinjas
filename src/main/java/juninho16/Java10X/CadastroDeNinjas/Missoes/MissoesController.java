package juninho16.Java10X.CadastroDeNinjas.Missoes;


import juninho16.Java10X.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissoesDTO>> listarMissao(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    //GET -- Mandar requisição para listar missão por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarMissaoId(@PathVariable Long id){
        MissoesDTO missoes = missoesService.listarmissaoId(id);

        if(missoes != null){
            return ResponseEntity.ok(missoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão de ID: " + id + " não existe");
        }
    }

    //POST -- Mandar requisição parar criar missões
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes){
        MissoesDTO missoesDTO = missoesService.criarMissao(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + missoesDTO.getNome() + " - ID: " + missoesDTO.getId());
    }

    //PUT -- Mandar requisição parar alterar missões
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesAtt){
        if (missoesService.listarmissaoId(id) != null){
            missoesService.atualizarMissao(id, missoesAtt);
            return ResponseEntity.ok("Missão: " + missoesAtt.getNome() + " - ID: " + id  + "atualizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão de ID: " + id + " não existe");
        }
    }

    //DELETE -- Mandar requisição parar deletar missões
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if (missoesService.listarmissaoId(id) != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão ID: " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão de ID: " + id + " não existe");
        }
    }


}