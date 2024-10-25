package com.br.pessoas.app.mapper.impl;

import com.br.pessoas.app.dto.AdressRequest;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.AdressEntity;
import org.springframework.stereotype.Component;

@Component
public class AdressRequestMapper implements Mapper<AdressEntity, AdressRequest> {

    @Override
    public AdressEntity mapperToTarget(AdressRequest request) {
        return new AdressEntity(request.getId()
        ,request.getCep(), request.getLogradouro()
        ,request.getComplemento(), request.getBairro()
        ,request.getNumero(), request.getCidade(), request.getUf());
    }

    @Override
    public AdressRequest mapperToSource(AdressEntity entity) {
        return new AdressRequest(entity.getId(), entity.getCep()
        , entity.getLogradouro(), entity.getComplemento(), entity.getBairro()
        , entity.getNumero(), entity.getCidade(), entity.getUf());
    }
}
