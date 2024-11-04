package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.EmailEntity;
import com.br.pessoas.infra.converter.impl.email.EmailEntityToModelConverter;
import com.br.pessoas.infra.converter.impl.email.EmailModelToEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.EmailRepositoryImpl;

import java.util.List;

public class GetEmailUseCase {
	private final EmailEntityToModelConverter toModelConverter;
	private final EmailModelToEntityConverter toEntityConverter;

	public GetEmailUseCase() {
		this.toEntityConverter = new EmailModelToEntityConverter();
		this.toModelConverter = new EmailEntityToModelConverter();
	}

	public List<EmailEntity> findAllByPersonId(Long personId, EmailRepositoryImpl repository) {
		return toEntityConverter.convert(repository.findAllByPersonId(personId));
	}
}
