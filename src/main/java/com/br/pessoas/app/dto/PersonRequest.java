package com.br.pessoas.app.dto;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    private Long id;
    @Nonnull
    private String nome;
    private String sobrenome;
    private String cpf;
    private Integer idade;
    private Collection<AddressRequest> adressRequestList;
}
