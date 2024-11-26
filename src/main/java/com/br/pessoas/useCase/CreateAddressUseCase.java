package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.converter.impl.adress.AddressEntityToModelConverter;
import com.br.pessoas.infra.converter.impl.adress.AddressModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.AddressRepositoryImpl;

public class CreateAddressUseCase {

	private final AddressEntityToModelConverter toModel;
	private final AddressModelToEntityConverter toEntity;

	public CreateAddressUseCase() {
		this.toModel = new AddressEntityToModelConverter();
		this.toEntity = new AddressModelToEntityConverter();
	}

	public AddressEntity create(final AddressEntity entity, final AddressRepositoryImpl repository) {
		return toEntity.convert(repository.save(toModel.convert(entity)));
	}

}
