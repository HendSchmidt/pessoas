package com.br.pessoas.app.mapper.impl;

import com.br.pessoas.app.dto.AddressResponse;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AdressResponseMapper implements Mapper<AddressEntity, AddressResponse> {
    @Override
    public AddressEntity mapperToTarget(AddressResponse response) {
        return new AddressEntity(response.getPersonId(), response.getId()
                ,response.getCep(), response.getLogradouro()
                ,response.getComplemento(), response.getBairro()
                ,response.getNumero(), response.getCidade(), response.getUf());
    }

    @Override
    public AddressResponse mapperToSource(AddressEntity entity) {
        return new AddressResponse(entity.getPersonId(), entity.getId(), entity.getCep()
                , entity.getLogradouro(), entity.getComplemento(), entity.getBairro()
                , entity.getNumero(), entity.getCidade(), entity.getUf());
    }
}
