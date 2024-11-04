package com.br.pessoas.app.mapper.impl.email;

import com.br.pessoas.app.dto.EmailRequest;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.EmailEntity;
import org.springframework.stereotype.Component;

@Component
public class EmailRequestMapper implements Mapper<EmailEntity, EmailRequest> {
	@Override
	public EmailEntity mapperToTarget(EmailRequest request) {
		return new EmailEntity(request.getId(), request.getPersonId(), request.getEmail());
	}

	@Override
	public EmailRequest mapperToSource(EmailEntity entity) {
		return new EmailRequest(entity.getId(), entity.getPersonId(), entity.getEmail());
	}
}
