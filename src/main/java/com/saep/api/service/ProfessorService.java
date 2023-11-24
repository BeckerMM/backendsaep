package com.saep.api.service;

import com.saep.api.model.Atividade;
import com.saep.api.model.Professor;
import com.saep.api.repository.AtividadeRepository;
import com.saep.api.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProfessorService  {
    private ProfessorRepository repository;

    public Professor save (Professor professor){
        try {
            return repository.save(professor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete (Integer id){
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Professor> get(){
        try {
           return repository.findAll();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}