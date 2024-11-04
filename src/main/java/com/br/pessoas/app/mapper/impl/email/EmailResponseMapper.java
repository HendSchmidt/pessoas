package com.br.pessoas.app.mapper.impl.email;

import com.br.pessoas.app.dto.EmailResponse;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.EmailEntity;
import org.springframework.stereotype.Component;

@Component
public class EmailResponseMapper implements Mapper<EmailEntity, EmailResponse> {

	@Override
	public EmailEntity mapperToTarget(EmailResponse response) {
		return new EmailEntity(response.getId(), response.getPersonId(), response.getEmail()) ;
	}

	@Override
	public EmailResponse mapperToSource(EmailEntity entity) {
		return new EmailResponse(entity.getId(), entity.getPersonId(), entity.getEmail());
	}
}
