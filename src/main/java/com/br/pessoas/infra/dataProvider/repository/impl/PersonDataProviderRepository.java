package com.br.pessoas.infra.dataProvider.repository.impl;

import com.br.pessoas.infra.dataProvider.DataProvider;
import com.br.pessoas.infra.dataProvider.repository.PersonRepository;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDataProviderRepository implements DataProvider<PersonModel> {

   @Autowired
   private PersonRepository repository;

    @Override
    public PersonModel save(PersonModel source) {
        return repository.save(source);
    }

    @Override
    public PersonModel get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não localizada."));
    }

    @Override
    public List<PersonModel> getAll() {
        return repository.findAll();
    }
}
