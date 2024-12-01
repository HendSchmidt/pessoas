package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.TelephoneRequest;
import com.br.pessoas.app.dto.TelephoneResponse;
import com.br.pessoas.app.mapper.impl.telephone.TelephoneRequestMapper;
import com.br.pessoas.app.mapper.impl.telephone.TelephoneResponseMapper;
import com.br.pessoas.domain.entity.TelephoneEntity;
import com.br.pessoas.infra.dataProvider.repository.impl.TelephoneRepositoryImpl;
import com.br.pessoas.useCase.CreateTelephoneUseCase;
import com.br.pessoas.useCase.DeleteTelephoneUseCase;
import com.br.pessoas.useCase.FindTelephoneUseCase;
import com.br.pessoas.useCase.exception.TelephoneDeleteException;
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
	public TelephoneResponse create(final TelephoneRequest request, final Long personId) {
		final CreateTelephoneUseCase useCase = new CreateTelephoneUseCase();
		final TelephoneEntity entity = requestMapper.mapperToTarget(request);
		entity.setPersonId(personId);
		return responseMapper.mapperToSource(useCase.create(entity,repository));
	}

	public List<TelephoneResponse> findAll(final Long personId) {
		final FindTelephoneUseCase useCase = new FindTelephoneUseCase();
		return responseMapper.mapperToSource(useCase.findAll(personId, repository));
	}

	public String delete(final Long personId){
		final FindTelephoneUseCase useCase = new FindTelephoneUseCase();
		final DeleteTelephoneUseCase deleteCase = new DeleteTelephoneUseCase();

		List<Long> list = useCase.findAll(personId, repository).parallelStream().map(TelephoneEntity::getId).toList();

		if(list.isEmpty()) throw new TelephoneDeleteException("Nenhum telefone encontrado");

		deleteCase.delete(list, repository);

		return "Telephones deleted successfully. Id´s: " + list;
	}

}
