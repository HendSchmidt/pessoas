package com.br.pessoas.infra.dataProvider.client;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.dataProvider.DataProvider;
import com.br.pessoas.infra.model.request.PersonDataProviderRequest;
import com.br.pessoas.infra.model.response.PersonDataProviderResponse;
import org.springframework.stereotype.Component;

import java.util.List;

public class PersonDataProviderClient implements DataProvider {

    @Override
    public PersonEntity savePerson(PersonEntity source) {
        return null;
    }

    @Override
    public PersonEntity getPerson(PersonEntity source) {
        return null;
    }

    @Override
    public List<PersonEntity> getAllPerson() {
        return List.of();
    }
}
