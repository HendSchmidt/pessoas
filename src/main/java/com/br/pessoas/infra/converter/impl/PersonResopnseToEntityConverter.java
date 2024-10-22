package com.br.pessoas.infra.converter.impl;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.model.response.PersonDataProviderResponse;

public class PersonResopnseToEntityConverter implements Converter<PersonEntity, PersonDataProviderResponse> {
    @Override
    public PersonEntity convert(PersonDataProviderResponse source) {
        return null;
    }
}
