package com.csi.sus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.sus.model.doenca.Doenca;
import com.csi.sus.service.DoencaService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController //ja garante que o retorno seja um json
@RequestMapping("/doencas")
public class DoencaController {

    private final DoencaService doencaService;

    //injeção de dependencia
    public DoencaController(DoencaService doencaService){
        this.doencaService = doencaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Doenca>> getAllDoencas() {
        List<Doenca> doencas = doencaService.listar();
        return ResponseEntity.ok(doencas);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> getByNome(@PathVariable String nome) {
        Optional<Doenca> d = doencaService.buscarPorNome(nome);
        if(d.isPresent()){
            return ResponseEntity.ok(d.get());
        }
        return ResponseEntity.status(404).body("nome não encontrado");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Doenca> d = doencaService.buscarPorId(id);
        if(d.isPresent()){
            return ResponseEntity.ok(d.get());
        }
        return ResponseEntity.status(404).body("id não encontrado");
    }

    @PostMapping("/")
    public ResponseEntity<Doenca> postDoenca(@RequestBody Doenca doenca) {
        Doenca nova = doencaService.salvarDoenca(doenca);
        return ResponseEntity.status(201).body(nova);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Optional<Doenca> doenca = doencaService.buscarPorId(id);
        if (doenca.isPresent()) {
            doencaService.deletar(id);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(404).body(false);
    }

    @PutMapping("/{id}") 
    public ResponseEntity<Boolean> putDoenca(
        @PathVariable Long id,
        @RequestBody Doenca doenca
    ) {
        if(this.doencaService.editar(id, doenca)){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(404).body(false);
    }
}

