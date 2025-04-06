package juninho16.Java10X.CadastroDeNinjas.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaDTO.getNome() + " - ID: " + ninjaDTO.getId());
    }

    //Prucurar Ninja ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarNinjaId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjaId(id);

        if(ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja de ID: " + id + " não existe");
        }
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtt){
        if (ninjaService.listarNinjaId(id) != null){
            ninjaService.atualizarNinja(id, ninjaAtt);
            return ResponseEntity.ok("Ninja: " + ninjaAtt.getNome() + " - ID: " + id  + "atualizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja de ID: " + id + " não existe");
        }
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if (ninjaService.listarNinjaId(id) != null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja ID: " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja de ID: " + id + " não existe");
        }
    }

}