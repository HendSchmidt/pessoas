package com.br.pessoas.app.dto;

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
    private Collection<AddressRequest> adressRequestList;
}
