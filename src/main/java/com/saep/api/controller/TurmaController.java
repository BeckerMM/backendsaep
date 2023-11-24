package com.saep.api.controller;

import com.saep.api.model.Professor;
import com.saep.api.model.Turma;
import com.saep.api.service.ProfessorService;
import com.saep.api.service.TurmaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turma")
@AllArgsConstructor
public class TurmaController {
    private TurmaService service;

    @GetMapping()
    public Collection<Turma> getAll() {
        return service.get();
    }

    @PostMapping()
    public ResponseEntity<Turma> inserir (@RequestBody Turma turma){

        try {
            return new ResponseEntity<Turma>(service.save(turma), HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable(value = "id") Integer id){
        try {
            service.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
