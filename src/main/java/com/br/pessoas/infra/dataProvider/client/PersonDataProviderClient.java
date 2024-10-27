package com.br.pessoas.infra.dataProvider.client;

import com.br.pessoas.infra.dataProvider.DataProvider;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;

import java.util.List;

public class PersonDataProviderClient implements DataProvider<PersonModel> {

    @Override
    public PersonModel save(PersonModel source) {
        return null;
    }

    @Override
    public PersonModel get(Long id) {
        return null;
    }

    @Override
    public List<PersonModel> getAll() {
        return List.of();
    }
}
