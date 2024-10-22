package com.br.pessoas.domain.useCase;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.PersonEntityToRequestConverter;
import com.br.pessoas.infra.converter.impl.PersonResopnseToEntityConverter;
import com.br.pessoas.infra.dataProvider.DataProvider;
import com.br.pessoas.infra.dataProvider.strategy.DataProviderStrategy;
import com.br.pessoas.infra.dataProvider.strategy.enumerator.DataProviderStrategyEnum;

public class CreatePersonUseCase {

    DataProvider personGateway;
    PersonEntityToRequestConverter toRequest;
    PersonResopnseToEntityConverter toEntity;

    public CreatePersonUseCase(DataProviderStrategyEnum strategyEnum) {
        this.personGateway = new DataProviderStrategy().getStrategies(strategyEnum);
        this.toRequest = new PersonEntityToRequestConverter();
        this.toEntity = new PersonResopnseToEntityConverter();
    }

    public PersonEntity createPerson(PersonEntity entity){
        return personGateway.savePerson(entity);
    }
}
