package com.br.pessoas.app.mapper.impl;

import com.br.pessoas.app.dto.PersonResponse;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.PersonEntity;
import org.springframework.beans.factory.ListableBeanFactoryExtensionsKt;
import org.springframework.stereotype.Component;

@Component
public class PersonResponseMapper implements Mapper<PersonEntity, PersonResponse> {
    @Override
    public PersonEntity mapperToOut(PersonResponse response) {
        return null;
    }

    @Override
    public PersonResponse mapperToIn(PersonEntity entity) {
        PersonEntity person= new PersonEntity();

        return null;
    }
}
