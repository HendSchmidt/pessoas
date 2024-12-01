package com.br.pessoas.infra.dataProvider.client;

import com.br.pessoas.infra.converter.impl.adress.AddressClientResponseToModelConverter;
import com.br.pessoas.infra.dataProvider.client.dto.AddressClientResponse;
import com.br.pessoas.infra.dataProvider.repository.model.AddressModel;
import com.br.pessoas.useCase.exception.AddressRecoveryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@Component
public class AddressClient {

	private final RestTemplate restTemplate;
	private final AddressClientResponseToModelConverter toAddressModel;


	@Autowired
	AddressClient() {
		this.restTemplate = new RestTemplate();
		this.toAddressModel = new AddressClientResponseToModelConverter();
	}

	@Cacheable(value = "AddressClientResponse", key = "#cep" )
	public Optional<AddressModel> findAddress(final String cep) {
		try {
			ResponseEntity<AddressClientResponse> response = restTemplate.getForEntity(URI.create("https://opencep.com/v1/" + cep), AddressClientResponse.class);
			return Optional.of(toAddressModel.convert(Objects.requireNonNull(response.getBody())));
		} catch (RestClientException e) {
			throw new AddressRecoveryException("Endereço não localizado através do cep informado.");
		}
	}
}
