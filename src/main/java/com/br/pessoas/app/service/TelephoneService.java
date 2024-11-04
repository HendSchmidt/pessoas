package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.TelephoneRequest;
import com.br.pessoas.app.dto.TelephoneResponse;
import com.br.pessoas.app.mapper.impl.telephone.TelephoneRequestMapper;
import com.br.pessoas.app.mapper.impl.telephone.TelephoneResponseMapper;
import com.br.pessoas.infra.dataProvider.repository.impl.TelephoneRepositoryImpl;
import com.br.pessoas.useCase.CreateTelephoneUseCase;
import com.br.pessoas.useCase.GetTelephoneUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TelephoneService {
	@Autowired
	private TelephoneRequestMapper requestMapper;

	@Autowired
	private TelephoneResponseMapper responseMapper;

	@Autowired
	private TelephoneRepositoryImpl repository;

	@Transactional
	public TelephoneResponse create(final TelephoneRequest request) {
		final CreateTelephoneUseCase useCase = new CreateTelephoneUseCase();
		return responseMapper.mapperToSource(useCase.create(requestMapper.mapperToTarget(request),repository));
	}

	public List<TelephoneResponse> findAllByPersonId(final Long personId) {
		final GetTelephoneUseCase useCase = new GetTelephoneUseCase();
		return responseMapper.mapperToSource(useCase.findAllByPersonId(personId, repository));
	}

}
