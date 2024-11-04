package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.EmailRequest;
import com.br.pessoas.app.dto.EmailResponse;
import com.br.pessoas.app.mapper.impl.email.EmailRequestMapper;
import com.br.pessoas.app.mapper.impl.email.EmailResponseMapper;
import com.br.pessoas.infra.dataProvider.repository.impl.EmailRepositoryImpl;
import com.br.pessoas.useCase.CreateEmailUseCase;
import com.br.pessoas.useCase.GetEmailUseCase;
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
	public EmailResponse create(final EmailRequest request){
		final CreateEmailUseCase useCase = new CreateEmailUseCase();
		return responseMapper.mapperToSource(useCase.create(requestMapper.mapperToTarget(request), repository));
	}

	public List<EmailResponse> findAllByPersonId(final Long personId){
		final GetEmailUseCase useCase = new GetEmailUseCase();
		return responseMapper.mapperToSource(useCase.findAllByPersonId(personId, repository));
	}
}
