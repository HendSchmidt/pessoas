package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.EmailEntity;
import com.br.pessoas.infra.converter.impl.email.EmailEntityToModelConverter;
import com.br.pessoas.infra.converter.impl.email.EmailModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.EmailRepositoryImpl;

public class CreateEmailUseCase {
	private final EmailEntityToModelConverter toModelConverter;
	private final EmailModelToEntityConverter toEntityConverter;

	public CreateEmailUseCase() {
		this.toEntityConverter = new EmailModelToEntityConverter();
		this.toModelConverter = new EmailEntityToModelConverter();
	}

	public EmailEntity create(EmailEntity entity, EmailRepositoryImpl repository) {
		return toEntityConverter.convert(repository.save(toModelConverter.convert(entity)));
	}
}
