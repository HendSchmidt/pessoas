package com.br.pessoas.infra.dataProvider.repository.impl;

import com.br.pessoas.infra.dataProvider.DataProvider;
import com.br.pessoas.infra.dataProvider.repository.AdressRepository;
import com.br.pessoas.infra.dataProvider.repository.model.AdressModel;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdressDataProviderRepository implements DataProvider<AdressModel> {

    @Autowired
    private AdressRepository repository;

    @Override
    public AdressModel save(AdressModel source) {
        return repository.save(source);
    }

    @Override
    public AdressModel get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    @Override
    public List<AdressModel> getAll() {
        return repository.findAll();
    }
}
