package com.br.pessoas.infra.dataProvider.facade;

import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.dataProvider.client.AddressClient;
import com.br.pessoas.infra.dataProvider.repository.impl.AdressRepositoryImpl;
import com.br.pessoas.useCase.GetAddressUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GetAddressFacade implements Facade<AddressEntity> {
	private  AdressRepositoryImpl repository;
	private  AddressClient client;
	private  Long personId;
	private  GetAddressUseCase getAdressUseCase;
	private String cep;

	public void setFacadeRules(AdressRepositoryImpl repository, AddressClient client, Long personId) {
		this.repository = repository;
		this.client = client;
		this.personId = personId;
		this.getAdressUseCase = new GetAddressUseCase();
	}

	@Override
	public List<AddressEntity> execute() {
		final List<AddressEntity> address = getAdressUseCase.getAllPersonAddress(personId,repository);

		if(address.isEmpty())
			address.addAll(getAdressUseCase.getAllPersonAddress(null,client));

		return address;
	}
}
