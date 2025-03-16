package juninho16.Java10X.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Listar todas minhas missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //Listar missão por ID
    public MissoesModel listarmissaoId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    //Criar nova missão
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Deletar missão
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

    //Alterar Missao
    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtt){
        if (missoesRepository.existsById(id)){
            missaoAtt.setId(id);
            return missoesRepository.save(missaoAtt);
        }
        return null;
    }
}