package com.csi.sus.service;

import java.util.List;
import java.util.NoSuchElementException;
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
    public Doenca buscarPorNome(String nome){
        //retorna um optional, se isPresent = true retorna o objeto
        //se for false lança NoSuchElementException
        return this.doencaRepository.findByNome(nome)
        .orElseThrow();
    }

    //buscar por id
    public Doenca buscarPorId(Long id){
        return this.doencaRepository.findById(id)
        .orElseThrow();
    }

    //listar todas
    public List<Doenca> listar(){
        return this.doencaRepository.findAll();
    }

    //deletar uma
    public Doenca deletar(Long id){
        Optional<Doenca> d = doencaRepository.findById(id);
        if(d.isPresent()){
            this.doencaRepository.deleteById(id);
            return d.get();
        }
        throw new NoSuchElementException();
    }

    //update
    public Doenca editar(Doenca doenca){
        Optional<Doenca> temp = this.doencaRepository.findById(doenca.getId());
        if(temp.isPresent()){
            Doenca d = temp.get();
            d.setDescricao(doenca.getDescricao());
            d.setNome(doenca.getNome());
            this.doencaRepository.save(d);
            return d;
        }
        throw new NoSuchElementException();
    }
}
