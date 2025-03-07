package dev.Juninho16.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRespository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRespository, NinjaMapper ninjaMapper) {
        this.ninjaRespository = ninjaRespository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRespository.findAll();
    }

    //Listar ninja por ID
    public NinjaModel listarNinjaId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRespository.findById(id);
        return ninjaPorId.orElse(null);
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
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtt){
        if (ninjaRespository.existsById(id)){
            ninjaAtt.setId(id);
            return ninjaRespository.save(ninjaAtt);
        }
        return null;
    }
}
