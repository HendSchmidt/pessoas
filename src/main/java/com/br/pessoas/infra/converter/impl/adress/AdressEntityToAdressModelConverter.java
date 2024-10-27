package com.br.pessoas.infra.converter.impl.adress;

import com.br.pessoas.domain.entity.AdressEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.repository.model.AdressModel;

public class AdressEntityToAdressModelConverter implements Converter<AdressModel, AdressEntity> {
    @Override
    public AdressModel convert(AdressEntity entity) {
        return new AdressModel(entity.getPersonId(), entity.getCep(), entity.getLogradouro()
                , entity.getComplemento(), entity.getBairro(), entity.getNumero()
                , entity.getCidade(), entity.getUf());
    }
}
