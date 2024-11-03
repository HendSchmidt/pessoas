package com.br.pessoas.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
public class PersonResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private Integer idade;
    private Collection<AddressResponse> adressResponseList;

    public PersonResponse() {
    }

    public PersonResponse(Long id, String nome, String sobrenome, String cpf, Integer idade) {
        this.cpf = cpf;
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
}
