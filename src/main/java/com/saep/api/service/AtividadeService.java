package com.saep.api.service;

import com.saep.api.model.Atividade;
import com.saep.api.repository.AtividadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@AllArgsConstructor
@Service
public class AtividadeService  {
    private AtividadeRepository repository;

    public Atividade save (Atividade atividade){
        try {
            return repository.save(atividade);

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
    public List<Atividade> get(){
        try {
            return repository.findAll();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
