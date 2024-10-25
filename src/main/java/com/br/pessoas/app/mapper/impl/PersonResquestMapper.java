package com.br.pessoas.app.mapper.impl;

import com.br.pessoas.app.dto.PersonRequest;
import com.br.pessoas.app.dto.PersonResponse;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonResquestMapper implements Mapper<PersonEntity, PersonRequest> {

    @Autowired
    private AdressRequestMapper adressMapper;

    @Override
    public PersonEntity mapperToTarget(PersonRequest request) {
        return new PersonEntity(request.getId(), request.getNome()
                , request.getSobrenome(), request.getCpf(), request.getIdade()
                , adressMapper.mapperToTarget(request.getAdressRequestList().stream().toList()));
    }

    @Override
    public PersonRequest mapperToSource(PersonEntity entity) {
        return new PersonRequest(entity.getId(), entity.getNome()
                , entity.getSobrenome(), entity.getCpf(), entity.getIdade()
                , adressMapper.mapperToSource(entity.getAdressEntityList().stream().toList()));
    }
}
