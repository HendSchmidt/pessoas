package com.br.pessoas.app.mapper.impl;

import com.br.pessoas.app.dto.AddressRequest;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AdressRequestMapper implements Mapper<AddressEntity, AddressRequest> {

    @Override
    public AddressEntity mapperToTarget(AddressRequest request) {
        return new AddressEntity(request.getPersonId(), request.getId()
        ,request.getCep(), request.getLogradouro()
        ,request.getComplemento(), request.getBairro()
        ,request.getNumero(), request.getCidade(), request.getUf());
    }

    @Override
    public AddressRequest mapperToSource(AddressEntity entity) {
        return new AddressRequest(entity.getPersonId(), entity.getId(), entity.getCep()
        , entity.getLogradouro(), entity.getComplemento(), entity.getBairro()
        , entity.getNumero(), entity.getCidade(), entity.getUf());
    }
}
