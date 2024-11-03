package com.br.pessoas.app.mapper.impl;

import com.br.pessoas.app.dto.PersonResponse;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonResponseMapper implements Mapper<PersonEntity, PersonResponse> {

    @Autowired
    private AddressResponseMapper adressMapper;

    @Override
    public PersonEntity mapperToTarget(PersonResponse response) {
        return new PersonEntity(response.getId(), response.getNome()
        , response.getSobrenome(), response.getCpf(), response.getIdade());
    }

    @Override
    public PersonResponse mapperToSource(PersonEntity entity) {
        return new PersonResponse(entity.getId(), entity.getNome()
        , entity.getSobrenome(), entity.getCpf(), entity.getIdade());
    }
}
