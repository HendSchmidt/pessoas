package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.TelephoneEntity;
import com.br.pessoas.infra.converter.impl.telephone.TelephoneModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.TelephoneRepositoryImpl;

import java.util.List;

public class FindTelephoneUseCase {
	private final TelephoneModelToEntityConverter toEntityConverter;

	public FindTelephoneUseCase() {
		this.toEntityConverter = new TelephoneModelToEntityConverter();
	}

	public List<TelephoneEntity> findAll(Long personId, TelephoneRepositoryImpl repository) {
		return toEntityConverter.convert(repository.findAll(personId));
	}
}
