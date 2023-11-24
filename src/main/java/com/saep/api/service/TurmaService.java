package com.saep.api.service;

import com.saep.api.model.Atividade;
import com.saep.api.model.Turma;
import com.saep.api.repository.AtividadeRepository;
import com.saep.api.repository.TurmaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TurmaService  {
    private TurmaRepository repository;

    public Turma save (Turma turma){
        try {
            return repository.save(turma);
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
    public List<Turma> get(){
        try {
            return repository.findAll();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
