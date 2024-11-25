package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.person.PersonModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;

public class FindPersonUseCase {

	private final PersonModelToEntityConverter toEntity;

	public FindPersonUseCase() {
		this.toEntity = new PersonModelToEntityConverter();
	}

	public PersonEntity find(Long id, PersonRepositoryImpl dataProvider) {
		return toEntity.convert(dataProvider.find(id));
	}
}
