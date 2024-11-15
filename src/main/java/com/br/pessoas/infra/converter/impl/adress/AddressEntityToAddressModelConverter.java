package com.br.pessoas.infra.converter.impl.adress;

import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.repository.model.AddressModel;

public class AddressEntityToAddressModelConverter implements Converter<AddressModel, AddressEntity> {
    @Override
    public AddressModel convert(AddressEntity entity) {
        return new AddressModel(entity.getPersonId(), entity.getCep(), entity.getLogradouro()
                , entity.getComplemento(), entity.getBairro(), entity.getNumero()
                , entity.getCidade(), entity.getUf(), entity.getDescription());
    }
}
