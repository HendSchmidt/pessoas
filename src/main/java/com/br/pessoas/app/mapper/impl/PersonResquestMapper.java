package com.br.pessoas.app.mapper.impl;

import com.br.pessoas.app.dto.PersonRequest;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonResquestMapper implements Mapper<PersonEntity, PersonRequest> {
    @Override
    public PersonEntity mapperToOut(PersonRequest source) {
        return null;
    }

    @Override
    public PersonRequest mapperToIn(PersonEntity source) {
        return null;
    }
}
