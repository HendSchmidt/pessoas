package com.br.pessoas.infra.dataProvider.repository.model;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.lang.Nullable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel extends AbstractPersistable<Long> {
    private String nome;
    private String sobrenome;
    private String cpf;
    private Integer idade;

    @Override
    public void setId(@Nullable Long id) {
        super.setId(id);
    }

}
