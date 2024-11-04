package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.TelephoneEntity;
import com.br.pessoas.infra.converter.impl.telephone.TelephoneEntityToModelConverter;
import com.br.pessoas.infra.converter.impl.telephone.TelephoneModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.TelephoneRepositoryImpl;

public class CreateTelephoneUseCase {
	private final TelephoneEntityToModelConverter toModelConverter;
	private final TelephoneModelToEntityConverter toEntityConverter;

	public CreateTelephoneUseCase() {
		this.toModelConverter = new TelephoneEntityToModelConverter();
		this.toEntityConverter = new TelephoneModelToEntityConverter();
	}

	public TelephoneEntity create(TelephoneEntity entity, TelephoneRepositoryImpl repository) {
		return toEntityConverter.convert(repository.save(toModelConverter.convert(entity)));
	}
}
