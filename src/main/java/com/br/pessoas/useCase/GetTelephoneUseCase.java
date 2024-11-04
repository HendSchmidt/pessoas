package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.TelephoneEntity;
import com.br.pessoas.infra.converter.impl.telephone.TelephoneModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.TelephoneRepositoryImpl;

import java.util.List;

public class GetTelephoneUseCase {
	private final TelephoneModelToEntityConverter toEntityConverter;

	public GetTelephoneUseCase() {
		this.toEntityConverter = new TelephoneModelToEntityConverter();
	}

	public List<TelephoneEntity> findAllByPersonId(Long personId, TelephoneRepositoryImpl repository) {
		return toEntityConverter.convert(repository.findAllByPersonId(personId));
	}
}
