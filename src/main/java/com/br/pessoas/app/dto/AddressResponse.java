package com.br.pessoas.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
public class AddressResponse {
    @JsonProperty("personId")
    private Long personId;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("cep")
    private String cep;
    @JsonProperty("logradouro")
    private String logradouro;
    @JsonProperty("complemento")
    private String complemento;
    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("numero")
    private String numero;
    @JsonProperty("cidade")
    private String cidade;
    @JsonProperty("uf")
    private String uf;
    @JsonProperty("description")
    private String description;
}
