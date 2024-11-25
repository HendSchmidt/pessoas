package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.person.PersonModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;
import com.br.pessoas.useCase.exception.PersonRecoveryException;

public class FindPersonByCpfUseCase {

	private final PersonModelToEntityConverter toEntity;

	public FindPersonByCpfUseCase() {
		this.toEntity = new PersonModelToEntityConverter();
	}

	public PersonEntity findByCpf(final String cpf, final PersonRepositoryImpl dataProvider) {
		return toEntity.convert(dataProvider.findByCpf(cpf).orElseThrow(() -> new PersonRecoveryException("Não existe uma pessoa cadastrada com esse CPF.")));
	}
}
