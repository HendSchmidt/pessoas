package com.br.pessoas.infra.converter.impl.email;

import com.br.pessoas.domain.entity.EmailEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.repository.model.EmailModel;

public class EmailEntityToModelConverter implements Converter<EmailModel, EmailEntity> {
	@Override
	public EmailModel convert(EmailEntity entity) {
		return new EmailModel(entity.getPersonId(), entity.getEmail(), entity.getDescription());
	}
}
