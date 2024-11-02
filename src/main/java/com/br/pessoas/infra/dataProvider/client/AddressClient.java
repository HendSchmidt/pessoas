package com.br.pessoas.infra.dataProvider.client;

import com.br.pessoas.infra.converter.impl.adress.AddressClientResponseToAddressModel;
import com.br.pessoas.infra.dataProvider.client.response.AddressClientResponse;
import com.br.pessoas.infra.dataProvider.repository.model.AddressModel;
import com.br.pessoas.infra.dataProvider.strategy.GetAddressStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@Component
public class AddressClient implements GetAddressStrategy {

	@Autowired
	private RestTemplate restTemplate;

    @Autowired
	private AddressClientResponseToAddressModel toAddressModel;
	@Override
	public List<AddressModel> getAllPersonAdress(Long id) {
		try {
			ResponseEntity<AddressClientResponse> response = restTemplate.getForEntity(URI.create("https://opencep.com/v1/04875000"), AddressClientResponse.class);
			return List.of(toAddressModel.convert(Objects.requireNonNull(response.getBody())));
		} catch (RestClientException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
