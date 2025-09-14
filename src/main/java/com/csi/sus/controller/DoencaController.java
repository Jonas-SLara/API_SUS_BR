package com.csi.sus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.sus.model.doenca.Doenca;
import com.csi.sus.service.DoencaService;

import jakarta.validation.Valid;

import java.util.List;

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
    public ResponseEntity<Doenca> getByNome(@PathVariable String nome) {
        Doenca d = doencaService.buscarPorNome(nome);
        return ResponseEntity.ok(d);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@Valid @PathVariable Long id) {
        Doenca d = doencaService.buscarPorId(id);
        return ResponseEntity.ok(d);
    }

    //anotacao valid valida o argumento e se for falso gera um MethodArgumentNotValidExeption
    @PostMapping("/")
    public ResponseEntity<Doenca> postDoenca(@Valid @RequestBody Doenca doenca){
        Doenca nova = doencaService.salvarDoenca(doenca);
        return ResponseEntity.status(201).body(nova);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Doenca doenca = doencaService.deletar(id);
        return ResponseEntity.ok(doenca);
    }

    @PutMapping("/") 
    public ResponseEntity<?> putDoenca(@Valid @RequestBody Doenca doenca){
        Doenca d = this.doencaService.editar(doenca);
        return ResponseEntity.ok(d);
    }
}

