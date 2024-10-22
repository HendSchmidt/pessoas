package com.br.pessoas.infra.dataProvider.repository;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.dataProvider.DataProvider;
import com.br.pessoas.infra.model.request.PersonDataProviderRequest;
import com.br.pessoas.infra.model.response.PersonDataProviderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class PersonDataProviderRepository implements DataProvider {

   @Autowired
   private PersonRepository repository;

    @Override
    public PersonEntity savePerson(PersonEntity source) {
        return repository.save(source);
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
