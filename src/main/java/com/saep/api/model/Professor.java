package com.saep.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Professor {
    @Id
    private Integer id;
    private String nome;
    private String email;
    private String senha;

}
