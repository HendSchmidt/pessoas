package com.br.pessoas.infra.converter.impl.adress;

import com.br.pessoas.domain.entity.AdressEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.repository.model.AdressModel;

public class AdressModelToAdressEntityConverter implements Converter<AdressEntity, AdressModel> {
    @Override
    public AdressEntity convert(AdressModel model) {
        return new AdressEntity(model.getPersonId(), model.getId(), model.getCep(), model.getLogradouro()
                , model.getComplemento(), model.getBairro(), model.getNumero()
                , model.getCidade(), model.getUf());
    }
}
