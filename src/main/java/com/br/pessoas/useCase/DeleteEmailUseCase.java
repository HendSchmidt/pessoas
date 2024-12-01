package com.br.pessoas.useCase;

import com.br.pessoas.infra.dataProvider.repository.impl.EmailRepositoryImpl;

import java.util.List;

public class DeleteEmailUseCase {
	public void delete(List<Long> listId, EmailRepositoryImpl repository) {
		repository.delete(listId);
	}
}
