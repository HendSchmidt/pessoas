package com.br.pessoas.infra.dataProvider.client;

import com.br.pessoas.infra.converter.impl.adress.AddressClientResponseToAddressModel;
import com.br.pessoas.infra.dataProvider.client.dto.AddressClientResponse;
import com.br.pessoas.infra.dataProvider.repository.model.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@Component
public class AddressClient {

	private RestTemplate restTemplate;
	private AddressClientResponseToAddressModel toAddressModel;


	@Autowired
	AddressClient(){
		this.restTemplate = new RestTemplate();
		this.toAddressModel = new AddressClientResponseToAddressModel();
	}

	public Optional<AddressModel> getAddress(String cep) {
		try {
			ResponseEntity<AddressClientResponse> response = restTemplate.getForEntity(URI.create("https://opencep.com/v1/" + cep), AddressClientResponse.class);
			return Optional.of(toAddressModel.convert(Objects.requireNonNull(response.getBody())));
		} catch (RestClientException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
