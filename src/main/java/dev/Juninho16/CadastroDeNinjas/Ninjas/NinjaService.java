package dev.Juninho16.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRespository;

    public NinjaService(NinjaRepository ninjaRespository) {
        this.ninjaRespository = ninjaRespository;
    }

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRespository.findAll();
    }
}
