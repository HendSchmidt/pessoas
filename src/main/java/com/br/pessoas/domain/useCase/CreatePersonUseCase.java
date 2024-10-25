package com.br.pessoas.domain.useCase;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.PersonEntityToPersonModelConverter;
import com.br.pessoas.infra.converter.impl.PersonModelToPersonEntityConverter;
import com.br.pessoas.infra.dataProvider.DataProvider;
import com.br.pessoas.infra.dataProvider.strategy.DataProviderStrategy;
import com.br.pessoas.infra.dataProvider.strategy.enumerator.DataProviderStrategyEnum;

public class CreatePersonUseCase {

    private final DataProvider personGateway;
    private final PersonModelToPersonEntityConverter toEntity;
    private final PersonEntityToPersonModelConverter toModel;

    public CreatePersonUseCase(DataProviderStrategyEnum strategyEnum) {
        this.personGateway = new DataProviderStrategy().getStrategies(strategyEnum);
        this.toEntity = new PersonModelToPersonEntityConverter();
        this.toModel = new PersonEntityToPersonModelConverter();
    }

    public PersonEntity createPerson(PersonEntity entity){
        return toEntity.convert(personGateway.savePerson(toModel.convert(entity)));
    }
}
