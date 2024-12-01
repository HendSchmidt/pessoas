package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.AddressRequest;
import com.br.pessoas.app.dto.AddressResponse;
import com.br.pessoas.app.mapper.impl.address.AddressResponseMapper;
import com.br.pessoas.app.service.facade.CreateAddressFacade;
import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.dataProvider.client.AddressClient;
import com.br.pessoas.infra.dataProvider.repository.impl.AddressRepositoryImpl;
import com.br.pessoas.useCase.DeleteAddressUseCase;
import com.br.pessoas.useCase.FindAddressUseCase;
import com.br.pessoas.useCase.exception.AddressDeleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {
	@Autowired
	private AddressResponseMapper responseMapper;

	@Autowired
	private AddressRepositoryImpl repository;

	@Autowired
	private AddressClient client;

	@Autowired
	private CreateAddressFacade getAddressFacade;

	@Transactional
	public AddressResponse create(final AddressRequest request, final Long personId) {
		CreateAddressFacade createAddressFacade = new CreateAddressFacade();
		createAddressFacade.setFacadeRules(repository, client, request, personId);
		return responseMapper.mapperToSource(createAddressFacade.execute());
	}

	public List<AddressResponse> findAll(Long personId) {
		final FindAddressUseCase useCase = new FindAddressUseCase();
		return responseMapper.mapperToSource(useCase.findAll(personId, repository));
	}

	public String delete(final long personId) {
		final FindAddressUseCase useCase = new FindAddressUseCase();
		final DeleteAddressUseCase deleteCase = new DeleteAddressUseCase();
		List<Long> list = useCase.findAll(personId, repository).parallelStream().map(AddressEntity::getId).toList();

		if (list.isEmpty()) throw new AddressDeleteException("Nenhum endereço para deletar");

		deleteCase.delete(list, repository);

		return "Addresses deleted successfully. Id´s: " + list;
	}

}
