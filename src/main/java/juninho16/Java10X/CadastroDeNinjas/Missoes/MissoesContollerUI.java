package juninho16.Java10X.CadastroDeNinjas.Missoes;

import juninho16.Java10X.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesContollerUI {

    private final MissoesService missoesService;

    public MissoesContollerUI(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String mostrarTodasMissoes(Model model){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "listarMissoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String mostrarMissaoId(@PathVariable Long id, Model model){
        MissoesDTO missoes = missoesService.listarmissaoId(id);

        if(missoes != null){
            model.addAttribute("missoes", missoes);
            return "detalhesmissoes";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarMissoes";
        }
    }

    @GetMapping("/criar")
    public String criarMissao(Model model){
        model.addAttribute("missao", new MissoesDTO());

        return "adicionarmissao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissoesDTO missoesDTO, RedirectAttributes redirectAttributes) {
        missoesService.criarMissao(missoesDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Missão cadastrada com sucesso!");
        return "redirect:/missoes/ui/listar";
    }
}
