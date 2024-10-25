package com.br.pessoas.infra.dataProvider.client;

import com.br.pessoas.infra.dataProvider.DataProvider;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;

import java.util.List;

public class PersonDataProviderClient implements DataProvider {

    @Override
    public PersonModel savePerson(PersonModel source) {
        return null;
    }

    @Override
    public PersonModel getPerson(PersonModel source) {
        return null;
    }

    @Override
    public List<PersonModel> getAllPerson() {
        return List.of();
    }
}
