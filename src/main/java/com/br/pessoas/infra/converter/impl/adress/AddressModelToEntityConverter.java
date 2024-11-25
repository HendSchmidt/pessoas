package com.br.pessoas.infra.converter.impl.adress;

import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.repository.model.AddressModel;

public class AddressModelToEntityConverter implements Converter<AddressEntity, AddressModel> {
    @Override
    public AddressEntity convert(AddressModel model) {
        return new AddressEntity(model.getPersonId(), model.getId(), model.getCep(), model.getLogradouro()
                , model.getComplemento(), model.getBairro(), model.getNumero()
                , model.getCidade(), model.getUf(), model.getDescription());
    }
}
