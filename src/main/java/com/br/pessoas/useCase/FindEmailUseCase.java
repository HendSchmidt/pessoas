package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.EmailEntity;
import com.br.pessoas.infra.converter.impl.email.EmailModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.EmailRepositoryImpl;

import java.util.List;

public class FindEmailUseCase {
	private final EmailModelToEntityConverter toEntityConverter;

	public FindEmailUseCase() {
		this.toEntityConverter = new EmailModelToEntityConverter();
	}

	public List<EmailEntity> findAll(Long personId, EmailRepositoryImpl repository) {
		return toEntityConverter.convert(repository.findAll(personId));
	}
}
