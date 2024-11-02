package com.br.pessoas.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
public class PersonResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private Integer idade;
    private Collection<AddressResponse> adressResponseList;

}
