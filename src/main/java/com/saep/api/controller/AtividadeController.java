package com.saep.api.controller;

import com.saep.api.model.Atividade;
import com.saep.api.service.AtividadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/atividade")
@AllArgsConstructor
public class AtividadeController {
    private AtividadeService service;

    @GetMapping()
    public Collection<Atividade> getAll() {
        return service.get();
    }

    @PostMapping()
    public ResponseEntity<Atividade> inserir (@RequestBody Atividade atividade){

        try {
            return new ResponseEntity<Atividade>(service.save(atividade), HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable (value = "id") Integer id){
        try {
            service.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
