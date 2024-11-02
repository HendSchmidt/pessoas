package com.br.pessoas.infra.dataProvider.repository.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel extends AbstractPersistable<Long> {
    private Long personId;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String numero;
    private String cidade; //localidade
    private String uf;
}
