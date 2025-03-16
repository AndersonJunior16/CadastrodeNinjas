package juninho16.Java10X.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninja/ui")
public class NinjaControllerUI {

    private final NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(Model model){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "boasvindas";
    }

    @GetMapping("/listar")
    public String mostrarTodosNinjas(Model model){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
        return "redirect:/ninja/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String mostrarNinjaId(@PathVariable Long id, Model model){
        NinjaDTO ninja = ninjaService.listarNinjaId(id);

        if(ninja != null){
            model.addAttribute("ninjas", ninja);
            return "detalhesninja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas";
        }
    }

    @GetMapping("/criar")
    public String criarNinja(Model model){
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarninja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninja/ui/listar";
    }
}
