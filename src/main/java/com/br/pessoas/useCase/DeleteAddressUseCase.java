package com.br.pessoas.useCase;

import com.br.pessoas.infra.dataProvider.repository.impl.AddressRepositoryImpl;

import java.util.List;

public class DeleteAddressUseCase {
	public void delete(List<Long> listId, AddressRepositoryImpl repository) {
		repository.delete(listId);
	}
}
