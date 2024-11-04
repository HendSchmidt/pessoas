package com.br.pessoas.infra.converter.impl.email;

import com.br.pessoas.domain.entity.EmailEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.repository.model.EmailModel;

public class EmailModelToEntityConverter implements Converter<EmailEntity, EmailModel> {
	@Override
	public EmailEntity convert(EmailModel model) {
		return new EmailEntity(model.getId(), model.getPersonId(), model.getEmail());
	}
}
