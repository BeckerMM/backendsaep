package com.saep.api.controller;

import com.saep.api.model.Atividade;
import com.saep.api.model.DTOProfessor;
import com.saep.api.model.Professor;
import com.saep.api.service.AtividadeService;
import com.saep.api.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/professor")
@AllArgsConstructor
public class ProfessorController {
    private ProfessorService service;

    @GetMapping()
    public Collection<Professor> getAll() {
        return service.get();
    }

    @PostMapping()
    public ResponseEntity<Professor> inserir (@RequestBody Professor professor){

        try {
            return new ResponseEntity<Professor>(service.save(professor), HttpStatus.CREATED);
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

    @GetMapping("/login")
    public Professor login(@RequestBody DTOProfessor professor){
        List<Professor> listaDeProfessores = service.get();
        try {
            for (Professor professorFor: listaDeProfessores) {
                if (professor.getEmail().equals(professorFor.getEmail())){
                    if (professor.getSenha().equals(professorFor.getSenha())){
                        return professorFor;
                    }
                }
            }

        }catch (Exception e ){
            return null;
        }

        return null;
    }
}
