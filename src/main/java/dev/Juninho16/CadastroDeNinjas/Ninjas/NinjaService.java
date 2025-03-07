package dev.Juninho16.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRespository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRespository, NinjaMapper ninjaMapper) {
        this.ninjaRespository = ninjaRespository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os meus ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRespository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map )
                .collect(Collectors.toList());
    }

    //Listar ninja por ID
    public NinjaDTO listarNinjaId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRespository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    //Criar novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRespository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar ninja
    public void deletarNinja(Long id){
        ninjaRespository.deleteById(id);
    }

    //Alterar ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExist = ninjaRespository.findById(id);
        if ( ninjaExist.isPresent()){
            NinjaModel ninjaAtt = ninjaMapper.map(ninjaDTO);
            ninjaAtt.setId(id);
            NinjaModel ninjaSalvo = ninjaRespository.save(ninjaAtt);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
