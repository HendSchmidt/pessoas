package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.person.PersonEntityToPersonModelConverter;
import com.br.pessoas.infra.converter.impl.person.PersonModelToPersonEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;

public class GetPersonUseCase {

    private final PersonModelToPersonEntityConverter toEntity;
    private final PersonEntityToPersonModelConverter toModel;

    public GetPersonUseCase() {
        this.toEntity = new PersonModelToPersonEntityConverter();
        this.toModel = new PersonEntityToPersonModelConverter();
    }

    public PersonEntity getPerson (Long id, PersonRepositoryImpl dataProvider){
        return toEntity.convert(dataProvider.get(id));
    }
}
