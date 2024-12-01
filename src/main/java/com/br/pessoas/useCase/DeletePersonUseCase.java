package com.br.pessoas.useCase;

import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;

public class DeletePersonUseCase {
	public void delete(Long personId, PersonRepositoryImpl repository) {
		repository.delete(personId);
	}
}
