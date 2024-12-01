package com.br.pessoas.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
public class PersonResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("sobrenome")
    private String sobrenome;
    @JsonProperty("cpf")
    private String cpf;
    @JsonProperty("idade")
    private Integer idade;
    @JsonProperty("addressResponseList")
    private Collection<AddressResponse> adressResponseList;
    @JsonProperty("emailResponseList")
    private Collection<EmailResponse> emailResponseList;
    @JsonProperty("telefoneResponseList")
    private Collection<TelephoneResponse> telephoneResponseList;


    public PersonResponse(Long id, String nome, String sobrenome, String cpf, Integer idade) {
        this.cpf = cpf;
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
}
