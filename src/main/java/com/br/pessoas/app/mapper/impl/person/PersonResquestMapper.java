package com.br.pessoas.app.mapper.impl.person;

import com.br.pessoas.app.dto.PersonRequest;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonResquestMapper implements Mapper<PersonEntity, PersonRequest> {

    @Override
    public PersonEntity mapperToTarget(PersonRequest request) {
        return new PersonEntity(request.getId(), request.getNome()
                , request.getSobrenome(), request.getCpf(), request.getIdade());
    }

    @Override
    public PersonRequest mapperToSource(PersonEntity entity) {
        return new PersonRequest(entity.getId(), entity.getNome()
                , entity.getSobrenome(), entity.getCpf(), entity.getIdade());
    }
}
