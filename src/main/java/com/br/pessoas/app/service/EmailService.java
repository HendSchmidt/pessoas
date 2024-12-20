package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.EmailRequest;
import com.br.pessoas.app.dto.EmailResponse;
import com.br.pessoas.app.mapper.impl.email.EmailRequestMapper;
import com.br.pessoas.app.mapper.impl.email.EmailResponseMapper;
import com.br.pessoas.domain.entity.EmailEntity;
import com.br.pessoas.infra.dataProvider.repository.impl.EmailRepositoryImpl;
import com.br.pessoas.useCase.CreateEmailUseCase;
import com.br.pessoas.useCase.FindEmailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmailService {

	@Autowired
	private EmailResponseMapper responseMapper;

	@Autowired
	private EmailRequestMapper requestMapper;

	@Autowired
	private EmailRepositoryImpl repository;

	@Transactional
	public EmailResponse create(final EmailRequest request, final Long personId){
		final CreateEmailUseCase useCase = new CreateEmailUseCase();
		final EmailEntity entity = requestMapper.mapperToTarget(request);
		entity.setPersonId(personId);
		return responseMapper.mapperToSource(useCase.create(entity, repository));
	}

	public List<EmailResponse> findAll(final Long personId){
		final FindEmailUseCase useCase = new FindEmailUseCase();
		return responseMapper.mapperToSource(useCase.findAll(personId, repository));
	}
}
