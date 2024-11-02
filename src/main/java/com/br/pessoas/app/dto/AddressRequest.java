package com.br.pessoas.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressRequest {
    private Long id;
    private Long personId;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String numero;
    private String cidade;
    private String uf;
}
