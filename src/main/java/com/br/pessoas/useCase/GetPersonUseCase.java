package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.person.PersonEntityToPersonModelConverter;
import com.br.pessoas.infra.converter.impl.person.PersonModelToPersonEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonDataProviderRepository;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;

public class GetPersonUseCase {

    private final PersonModelToPersonEntityConverter toEntity;
    private final PersonEntityToPersonModelConverter toModel;

    public GetPersonUseCase() {
        this.toEntity = new PersonModelToPersonEntityConverter();
        this.toModel = new PersonEntityToPersonModelConverter();
    }

    public PersonEntity getPerson (Long id, PersonDataProviderRepository dataProvider){
        return toEntity.convert(dataProvider.get(id));
    }
}
