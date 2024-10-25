package com.br.pessoas.infra.dataProvider.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel extends AbstractPersistable<Long> {
    private String nome;
    private String sobrenome;
    private String cpf;
    private Integer idade;
    @OneToMany
    private Collection<AdressModel> adressModelList;
}
