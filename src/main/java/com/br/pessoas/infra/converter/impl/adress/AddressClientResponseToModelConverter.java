package com.br.pessoas.infra.converter.impl.adress;

import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.client.dto.AddressClientResponse;
import com.br.pessoas.infra.dataProvider.repository.model.AddressModel;

public class AddressClientResponseToModelConverter implements Converter<AddressModel, AddressClientResponse> {
	@Override
	public AddressModel convert(AddressClientResponse response) {
		AddressModel model = new AddressModel();
		model.setCep(response.getCep());
		model.setLogradouro(response.getLogradouro());
		model.setComplemento(response.getComplemento());
		model.setBairro(response.getBairro());
		model.setCidade(response.getLocalidade());
		model.setUf(response.getUf());
		return model;
	}
}
