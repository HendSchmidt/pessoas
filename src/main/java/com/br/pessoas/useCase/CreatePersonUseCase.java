package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.person.PersonEntityToModelConverter;
import com.br.pessoas.infra.converter.impl.person.PersonModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;

public class CreatePersonUseCase {

	private final PersonModelToEntityConverter toEntity;
	private final PersonEntityToModelConverter toModel;

	public CreatePersonUseCase() {
		this.toEntity = new PersonModelToEntityConverter();
		this.toModel = new PersonEntityToModelConverter();
	}

	public PersonEntity create(PersonEntity entity, PersonRepositoryImpl repository) {
		return toEntity.convert(repository.save(toModel.convert(entity)));
	}

}
