package com.br.pessoas.infra.converter.impl;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.model.request.PersonDataProviderRequest;

public class PersonEntityToRequestConverter implements Converter<PersonDataProviderRequest, PersonEntity> {
    @Override
    public PersonDataProviderRequest convert(PersonEntity source) {
        return null;
    }
}
