package com.br.pessoas.useCase.exception;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.person.PersonEntityToPersonModelConverter;
import com.br.pessoas.infra.converter.impl.person.PersonModelToPersonEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;

public class GetPersonByCpfUseCase {

    private final PersonModelToPersonEntityConverter toEntity;

    public GetPersonByCpfUseCase() {
        this.toEntity = new PersonModelToPersonEntityConverter();
    }

    public PersonEntity findByCpf(final String cpf,final PersonRepositoryImpl dataProvider){
        return toEntity.convert(dataProvider.findByCpf(cpf).orElseThrow(() -> new PersonRecoveryException("Não existe uma pessoa cadastrada com esse CPF.")));
    }
}
