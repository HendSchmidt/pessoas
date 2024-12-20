package com.br.pessoas.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private Integer idade;
}
