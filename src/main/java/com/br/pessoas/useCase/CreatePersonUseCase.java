package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.person.PersonEntityToPersonModelConverter;
import com.br.pessoas.infra.converter.impl.person.PersonModelToPersonEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.PersonRepository;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonDataProviderRepository;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;

public class CreatePersonUseCase {

    private final PersonModelToPersonEntityConverter toEntity;
    private final PersonEntityToPersonModelConverter toModel;

    public CreatePersonUseCase() {
        this.toEntity = new PersonModelToPersonEntityConverter();
        this.toModel = new PersonEntityToPersonModelConverter();
    }

    public PersonEntity createPerson(PersonEntity entity, PersonDataProviderRepository repository){
        return toEntity.convert(repository.save(toModel.convert(entity)));
    }

}
