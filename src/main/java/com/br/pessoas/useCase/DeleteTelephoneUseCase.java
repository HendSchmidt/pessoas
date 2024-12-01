package com.br.pessoas.useCase;

import com.br.pessoas.infra.dataProvider.repository.impl.TelephoneRepositoryImpl;

import java.util.List;

public class DeleteTelephoneUseCase {
	public void delete(List<Long> listId, TelephoneRepositoryImpl repository) {
		repository.delete(listId);
	}
}
