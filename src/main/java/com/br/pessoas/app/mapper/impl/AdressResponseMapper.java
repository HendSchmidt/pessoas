package com.br.pessoas.app.mapper.impl;

import com.br.pessoas.app.dto.AdressRequest;
import com.br.pessoas.app.dto.AdressResponse;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.AdressEntity;
import org.springframework.stereotype.Component;

@Component
public class AdressResponseMapper implements Mapper<AdressEntity, AdressResponse> {
    @Override
    public AdressEntity mapperToTarget(AdressResponse response) {
        return new AdressEntity(response.getId()
                ,response.getCep(), response.getLogradouro()
                ,response.getComplemento(), response.getBairro()
                ,response.getNumero(), response.getCidade(), response.getUf());
    }

    @Override
    public AdressResponse mapperToSource(AdressEntity entity) {
        return new AdressResponse(entity.getId(), entity.getCep()
                , entity.getLogradouro(), entity.getComplemento(), entity.getBairro()
                , entity.getNumero(), entity.getCidade(), entity.getUf());
    }
}
