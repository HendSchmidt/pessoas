package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.person.PersonEntityToPersonModelConverter;
import com.br.pessoas.infra.converter.impl.person.PersonModelToPersonEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.PersonRepository;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonDataProviderRepository;

import java.util.List;

public class GetAllPersonUseCase {
    private final PersonModelToPersonEntityConverter toEntity;
    private final PersonEntityToPersonModelConverter toModel;

    public GetAllPersonUseCase() {
        this.toEntity = new PersonModelToPersonEntityConverter();
        this.toModel = new PersonEntityToPersonModelConverter();
    }

    public List<PersonEntity> getAllPerson (PersonDataProviderRepository repository){
        return toEntity.convertList(repository.getAll());
    }

}
