package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.person.PersonModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;

import java.util.List;

public class FindAllPersonUseCase {
	private final PersonModelToEntityConverter toEntity;

	public FindAllPersonUseCase() {
		this.toEntity = new PersonModelToEntityConverter();
	}

	public List<PersonEntity> findAllPerson(PersonRepositoryImpl repository) {
		return toEntity.convert(repository.findAllPerson());
	}
}
