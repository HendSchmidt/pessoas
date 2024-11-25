package com.br.pessoas.useCase.exception;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.person.PersonEntityToPersonModelConverter;
import com.br.pessoas.infra.converter.impl.person.PersonModelToPersonEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;

public class VerifyPersonExistsUseCase {

    public boolean exists (String cpf, PersonRepositoryImpl dataProvider){
        return dataProvider.existsByCpf(cpf);
    }
}
