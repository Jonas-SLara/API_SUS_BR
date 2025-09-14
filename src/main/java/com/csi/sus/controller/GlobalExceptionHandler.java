//TRATAMENTO DE ERROS
package com.csi.sus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

//e uma especializacao de @ControllerAdvice + @ResponseBody
@RestControllerAdvice //intercepta exceções de todos os controllers
public class GlobalExceptionHandler {

    private record DadosErro(String campo, String mensagem){
        
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarErro400(MethodArgumentNotValidException ex){
        List<FieldError> errors = ex.getFieldErrors();
        List<DadosErro> dados = new ArrayList<>();
        for(FieldError fr : errors){
            dados.add(new DadosErro(fr.getField(), fr.getDefaultMessage()));
        }
        return ResponseEntity.badRequest().body(dados);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> tratarErroTipoInvalido(MethodArgumentNotValidException ex){
        String nome = ex.getFieldError().getField();
        String msg = ex.getFieldError().getDefaultMessage();
        DadosErro dados = new DadosErro(nome, msg);
        return ResponseEntity.badRequest().body(dados);
    }

}
