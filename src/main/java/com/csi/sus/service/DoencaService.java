package com.csi.sus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.csi.sus.model.doenca.Doenca;
import com.csi.sus.repositories.DoencaRepository;

@Service
public class DoencaService {
    
    private final DoencaRepository doencaRepository;

    //@Autowired  injeta dependencia de repository
    public DoencaService(DoencaRepository doencaRepository){
        this.doencaRepository = doencaRepository;
    }

    //criar
    public Doenca salvarDoenca(Doenca doenca){
        return this.doencaRepository.save(doenca);
    }

    //buscar por nome
    public Optional<Doenca> buscarPorNome(String nome){
        return this.doencaRepository.findByNome(nome);
    }

    //buscar por id
    public Optional<Doenca> buscarPorId(Long id){
        return this.doencaRepository.findById(id);
    }

    //listar todas
    public List<Doenca> listar(){
        return this.doencaRepository.findAll();
    }

    //deletar uma
    public void deletar(Long id){
        this.doencaRepository.deleteById(id);
    }

    //update
    public Boolean editar(Long id, Doenca doencaEditada){
        Optional<Doenca> doencaAntiga = this.doencaRepository.findById(id);
        if(doencaAntiga.isPresent()){
            Doenca d = doencaAntiga.get();
            d.setDescricao(doencaEditada.getDescricao());
            d.setNome(doencaEditada.getNome());
            this.doencaRepository.save(d);
            return true;
        }
        return false;
    }
}
