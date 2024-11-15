package com.br.pessoas.app.service.facade;

import com.br.pessoas.app.dto.AddressRequest;
import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.converter.impl.adress.AddressModelToAddressEntityConverter;
import com.br.pessoas.infra.dataProvider.client.AddressClient;
import com.br.pessoas.infra.dataProvider.repository.impl.AddressRepositoryImpl;
import com.br.pessoas.infra.dataProvider.repository.model.AddressModel;
import com.br.pessoas.useCase.CreateAddressUseCase;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateAddressFacade implements Facade<AddressEntity> {
	private AddressRepositoryImpl repository;
	private  AddressClient client;
	private  Long personId;
	private  CreateAddressUseCase createAddressUseCase;
	private  AddressRequest request;
	private AddressModelToAddressEntityConverter converterToEntity;

	public void setFacadeRules(final AddressRepositoryImpl repository, final AddressClient client, final AddressRequest request, final Long personId) {
		this.repository = repository;
		this.client = client;
		this.request = request;
		this.personId = personId;
		this.createAddressUseCase = new CreateAddressUseCase();
		this.converterToEntity = new AddressModelToAddressEntityConverter();
	}

	@Override
	public AddressEntity execute() {
		/*TODO
		*  Validar optional e lançar exceção de negocio*/
		final Optional<AddressModel> address = client.getAddress(request.getCep());
		address.get().setPersonId(personId);
		address.get().setComplemento(request.getComplemento());
		address.get().setDescription(request.getDescription());
		return createAddressUseCase.createAdress(converterToEntity.convert(address.get()), repository);
	}
}
