package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.impl.person.PersonEntityToModelConverter;
import com.br.pessoas.infra.converter.impl.person.PersonModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;

public class UpdatePersonUseCase {

	private final PersonModelToEntityConverter toEntity;
	private final PersonEntityToModelConverter toModel;

	public UpdatePersonUseCase() {
		this.toEntity = new PersonModelToEntityConverter();
		this.toModel = new PersonEntityToModelConverter();
	}

	public PersonEntity update(final PersonEntity entity, final PersonRepositoryImpl repository) {
		return toEntity.convert(repository.update(toModel.convert(entity)));
	}
}
