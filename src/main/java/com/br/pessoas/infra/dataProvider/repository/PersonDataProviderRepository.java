package com.br.pessoas.infra.dataProvider.repository;

import com.br.pessoas.infra.dataProvider.DataProvider;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDataProviderRepository implements DataProvider {

   @Autowired
   private PersonRepository repository;

    @Override
    public PersonModel savePerson(PersonModel source) {
        return repository.save(source);
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
