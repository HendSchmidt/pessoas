package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.converter.impl.adress.AddressModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.AddressRepositoryImpl;

import java.util.List;

public class FindAddressUseCase {
	private final AddressModelToEntityConverter toEntity;

	public FindAddressUseCase() {
		this.toEntity = new AddressModelToEntityConverter();
	}

	public List<AddressEntity> findAll(Long personId, AddressRepositoryImpl repository) {
		return toEntity.convert(repository.findAll(personId));
	}
}
