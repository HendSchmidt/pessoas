package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.person.PersonEntityToPersonModelConverter;
import com.br.pessoas.infra.converter.impl.person.PersonModelToPersonEntityConverter;
import com.br.pessoas.infra.dataProvider.DataProvider;

import java.util.List;

public class GetAllPersonUseCase {
    private final PersonModelToPersonEntityConverter toEntity;
    private final PersonEntityToPersonModelConverter toModel;

    public GetAllPersonUseCase() {
        this.toEntity = new PersonModelToPersonEntityConverter();
        this.toModel = new PersonEntityToPersonModelConverter();
    }

    public List<PersonEntity> getAllPerson (DataProvider dataProvider){
        return toEntity.convertList(dataProvider.getAll());
    }

}
