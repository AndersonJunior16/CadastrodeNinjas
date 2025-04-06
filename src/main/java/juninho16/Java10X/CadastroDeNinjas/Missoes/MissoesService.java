package juninho16.Java10X.CadastroDeNinjas.Missoes;

import juninho16.Java10X.CadastroDeNinjas.Ninjas.NinjaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Listar todas minhas missoes
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //Listar missão por ID
    public MissoesDTO listarmissaoId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    //Criar nova missão
    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return  missoesMapper.map(missoes);
    }

    //Deletar missão
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

    //Alterar Missao
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO) {
        Optional<MissoesModel> misssoesExist = missoesRepository.findById(id);
        if (misssoesExist.isPresent()) {
            MissoesModel missoesAtt = missoesMapper.map(missoesDTO);
            missoesAtt.setId(id);
            MissoesModel missoesSalvo = missoesRepository.save(missoesAtt);
            return missoesMapper.map(missoesSalvo);
        }
        return null;
    }
}