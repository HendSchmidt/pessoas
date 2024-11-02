package com.br.pessoas.infra.dataProvider.repository.impl;

import com.br.pessoas.infra.dataProvider.repository.PersonRepository;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonRepositoryImpl {
    @Autowired @Lazy
    private PersonRepository repository;

    public PersonModel save(PersonModel source) {
        return repository.save(source);
    }

    public PersonModel get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não localizada."));
    }

    public List<PersonModel> getAll() {
        return repository.findAll();
    }
}
