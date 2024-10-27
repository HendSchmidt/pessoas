package com.br.pessoas.app.dto;

import com.br.pessoas.domain.entity.AdressEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Collection;

@Data
@AllArgsConstructor
public class PersonRequest {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private Integer idade;
    private Collection<AdressRequest> adressRequestList;
}
