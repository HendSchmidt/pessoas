package com.br.pessoas.infra.converter.impl;

import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.model.request.PersonDataProviderRequest;
import com.br.pessoas.infra.model.response.PersonDataProviderResponse;

public class PersonRequestToResponseConverter implements Converter <PersonDataProviderResponse, PersonDataProviderRequest> {
    @Override
    public PersonDataProviderResponse convert(PersonDataProviderRequest source) {
        return null;
    }
}
